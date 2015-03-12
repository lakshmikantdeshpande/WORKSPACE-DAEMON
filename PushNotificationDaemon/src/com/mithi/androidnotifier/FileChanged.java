package com.mithi.androidnotifier;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
 
public class FileChanged extends FileAlterationListenerAdaptor
{
    @Override
    public void onFileCreate(final File file) {

    	System.out.println(file.getAbsoluteFile() + " Dis file got created");
    	try
    	{
    		makepost(file.getAbsoluteFile().toString());
    	}
    	catch(Exception e)
    	{
    		System.out.println("\nHTTP POST request failed....");
    	}
    }
    
    public void makepost(String filename) throws Exception
    {
    	String data = URLEncoder.encode("smscenter", "UTF-8") + "=" + URLEncoder.encode(filename, "UTF-8");
        data += "&" + URLEncoder.encode("text", "UTF-8") + "=" + URLEncoder.encode(filename, "UTF-8");
        data += "&" + URLEncoder.encode("phone", "UTF-8") + "=" + URLEncoder.encode("2112315", "UTF-8");

        URL url = new URL("http://localhost:80/sachin/smstodb.php");
        URLConnection conn = url.openConnection();
        conn.setDoOutput(true);
        OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
        wr.write(data);
        wr.flush();

        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
          System.out.println(line);
        }
        wr.close();
        rd.close();
    }
}
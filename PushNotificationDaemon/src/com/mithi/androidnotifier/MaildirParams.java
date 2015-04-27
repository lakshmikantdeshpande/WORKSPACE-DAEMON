package com.mithi.androidnotifier;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MaildirParams 
{
    @SuppressWarnings("resource")
	public static void main(String[] args) throws Exception 
    {

        Pattern pattern = Pattern.compile("[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}");
        
        try
        {
	        File file = new File(args[0]);
	        BufferedReader in = new BufferedReader(new FileReader(file));
	        String email;
	        int lines = 0;
	        int matches = 0;
	        for (email = in.readLine(); email != null; email = in.readLine()) 
	        {
	            lines++;
	            Matcher matcher = pattern.matcher(email.toUpperCase());
	            if (matcher.matches()) 
	            {    
	                matches++;
	                //For now, we are considering only one instance of email address in the file
	                break;
	            }
	        }
	        
	        if (matches == 0) {    
	            System.out.println("Could not find any valid email address in the given file " + args[0]);
	        }
	        else
	        {
	        	System.out.println(email +"      << found at line number "+lines );
	        	System.out.println("Starting folder monitor on " + args[1]);
	        	//"C:\\Users\\Sachin\\Desktop"
	        	FileMonitor.main(new String[]{email,args[1].toString()});
	        }
        }
        catch(Exception e)
        {
        	System.out.println("Sorry, could not find " + args[0]);
        	System.out.println("Exception : " + e.toString());
        }
    }
}   
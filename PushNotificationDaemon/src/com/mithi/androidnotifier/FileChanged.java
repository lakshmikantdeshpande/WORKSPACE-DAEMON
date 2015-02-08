package com.mithi.androidnotifier;

import java.io.File;

import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
 
public class FileChanged extends FileAlterationListenerAdaptor
{
    @Override
    public void onFileCreate(final File file) {

    	System.out.println(file.getAbsoluteFile() + " Dis file got created");
    
    }
}
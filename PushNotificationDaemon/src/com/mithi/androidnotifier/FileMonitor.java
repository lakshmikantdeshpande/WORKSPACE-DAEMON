package com.mithi.androidnotifier;

import java.io.File;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;
 
/*
 * Author : Lakshmikant A. Deshpande
 */
public class FileMonitor {
 
    public static void main(String[] args) throws Exception {
 
        final File directory = new File("C:\\Users\\Sachin\\Desktop");
        FileAlterationObserver fao = new FileAlterationObserver(directory);
        fao.addListener(new FileChanged());
        
        final FileAlterationMonitor monitor = new FileAlterationMonitor();
        monitor.addObserver(fao);
        System.out.println("Hello there :)  ");
        monitor.start();
 
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
 
            @Override
            public void run() {
                try {
                    monitor.stop();
                } catch (Exception e) {
                }
            }
        }));
    }
}
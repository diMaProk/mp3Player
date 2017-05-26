package com.gmail.pdv.mp3player.utils;

import java.io.File;
import javax.swing.filechooser.FileFilter;


public class MP3PlayerFileFilter extends FileFilter{

    private String fileExtension;
    private String fileDescription;

    public MP3PlayerFileFilter(String fileExtension, String fileDescription) {
        this.fileExtension = fileExtension;
        this.fileDescription = fileDescription;
    }
    
    
    
    @Override
    public boolean accept(File f) { //accept only folders and mp3 files
        return f.isDirectory() || f.getAbsolutePath().endsWith(fileExtension) ;

    }

    @Override
    public String getDescription() { // description for mp3 file for selection in dialog window
        return fileDescription + " (*." + fileExtension + ")";
    }
    

}

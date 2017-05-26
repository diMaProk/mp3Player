package com.gmail.pdv.mp3player.objects;

import com.gmail.pdv.mp3player.utils.FileUtils;
import java.io.Serializable;


public class MP3 implements Serializable {
    
    private final String name;
    private final String path;

    public MP3(String name, String path) {
        this.name = name;
        this.path = path;
    }

    @Override
    public String toString() {
        return FileUtils.getFileNameWithoutExtension (name);
    }

    public String getPath() {
        return path;
    }

    public String getName() {
        return name;
    }
    
    

    
   
    

}

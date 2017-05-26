package com.gmail.pdv.mp3player.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;


public class FileUtils {
    
    //remove current file filter and set new new one recived in paremeters - ff
    public static void addFileEilter (JFileChooser jfc, FileFilter ff){
        jfc.removeChoosableFileFilter(jfc.getFileFilter());
        jfc.setFileFilter(ff);
        jfc.setSelectedFile(new File("")); //delete name of last opened/saved file
        
    }

    public static String getFileNameWithoutExtension(String fileName) {
        File file = new File (fileName);
        int index = file.getName().indexOf('.');
        if (index > 0 && index <= file.getName().length() - 2){
            return file.getName().substring(0, index);
        }
        return "noname";
    }
    
    public static String getFileExtension (File f){
        String ext = null;
        String name = f.getName();
        int index = name.lastIndexOf('.');
        
        if (index > 0 && index < name.length() -1){
            ext = name.substring(index + 1).toLowerCase();
        }
        return ext;
    }

    public static void serialize(Object obj, String fileNameForSave) {
        try (FileOutputStream fos = new FileOutputStream(fileNameForSave);
                ObjectOutputStream oos = new ObjectOutputStream(fos)){
            oos.writeObject(obj);
        } catch (IOException ex) {
            Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static Object deserialize (String fileName){
        try (FileInputStream fis = new FileInputStream(fileName);
                ObjectInputStream ois = new ObjectInputStream(fis)){
            Object ts = (Object) ois.readObject();
            return ts;
            
        }catch (ClassNotFoundException | IOException ex) {
            Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

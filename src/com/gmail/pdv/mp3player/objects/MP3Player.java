package com.gmail.pdv.mp3player.objects;

//class responsible for playing mp3 files

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;

public class MP3Player {
    
    private BasicPlayer player = new BasicPlayer();
    
    private String currentFileName;
    private double currentVolumeValue;
    
    public void play (String fileName){
        try{
            //if start track that was pused
            if (currentFileName != null && currentFileName.equals(fileName) && player.getStatus() == BasicPlayer.PAUSED){
                player.resume();
                return;
            }
            
            currentFileName = fileName;
            player.open(new File(fileName));
            player.play();
            player.setGain(currentVolumeValue); //set volume level
            
        } catch (BasicPlayerException ex) {
            Logger.getLogger(MP3Player.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void stop(){
        try {
            player.stop();
        } catch (BasicPlayerException ex) {
            Logger.getLogger(MP3Player.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void pause(){
        try {
            player.pause();
        } catch (BasicPlayerException ex) {
            Logger.getLogger(MP3Player.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setVolume(int currentValue, int maximumValue){
        try{
            this.currentVolumeValue = currentValue;
            
            if (currentValue == 0){
                player.setGain(0);
            } else{
                player.setGain(calcVolume (currentValue, maximumValue));
            }
        } catch (BasicPlayerException ex) {
            Logger.getLogger(MP3Player.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    //calculate volume value according to JSlider value
    private double calcVolume(int currentValue, int maximumValue) {
        currentVolumeValue = (double) currentValue / (double) maximumValue;
        return currentVolumeValue;
    }

}

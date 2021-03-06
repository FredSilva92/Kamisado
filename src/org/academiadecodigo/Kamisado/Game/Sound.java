package org.academiadecodigo.Kamisado.Game;

import javax.sound.sampled.*;
import java.io.File;

public class Sound {

    private String path;
    private Clip audioClip;
    private AudioInputStream audioStrmObj;

    public Sound(String path){
        try {
            this.path = path;
        }
        catch (Exception ex){
            ex.getMessage();
        }

    }

    public void open(){
        try {
            File clipFile = new File(this.path); // path to your clip
            audioStrmObj = AudioSystem.getAudioInputStream(clipFile);
            AudioFormat format = audioStrmObj.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            audioClip = (Clip) AudioSystem.getLine(info);

            audioClip.open(audioStrmObj);
            audioClip.start();
        }
        catch (Exception ex){
            ex.getMessage();
        }
    }



    public void close() {
        try {
            audioClip.close();
            audioStrmObj.close();
        }
        catch (Exception ex){
            ex.getMessage();
        }
    }
}

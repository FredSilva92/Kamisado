import javax.sound.sampled.*;
import java.io.File;

public class Sound {

    private String audioFilePath;
    private Clip audioClip;
    private AudioInputStream audioStrmObj;

    public Sound(String path){
        try {
            audioFilePath = path;
            File clipFile = new File(audioFilePath); // path to your clip
            audioStrmObj = AudioSystem.getAudioInputStream(clipFile);
            AudioFormat format = audioStrmObj.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            audioClip = (Clip) AudioSystem.getLine(info);
        }
        catch (Exception ex){
            ex.getMessage();
        }

    }

    public void open(){
        try {
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

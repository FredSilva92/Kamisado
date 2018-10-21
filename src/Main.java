import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        Game g = new Game();

        MoveEvents moveEvents = new MoveEvents(g);
        moveEvents.test();





    }

}

import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;

import org.academiadecodigo.simplegraphics.mouse.Mouse;

public class MoveEvents implements MouseHandler {


    Game game;

    public MoveEvents(Game game){
        this.game = game;
    }


    public void test() throws InterruptedException {

        Mouse m = new Mouse(this);

        m.addEventListener(MouseEventType.MOUSE_CLICKED);
        m.addEventListener(MouseEventType.MOUSE_MOVED);


    }



    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        System.out.println("clicked");
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        System.out.println("moved");
    }
}

import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;

import org.academiadecodigo.simplegraphics.mouse.Mouse;

import javax.sound.sampled.LineUnavailableException;
import java.io.IOException;

public class MoveEvents implements MouseHandler {


    Game game;

    public MoveEvents(Game game) {
        this.game = game;
    }


    public void test(){

        Mouse m = new Mouse(this);

        m.addEventListener(MouseEventType.MOUSE_CLICKED);

    }

    boolean onMenu = true;
    boolean onRules = false;

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

        if(game.isWinner()){
            System.out.println("Winner");
            game.resetMenu();

            onMenu = true;
        }
        if(onMenu) {
            if (mouseEvent.getX() > game.getStart().getX() && mouseEvent.getX() < game.getStart().getX() + game.getStart().getWidth()
                    && mouseEvent.getY() > game.getStart().getY() && mouseEvent.getY() < game.getStart().getY() + game.getStart().getHeight()) {

                System.out.println("here?");

                game.start();
                onMenu = false;

            }


            else if (mouseEvent.getX() > game.getRules().getX() && mouseEvent.getX() < game.getRules().getX() + game.getRules().getWidth()
                    && mouseEvent.getY() > game.getRules().getY() && mouseEvent.getY() < game.getRules().getY() + game.getRules().getHeight()) {
                game.rulesMenu();

                onMenu = false;
                onRules = true;
            }
            return;
        }

        if (onRules){
            if (mouseEvent.getX() > -1 && mouseEvent.getY()> -1){
                game.menu();

                onMenu = true;
                onRules = false;
            }
            return;
        }


        game.moveClick(mouseEvent.getX(), mouseEvent.getY());

}

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        System.out.println("moved");
    }

}

package org.academiadecodigo.Kamisado.Game;

import org.academiadecodigo.Kamisado.Game.Game;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;

import org.academiadecodigo.simplegraphics.mouse.Mouse;

public class MoveEvents implements MouseHandler {


    private Game game;
    private boolean onMenu;
    private boolean onRules;

    public MoveEvents(Game game) {
        this.game = game;
        onMenu = true;
        onRules = false;
    }


    public void test() {

        Mouse m = new Mouse(this);
        m.addEventListener(MouseEventType.MOUSE_CLICKED);

    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

        if (game.isWinner()) {

            game.resetMenu();
            onMenu = true;
        }
        if (onMenu) {
            if (mouseEvent.getX() > game.getStart().getX() && mouseEvent.getX() < game.getStart().getX() + game.getStart().getWidth()
                    && mouseEvent.getY() > game.getStart().getY() && mouseEvent.getY() < game.getStart().getY() + game.getStart().getHeight()) {

                System.out.println("here?");

                game.start();
                onMenu = false;

            } else if (mouseEvent.getX() > game.getRules().getX() && mouseEvent.getX() < game.getRules().getX() + game.getRules().getWidth()
                    && mouseEvent.getY() > game.getRules().getY() && mouseEvent.getY() < game.getRules().getY() + game.getRules().getHeight()) {
                game.rulesMenu();

                onMenu = false;
                onRules = true;
            }
            return;
        }

        if (onRules) {
            if (mouseEvent.getX() > -1 && mouseEvent.getY() > -1) {
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
    }

}

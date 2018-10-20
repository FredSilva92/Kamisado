import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;

import org.academiadecodigo.simplegraphics.mouse.Mouse;

public class MoveEvents implements MouseHandler {


    Game game;

    public MoveEvents(Game game) {
        this.game = game;
    }


    public void test() throws InterruptedException {

        Mouse m = new Mouse(this);

        m.addEventListener(MouseEventType.MOUSE_CLICKED);

    }

    boolean onMenu = true;

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

        if(onMenu){
            if(mouseEvent.getX() > game.getStart().getX() && mouseEvent.getX() < game.getStart().getX() + game.getStart().getWidth()
                && mouseEvent.getY() > game.getStart().getY() && mouseEvent.getY() < game.getStart().getY() + game.getStart().getHeight()){

                System.out.println("here?");

                game.start();
                onMenu = false;

            }

            return;
        }

        game.moveClick(mouseEvent.getX(), mouseEvent.getY());

    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        System.out.println("moved");
    }




    /*
    private boolean firstClick = true;
    private int Xi;
    private int Yi;
    private int Xf;
    private int Yf;
    private int adjust = 24;
    private boolean movable;
    private boolean firstMoveCheck;


    private void moveClick(double x, double y){

        if (!firstMoveCheck) {
            if (firstClick) {
                System.out.println("1");
                Xi = (int) (x - game.grid.PADDING) / game.grid.CELL_SIZE;
                Yi = (int) (y - game.grid.PADDING - adjust) / game.grid.CELL_SIZE;
                if (Yi == 0) {
                    System.out.println("2");
                    firstClick = false;
                }


            } else {
                System.out.println("3");
                Xf = (int) (x - game.grid.PADDING) / game.grid.CELL_SIZE;
                Yf = (int) (y - game.grid.PADDING - adjust) / game.grid.CELL_SIZE;


                firstMoveCheck = game.player1.firstMove(Xi, Yi, Xf, Yf);

                if(firstMoveCheck){
                    game.player2.setCurrentPawn(Xf, Yf);
                    System.out.println(game.player2.getCurrentPawn().getColor());

                }


                firstClick = true;

                game.setCurrentPlayer(2);

            }
        } else {
            System.out.println("4");
            Xi = (int) (x - game.grid.PADDING) / game.grid.CELL_SIZE;
            Yi = (int) (y - game.grid.PADDING - adjust) / game.grid.CELL_SIZE;
            if (game.currentPlayer == 1) {
                game.player1.move(Xi, Yi);
                game.setCurrentPlayer(2);
            } else {
                game.player2.move(Xi, Yi);
                game.setCurrentPlayer(1);
            }
        }
    }
    */

}

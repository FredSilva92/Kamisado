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


    private boolean firstClick = true;
    private int Xi;
    private int Yi;
    private int Xf;
    private int Yf;
    private int Xd;
    private int Yd;
    private int adjust = 24;
    private boolean movable;
    private boolean firstMoveCheck;


    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

        if (!firstMoveCheck) {
            if (firstClick) {
                System.out.println("1");
                Xi = (int) (mouseEvent.getX() - game.grid.PADDING) / game.grid.CELL_SIZE;
                Yi = (int) (mouseEvent.getY() - game.grid.PADDING - adjust) / game.grid.CELL_SIZE;
                if (Yi == 0) {
                    System.out.println("2");
                    firstClick = false;
                }


            } else {
                System.out.println("3");
                Xf = (int) (mouseEvent.getX() - game.grid.PADDING) / game.grid.CELL_SIZE;
                Yf = (int) (mouseEvent.getY() - game.grid.PADDING - adjust) / game.grid.CELL_SIZE;
                Xd = Xf - Xi;
                Yd = Yf - Yi;

                firstMoveCheck = game.player1.firstMove(Xi, Yi, Xf, Yf);

                firstClick = true;

            }
        } else {
            System.out.println("4");
            Xi = (int) (mouseEvent.getX() - game.grid.PADDING) / game.grid.CELL_SIZE;
            Yi = (int) (mouseEvent.getY() - game.grid.PADDING - adjust) / game.grid.CELL_SIZE;
            if (game.currentPlayer == 1) {
                game.player1.move(Xi, Yi);
                game.setCurrentPlayer(2);
            } else {
                game.player2.move(Xi, Yi);
                game.setCurrentPlayer(1);
            }
        }

    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        System.out.println("moved");
    }
}

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


    }



    private boolean firstClick = true;
    private int Xi;
    private int Yi;
    private int Xf;
    private int Yf;
    private int Xd;
    private int Yd;
    private int adjust = 24;


    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        System.out.println("clicked");
        if(firstClick){
            Xi = (int)(mouseEvent.getX() - game.grid.PADDING)/game.grid.CELL_SIZE;
            Yi = (int)(mouseEvent.getY() - game.grid.PADDING - adjust)/game.grid.CELL_SIZE;
            System.out.println("\nFirst click. Xi = " + Xi + "; Yi = " + Yi);
            firstClick = false;
        }else{
            Xf = (int)(mouseEvent.getX() - game.grid.PADDING)/game.grid.CELL_SIZE;
            Yf = (int)(mouseEvent.getY() - game.grid.PADDING - adjust)/game.grid.CELL_SIZE;
            Xd = Xf - Xi;
            Yd = Yf - Yi;
            System.out.println("\nSecond click. Xf = " + Xf + "; Yf = " + Yf);
            System.out.println(Xd + " " + Yd);
            firstClick = true;
        }

    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        System.out.println("moved");
    }
}

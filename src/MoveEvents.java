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
    private double Xi;
    private double Yi;
    private double Xf;
    private double Yf;
    private int Xd;
    private int Yd;


    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        System.out.println("clicked");
        if(firstClick){
            Xi = (mouseEvent.getX() - game.grid.PADDING)/game.grid.CELL_SIZE;
            Yi = (mouseEvent.getY() - game.grid.PADDING)/game.grid.CELL_SIZE;
            System.out.println("\nFirst click. Xi = " + Xi + "; Yi = " + Yi);
            firstClick = false;
        }else{
            Xf = (mouseEvent.getX() - game.grid.PADDING)/game.grid.CELL_SIZE;
            Yf = (mouseEvent.getY() - game.grid.PADDING)/game.grid.CELL_SIZE;
            Xd = (int)(Xf - Xi);
            Yd = (int)(Yf - Yi);
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

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {

    private Player player1;
    private Player player2;
    private Grid grid;
    int currentPlayer = 1;

    private Picture[] blackPawnPictures;
    private Picture[] whitePawnPictures;

    Game() {
        grid = new Grid(8, 8);
        player1 = new Player("José", grid, 1, this);
        player2 = new Player("Alberto", grid, 2, this);
        blackPawnPictures = new Picture[8];
        whitePawnPictures = new Picture[8];
        drawPawns();

    }

    public void start() {


    }


    private void drawPawns() {
        String pathBlack = "resources/black_";
        String pathWhite = "resources/white_";
        String[] paths = {"orange.png", "blue.png", "purple.png", "pink.png", "yellow.png", "red.png", "green.png", "brown.png",};

        for(int i = 0; i < blackPawnPictures.length; i++){

            blackPawnPictures[i] = new Picture(grid.PADDING + grid.CELL_SIZE * i, grid.PADDING, pathBlack + paths[i]);
            blackPawnPictures[i].grow(-10, -10);
            blackPawnPictures[i].draw();

            whitePawnPictures[i] = new Picture(grid.PADDING + grid.CELL_SIZE * i, grid.PADDING + grid.CELL_SIZE * 7, pathWhite + paths[7 - i]);
            whitePawnPictures[i].grow(-10, -10);
            whitePawnPictures[i].draw();
        }
    }



    boolean firstClick = true;
    int Xi;
    int Yi;
    int Xf;
    int Yf;
    int adjust = 24;
    boolean movable;
    boolean firstMoveCheck = false;

    public void moveClick(double x, double y){


        if (!firstMoveCheck) {
            if (firstClick) {
                System.out.println("1");
                Xi = (int) (x - grid.PADDING) / grid.CELL_SIZE;
                Yi = (int) (y - grid.PADDING - adjust) / grid.CELL_SIZE;
                if (Yi == 7) {
                    System.out.println("2");
                    firstClick = false;
                }


            }else{
                System.out.println("3");
                Xf = (int) (x - grid.PADDING) / grid.CELL_SIZE;
                Yf = (int) (y - grid.PADDING - adjust) / grid.CELL_SIZE;


                firstMoveCheck = player1.firstMove(Xi, Yi, Xf, Yf);

                if(firstMoveCheck){
                    player2.setCurrentPawn(Xf, Yf);
                    System.out.println(player2.getCurrentPawn().getColor());

                }


                firstClick = true;

                setCurrentPlayer(2);

            }
        }else{
            System.out.println("4");
            Xi = (int) (x - grid.PADDING) / grid.CELL_SIZE;
            Yi = (int) (y - grid.PADDING - adjust) / grid.CELL_SIZE;
            if (currentPlayer == 1) {
                player1.move(Xi, Yi);
                setCurrentPlayer(2);
            } else {
                player2.move(Xi, Yi);
                setCurrentPlayer(1);
            }
        }
    }


    public void translate(int cols, int rows, Picture pic){

    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public Picture[] getBlackPawnPictures() {
        return blackPawnPictures;
    }

    public Picture[] getWhitePawnPictures() {
        return whitePawnPictures;
    }
}

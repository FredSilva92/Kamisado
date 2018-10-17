import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {

    Player player1;
    Player player2;
    Grid grid;
    int currentPlayer = 1;
    Picture[] blackPawnPictures;

    Game() {
        grid = new Grid(8, 8);
        player1 = new Player("José", grid, 1, this);
        player2 = new Player("Alberto", grid, 2, this);
        blackPawnPictures = new Picture[8];
        drawBlackPawns();


    }

    public void start() {


    }


    private void drawBlackPawns() {
        blackPawnPictures[0] = new Picture(grid.PADDING, grid.PADDING, "resources/black_orange.png");
        blackPawnPictures[0].grow(-10, -10);
        blackPawnPictures[0].draw();

        blackPawnPictures[1] = new Picture(grid.PADDING + 90, grid.PADDING, "resources/black_blue.png");
        blackPawnPictures[1].grow(-10, -10);
        blackPawnPictures[1].draw();

        blackPawnPictures[2] = new Picture(grid.PADDING + 90 * 2, grid.PADDING, "resources/black_purple.png");
        blackPawnPictures[2].grow(-10, -10);
        blackPawnPictures[2].draw();

        blackPawnPictures[3] = new Picture(grid.PADDING + 90 * 3, grid.PADDING, "resources/black_pink.png");
        blackPawnPictures[3].grow(-10, -10);
        blackPawnPictures[3].draw();

        blackPawnPictures[4] = new Picture(grid.PADDING + 90 * 4, grid.PADDING, "resources/black_yellow.png");
        blackPawnPictures[4].grow(-10, -10);
        blackPawnPictures[4].draw();

        blackPawnPictures[5] = new Picture(grid.PADDING + 90 * 5, grid.PADDING, "resources/black_red.png");
        blackPawnPictures[5].grow(-10, -10);
        blackPawnPictures[5].draw();

        blackPawnPictures[6] = new Picture(grid.PADDING + 90 * 6, grid.PADDING, "resources/black_green.png");
        blackPawnPictures[6].grow(-10, -10);
        blackPawnPictures[6].draw();

        blackPawnPictures[7] = new Picture(grid.PADDING + 90 * 7, grid.PADDING, "resources/black_brown.png");
        blackPawnPictures[7].grow(-10, -10);
        blackPawnPictures[7].draw();
    }

    public void translate(int cols, int rows, Picture pic){

    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
}

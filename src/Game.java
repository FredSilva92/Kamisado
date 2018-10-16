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
        Picture bOrange = new Picture(grid.PADDING, grid.PADDING, "resources/black_orange.png");
        bOrange.grow(-10, -10);
        bOrange.draw();

        Picture bBlue = new Picture(grid.PADDING + 90, grid.PADDING, "resources/black_blue.png");
        bBlue.grow(-10, -10);
        bBlue.draw();

        Picture bPurple = new Picture(grid.PADDING + 90 * 2, grid.PADDING, "resources/black_purple.png");
        bPurple.grow(-10, -10);
        bPurple.draw();

        Picture bPink = new Picture(grid.PADDING + 90 * 3, grid.PADDING, "resources/black_pink.png");
        bPink.grow(-10, -10);
        bPink.draw();

        Picture bYellow = new Picture(grid.PADDING + 90 * 4, grid.PADDING, "resources/black_yellow.png");
        bYellow.grow(-10, -10);
        bYellow.draw();

        Picture bRed = new Picture(grid.PADDING + 90 * 5, grid.PADDING, "resources/black_red.png");
        bRed.grow(-10, -10);
        bRed.draw();

        Picture bGreen = new Picture(grid.PADDING + 90 * 6, grid.PADDING, "resources/black_green.png");
        bGreen.grow(-10, -10);
        bGreen.draw();

        Picture bBrown = new Picture(grid.PADDING + 90 * 7, grid.PADDING, "resources/black_brown.png");
        bBrown.grow(-10, -10);
        bBrown.draw();
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

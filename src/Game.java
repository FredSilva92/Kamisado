import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {

    private Player player1;
    private Player player2;
    private Grid grid;
    private int currentPlayer = 1;

    private Picture background;
    private Picture start;
    private Picture rules;
    private Picture rulesText = new Picture();
    private Picture dragon = new Picture();

    private Picture[] blackPawnPictures;
    private Picture[] whitePawnPictures;

    Game() {

        grid = new Grid(8, 8);
        menu();

        blackPawnPictures = new Picture[8];
        whitePawnPictures = new Picture[8];

        createPawns();

        player1 = new Player("Jose", grid, 1, this, whitePawnPictures);
        player2 = new Player("Alberto", grid, 2, this, blackPawnPictures);
    }

    public void start() {

        background.delete();
        start.delete();
        rules.delete();

        grid.getRectangle().draw();
        grid.getBoard().draw();

        for (int i = 0; i < blackPawnPictures.length; i++) {
            whitePawnPictures[i].draw();
            blackPawnPictures[i].draw();
        }
    }

    public void menu() {

        rulesText.delete();
        dragon.delete();

        background = new Picture(0, 0, "resources/Kamisado.jpg");
        background.grow(-100, -100);
        background.draw();

        double colStart = (grid.getCols() * grid.CELL_SIZE) * 0.20;
        double rowStart = (grid.getRows() * grid.CELL_SIZE) * 0.75;
        start = new Picture(colStart, rowStart, "resources/Play.png");
        start.draw();

        double colRules = (grid.getCols() * grid.CELL_SIZE) * 0.55;
        double rowRules = (grid.getRows() * grid.CELL_SIZE) * 0.75;
        rules = new Picture(colRules, rowRules, "resources/Rules.png");
        rules.draw();
    }

    public void rulesMenu() {

        background.delete();
        start.delete();
        rules.delete();

        rulesText = new Picture(grid.PADDING, grid.PADDING, "resources/rules_description.png");
        rulesText.grow(-25, -50);
        rulesText.draw();

        dragon = new Picture(grid.PADDING, rulesText.getHeight(), "resources/dragon.jpg");
        dragon.grow(-100, -120);
        dragon.draw();

    }


    private void createPawns() {
        String pathBlack = "resources/black_";
        String pathWhite = "resources/white_";
        String[] paths = {"orange.png", "blue.png", "purple.png", "pink.png", "yellow.png", "red.png", "green.png", "brown.png",};

        for (int i = 0; i < blackPawnPictures.length; i++) {

            blackPawnPictures[i] = new Picture(grid.PADDING + grid.CELL_SIZE * i, grid.PADDING, pathBlack + paths[i]);
            blackPawnPictures[i].grow(-10, -10);

            whitePawnPictures[i] = new Picture(grid.PADDING + grid.CELL_SIZE * i, grid.PADDING + grid.CELL_SIZE * 7, pathWhite + paths[7 - i]);
            whitePawnPictures[i].grow(-10, -10);
        }
    }

    public void p1winner() {

        double colWinner = (grid.getCols() * grid.CELL_SIZE) * 0.25;
        double rowWinner = (grid.getRows() * grid.CELL_SIZE) * 0.25;
        Picture winner = new Picture(colWinner, rowWinner, "resources/p1.png");
        Picture victory = new Picture(colWinner, rowWinner + winner.getHeight(), "resources/Victory.png");
        winner.draw();
        victory.draw();
    }

    public void p2winner() {

        double colWinner = (grid.getCols() * grid.CELL_SIZE) * 0.25;
        double rowWinner = (grid.getRows() * grid.CELL_SIZE) * 0.25;
        Picture winner = new Picture(colWinner, rowWinner, "resources/p2.png");
        Picture victory = new Picture(colWinner, rowWinner + winner.getHeight(), "resources/Victory.png");
        winner.draw();
        victory.draw();
    }


    boolean firstClick = true;
    int Xi;
    int Yi;
    int Xf;
    int Yf;
    int adjust = 24;
    boolean movable;
    boolean firstMoveCheck = false;
    boolean winner;

    public void moveClick(double x, double y) {

        if (winner) {
            return;
        }

        if (!firstMoveCheck) {
            if (firstClick) {
                System.out.println("1");
                Xi = (int) (x - grid.PADDING) / grid.CELL_SIZE;
                Yi = (int) (y - grid.PADDING - adjust) / grid.CELL_SIZE;
                if (Yi == 7) {
                    System.out.println("2");
                    firstClick = false;
                }


            } else {
                System.out.println("3");
                Xf = (int) (x - grid.PADDING) / grid.CELL_SIZE;
                Yf = (int) (y - grid.PADDING - adjust) / grid.CELL_SIZE;


                firstMoveCheck = player1.firstMove(Xi, Yi, Xf, Yf);

                if (firstMoveCheck) {
                    player2.setCurrentPawn(Xf, Yf);
                    //System.out.println(player2.getCurrentPawn().getColor());

                }


                firstClick = true;

                currentPlayer = 2;

            }
        } else {
            System.out.println("4");
            Xf = (int) (x - grid.PADDING) / grid.CELL_SIZE;
            Yf = (int) (y - grid.PADDING - adjust) / grid.CELL_SIZE;
            if (currentPlayer == 1) {
                System.out.println("111");
                if (player1.move(Xf, Yf)) {
                    if (player1.getCurrentPawn().getPosition().getRow() == 0) {
                        System.out.println("P1 wins");
                        winner = true;
                        p1winner();
                        return;
                    }
                    currentPlayer = 2;
                    player2.setCurrentPawn(Xf, Yf);
                    System.out.println("Player2's Turn");
                }
            } else {
                if (player2.move(Xf, Yf)) {
                    if (player2.getCurrentPawn().getPosition().getRow() == (grid.getRows() - 1)) {
                        System.out.println("P2 wins");
                        winner = true;
                        p2winner();
                        return;
                    }
                    System.out.println("222");
                    currentPlayer = 1;
                    player1.setCurrentPawn(Xf, Yf);
                    System.out.println("Player1's Turn");
                }
            }
        }
    }

    public Picture getRules() {
        return rules;
    }

    public Picture getStart() {
        return start;
    }
}

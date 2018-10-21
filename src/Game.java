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
    private Picture winnerImage = new Picture();
    private Picture victoryImage = new Picture();
    private Picture p1DragonWinner = new Picture();
    private Picture p2DragonWinner = new Picture();
    private Picture credits = new Picture();
    private Sound soundIntro = new Sound("resources/intro_music.wav");
    private Sound soundRules = new Sound("resources/rules_music.wav");
    private Sound soundWin = new Sound("resources/winner_music_40sec.wav");
    private Sound soundRight = new Sound("resources/right_move_music_3sec.wav");
    private Sound soundWrong = new Sound("resources/wrong_move.wav");
    private Picture frame = new Picture();

    private Picture[] blackPawnPictures;
    private Picture[] whitePawnPictures;

    public Game() {

        grid = new Grid(8, 8);
        menu();

        blackPawnPictures = new Picture[8];
        whitePawnPictures = new Picture[8];

        createPawnPictures();
    }

    public void start() {

        soundIntro.close();
        background.delete();
        start.delete();
        rules.delete();
        credits.delete();

        grid.getRectangle().draw();
        grid.getBoard().draw();

        createPawnPictures();
        player1 = new Player("Jose", grid, 1, this, whitePawnPictures);
        player2 = new Player("Alberto", grid, 2, this, blackPawnPictures);
        player1.createPawns(whitePawnPictures);
        player2.createPawns(blackPawnPictures);

        for (int i = 0; i < player1.getPawns().length; i++) {
            player1.getPawns()[i].getPosition().setCol(i);
            player1.getPawns()[i].getPosition().setRow(player1.getPawns().length - 1);
            player2.getPawns()[i].getPosition().setCol(i);
            player2.getPawns()[i].getPosition().setRow(0);
        }

        for (int i = 0; i < blackPawnPictures.length; i++) {
            whitePawnPictures[i].draw();
            blackPawnPictures[i].draw();
        }
    }

    public void menu(){

        soundWin.close();
        soundRules.close();
        soundIntro.open();
        rulesText.delete();
        dragon.delete();


        background = new Picture(-20, 0, "resources/Kamisado.jpg");
        background.grow(-50, -100);
        background.draw();

        double colCredits = (grid.getCols() * grid.CELL_SIZE) * 0.20;
        double rowCredits = (grid.getRows() * grid.CELL_SIZE) * 0.05;
        credits = new Picture(colCredits, rowCredits, "resources/authors.png");
        credits.draw();

        double colStart = (grid.getCols() * grid.CELL_SIZE) * 0.17;
        double rowStart = (grid.getRows() * grid.CELL_SIZE) * 0.75;
        start = new Picture(colStart, rowStart, "resources/Play.png");
        start.draw();

        double colRules = (grid.getCols() * grid.CELL_SIZE) * 0.55;
        double rowRules = (grid.getRows() * grid.CELL_SIZE) * 0.75;
        rules = new Picture(colRules, rowRules, "resources/Rules.png");
        rules.draw();
    }

    public void rulesMenu(){

        soundIntro.close();
        soundRules.open();

        background.delete();
        credits.delete();
        start.delete();
        rules.delete();

        rulesText = new Picture(grid.PADDING, grid.PADDING, "resources/rules_description.png");
        rulesText.grow(-25, -50);
        rulesText.draw();

        dragon = new Picture(grid.PADDING, rulesText.getHeight(), "resources/dragon.jpg");
        dragon.grow(-100, -120);
        dragon.draw();

    }


    private void createPawnPictures() {
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

        soundIntro.close();
        soundWin.open();

        double colWinner = (grid.getCols() * grid.CELL_SIZE) * 0.25;
        double rowWinner = (grid.getRows() * grid.CELL_SIZE) * 0.15;
        winnerImage = new Picture(colWinner, rowWinner, "resources/p1.png");
        victoryImage = new Picture(colWinner, rowWinner + winnerImage.getHeight(), "resources/Victory.png");
        p1DragonWinner = new Picture(colWinner * 0.75, rowWinner + winnerImage.getHeight() + victoryImage.getHeight(), "resources/dragon_red_499x250.png");
        winnerImage.draw();
        victoryImage.draw();
        p1DragonWinner.draw();
    }

    public void p2winner() {

        soundIntro.close();
        soundWin.open();

        double colWinner = (grid.getCols() * grid.CELL_SIZE) * 0.25;
        double rowWinner = (grid.getRows() * grid.CELL_SIZE) * 0.15;
        winnerImage = new Picture(colWinner * 1.05, rowWinner, "resources/p2.png");
        victoryImage = new Picture(colWinner, rowWinner + winnerImage.getHeight(), "resources/Victory.png");
        p2DragonWinner = new Picture(colWinner * 0.75, rowWinner + winnerImage.getHeight() + victoryImage.getHeight(), "resources/dragon_black_499x250.png");
        winnerImage.draw();
        victoryImage.draw();
        p2DragonWinner.draw();
    }


    boolean firstClick = true;
    int Xi;
    int Yi;
    int Xf;
    int Yf;
    int adjust = 24;
    boolean firstMoveCheck = false;
    boolean winner;

    public void moveClick(double x, double y) {


        if (!firstMoveCheck) {
            if (firstClick) {
                System.out.println("1");
                Xi = (int) (x - grid.PADDING) / grid.CELL_SIZE;
                Yi = (int) (y - grid.PADDING - adjust) / grid.CELL_SIZE;
                if (Yi == 7) {
                    System.out.println("2");
                    firstClick = false;
                    frame = new Picture(grid.PADDING + Xi * grid.CELL_SIZE + 5, grid.PADDING + Yi * grid.CELL_SIZE + 5, "resources/ball.png");
                    frame.draw();

                }
                else {
                    soundWrong.open();
                }


            } else {
                System.out.println("3");
                Xf = (int) (x - grid.PADDING) / grid.CELL_SIZE;
                Yf = (int) (y - grid.PADDING - adjust) / grid.CELL_SIZE;


                firstMoveCheck = player1.firstMove(Xi, Yi, Xf, Yf);

                if (firstMoveCheck) {
                    System.out.println("Entrou em first move check");
                    player2.setCurrentPawn(Xf, Yf);
                    frame.delete();
                    frame = new Picture(grid.PADDING + player2.getCurrentPawn().getPosition().getCol() * grid.CELL_SIZE + 5, grid.PADDING + player2.getCurrentPawn().getPosition().getRow() * grid.CELL_SIZE + 5, "resources/ball.png");
                    frame.draw();
                    soundRight.open();
                }
                else if(!firstMoveCheck){
                    System.out.println("Entrou em wrong sound");
                    soundWrong.open();
                }

                firstClick = true;
                currentPlayer = 2;
            }
        } else {
            Xf = (int) (x - grid.PADDING) / grid.CELL_SIZE;
            Yf = (int) (y - grid.PADDING - adjust) / grid.CELL_SIZE;

            if (currentPlayer == 1) {
                p1Move();
                return;
            }
            p2Move();
        }
    }


    private void p1Move(){
        System.out.println("111");
        if (player1.move(Xf, Yf)) {
            System.out.println("P1 right move");

            soundRight.open();

            if (player1.getCurrentPawn().getPosition().getRow() == 0) {
                System.out.println("P1 wins");
                winner = true;
                p1winner();
                return;
            }

            currentPlayer = 2;
            player2.setCurrentPawn(Xf, Yf);
            frame.delete();
            frame = new Picture(grid.PADDING + player2.getCurrentPawn().getPosition().getCol() * grid.CELL_SIZE + 5, grid.PADDING + player2.getCurrentPawn().getPosition().getRow() * grid.CELL_SIZE + 5, "resources/ball.png");
            frame.draw();
            System.out.println("Player2's Turn");

            if (player2.testBlock()) {
                currentPlayer = 1;
                int xBlocked = player2.getCurrentPawn().getPosition().getCol();
                int yBlocked = player2.getCurrentPawn().getPosition().getRow();
                player1.setCurrentPawn(xBlocked, yBlocked);
                frame.delete();
                frame = new Picture(grid.PADDING + player1.getCurrentPawn().getPosition().getCol() * grid.CELL_SIZE + 5, grid.PADDING + player1.getCurrentPawn().getPosition().getRow() * grid.CELL_SIZE + 5, "resources/ball.png");
                frame.draw();
                System.out.println("Player1's Turn");
            }


        }
        else if(!player1.move(Xf,Yf)){
            System.out.println("P1 Wrong move");
            soundWrong.open();
        }
    }

    private void p2Move(){
        System.out.println("222");
        if (player2.move(Xf, Yf)) {

            soundRight.open();

            System.out.println("passou");

            if (player2.getCurrentPawn().getPosition().getRow() == (grid.getRows() - 1)) {
                System.out.println("P2 wins");
                winner = true;
                p2winner();
                return;
            }


            currentPlayer = 1;
            player1.setCurrentPawn(Xf, Yf);
            frame.delete();
            frame = new Picture(grid.PADDING + player1.getCurrentPawn().getPosition().getCol() * grid.CELL_SIZE + 5, grid.PADDING + player1.getCurrentPawn().getPosition().getRow() * grid.CELL_SIZE + 5, "resources/ball.png");
            frame.draw();
            System.out.println("Player1's Turn");

            if (player1.testBlock()) {
                currentPlayer = 2;
                int xBlocked = player1.getCurrentPawn().getPosition().getCol();
                int yBlocked = player1.getCurrentPawn().getPosition().getRow();
                player2.setCurrentPawn(xBlocked, yBlocked);
                frame.delete();
                frame = new Picture(grid.PADDING + player2.getCurrentPawn().getPosition().getCol() * grid.CELL_SIZE + 5, grid.PADDING + player2.getCurrentPawn().getPosition().getRow() * grid.CELL_SIZE + 5, "resources/ball.png");
                frame.draw();
                System.out.println("Player2's Turn");
            }


        }
        else if(!player2.move(Xf,Yf)){
            System.out.println("P2 wrong move");
            soundWrong.open();
        }
    }





    public void resetMenu(){

        grid.getRectangle().delete();
        grid.getBoard().delete();
        winnerImage.delete();
        victoryImage.delete();
        p1DragonWinner.delete();
        p2DragonWinner.delete();

        for (int i = 0; i < blackPawnPictures.length; i++) {
            player1.getPawns()[i].getPicture().delete();
            player2.getPawns()[i].getPicture().delete();
        }

        clearGrid();
        menu();

        firstMoveCheck = false;
        winner = false;

        return;
    }

    private void clearGrid() {
        for (int i = 0; i < grid.getRows(); i++) {
            for (int j = 0; j < grid.getCols(); j++) {
                grid.getSquares()[i][j].setOccupied(false);
            }
        }
    }

    public Picture getRules() {
        return rules;
    }

    public Picture getStart() {
        return start;
    }

    public boolean isWinner() {
        return winner;
    }
}

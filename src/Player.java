import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.concurrent.TimeUnit;

public class Player {

    private String name;
    private Pawn[] pawns;
    private int playerNumber;
    private Grid grid;
    private boolean[][] possibleSquares;
    private Game game;
    private Pawn currentPawn;

    public Player(String name, Grid grid, int playerNumber, Game game, Picture[] pawnPictures){
        this.playerNumber = playerNumber;
        this.grid = grid;
        this.name = name;
        pawns = new Pawn[8];
        createPawns(pawnPictures);
        possibleSquares = new boolean[grid.getCols()][grid.getRows()];
        this.game = game;
    }

    public boolean firstMove(int col1, int row1, int col2, int row2){

        pawnPossibleSquares(pawns[col1]);

        if(playerNumber == 1) {
            if (row2 > 0 && possibleSquares[col2][row2]) {
                pawns[col1].getPosition().setCol(col2);
                pawns[col1].getPosition().setRow(row2);
                pawns[col1].getPicture().translate((col2 - col1) * 90, (row2 - row1) * 90);
                grid.getSquares()[col2][row2].setOccupied(true);
                grid.getSquares()[col1][row1].setOccupied(false);

                return true;
            }
        }
        return false;


    }

    public boolean move(int col2, int row2){

        pawnPossibleSquares(currentPawn);
        int col1 = currentPawn.getPosition().getCol();
        int row1 = currentPawn.getPosition().getRow();


        if(playerNumber == 1){

            if(possibleSquares[col2][row2]){
            if(col1 == col2) {
                for (int i = 0; i < row1 - row2; i++) {
                    if (grid.getSquares()[col1][row1 - i - 1].isOccupied()) {
                        return false;
                    }
                }
            }
            if(col1 < col2) {
                for (int i = 0; i < row1 - row2; i++) {
                    if (grid.getSquares()[col1 + i + 1][row1 - i - 1].isOccupied()) {
                        return false;
                    }
                }
            }
            if(col1 > col2) {
                for (int i = 0; i < row1 - row2; i++) {
                    if (grid.getSquares()[col1 - i - 1][row1 - i - 1].isOccupied()) {
                        return false;
                    }
                }
            }
            currentPawn.getPosition().setCol(col2);
            currentPawn.getPosition().setRow(row2);
            currentPawn.getPicture().translate( (col2 - col1) * 90, (row2 - row1) * 90);
            grid.getSquares()[col2][row2].setOccupied(true);
            grid.getSquares()[col1][row1].setOccupied(false);

            return true;
        }
        return false;

        }else{


            if(possibleSquares[col2][row2]){
            if(col1 == col2) {
                for (int i = 0; i < row2 - row1; i++) {
                    if (grid.getSquares()[col1][row1 + i + 1].isOccupied()) {
                        return false;
                    }
                }
            }
            if(col1 < col2) {
                for (int i = 0; i < row2 - row1; i++) {
                    if (grid.getSquares()[col1 + i + 1][row1 + i + 1].isOccupied()) {
                        return false;
                    }
                }
            }
            if(col1 > col2) {
                for (int i = 0; i < row2 - row1; i++) {
                    if (grid.getSquares()[col1 - i - 1][row1 + i + 1].isOccupied()) {
                        return false;
                    }
                }
            }
            currentPawn.getPosition().setCol(col2);
            currentPawn.getPosition().setRow(row2);
            currentPawn.getPicture().translate( (col2 - col1) * 90, (row2 - row1) * 90);
            grid.getSquares()[col2][row2].setOccupied(true);
            grid.getSquares()[col1][row1].setOccupied(false);

            return true;
        }
        return false;

        }
    }



    private void createPawns(Picture[] pawnPictures){
        for(int i = 0; i < Color.values().length; i++){
            int col = i;
            int row;
            if(playerNumber == 2){
                row = 0;
                pawns[i] = new Pawn(Color.values()[i], col, row, pawnPictures[i]);
            }else{
                row = grid.getRows() - 1;
                pawns[i] = new Pawn(Color.values()[Color.values().length - 1 - i], col, row, pawnPictures[i]);
            }

        }
    }

    public void pawnPossibleSquares(Pawn pawn){
        int jAbs;
        boolean iTest;
        boolean jTest;

        int pRow = pawn.getPosition().getRow();
        int pCol = pawn.getPosition().getCol();

        for(int i = 0; i < grid.getRows(); i++){
            //System.out.println(" ");
            for(int j = 0; j < grid.getCols(); j++){
                jAbs = Math.abs(j - pCol);
                if(playerNumber == 1) {
                    iTest = i < pRow;
                }else{
                    iTest = i > pRow;
                }
                jTest = (j == pCol || jAbs == Math.abs(i - pRow));
                if(iTest && jTest && !grid.getSquares()[j][i].isOccupied()){
                    possibleSquares[j][i] = true;
                    //System.out.println(possibleSquares[j][i]);
                    continue;
                }
                possibleSquares[j][i] = false;
                //System.out.println(possibleSquares[j][i]);

            }
        }

    }


        public void setCurrentPawn(int x, int y){

        Color color = grid.getSquares()[x][y].getColor();

        for(int i = 0; i<pawns.length; i++){
            if(pawns[i].getColor()==color){
                currentPawn = pawns[i];
                pawns[i].getPosition().getCol();
                pawns[i].getPosition().getRow();
            }
        }

    }

    public Pawn getCurrentPawn() {
        return currentPawn;
    }

}

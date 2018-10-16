public class Player {

    private String name;
    private Pawn[] pawns;
    private int playerNumber;
    private Grid grid;

    public Player(String name, Grid grid, int playerNumber){
        this.playerNumber = playerNumber;
        this.grid = grid;
        this.name = name;
        pawns = new Pawn[8];
        createPawns();
    }

    public boolean firstMove(int col1, int row1, int col2, int row2){



        return true;

    }

    public void move(int col, int row){
        if(playerNumber == 1){

        }else{

        }
    }

    private void createPawns(){
        for(int i = 0; i < Color.values().length; i++){
            int col = i;
            int row;
            if(playerNumber == 1){
                row = 0;
                pawns[i] = new Pawn(Color.values()[i], col, row);
            }else{
                row = grid.getRows() - 1;
                pawns[i] = new Pawn(Color.values()[Color.values().length - 1 - i], col, row);
            }

        }
    }

    public boolean[][] pawnPossibleSquares(boolean[][] tempPossibleSquares, Pawn pawn){
        int jAbs;
        boolean iTest;
        boolean jTest;

        int pRow = pawn.getPosition().getRow();
        int pCol = pawn.getPosition().getCol();

        for(int i = 0; i < grid.getRows(); i++){
            for(int j = 0; j < grid.getCols(); j++){
                jAbs = Math.abs(j - pCol);
                iTest = i > pRow;
                jTest = (j == pCol || jAbs == i - pRow);
                if(iTest && jTest && !grid.getSquares()[j][i].isOccupied()){
                    tempPossibleSquares[j][i] = true;
                }
            }
        }
        return tempPossibleSquares;
    }

}

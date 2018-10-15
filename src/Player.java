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

    public void move(int squaresMoved, int dir){
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

}

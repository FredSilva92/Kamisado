public class Pawn {

    private Color color;
    private Position position;

    public Pawn(Color color, int col, int row){
        this.color = color;
        position = new Position(col, row);
    }
}

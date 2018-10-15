public class Square {

    private Color color;
    private boolean occupied;

    public Square(Color color){
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }
}

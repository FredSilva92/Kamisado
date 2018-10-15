import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Grid {

    private int cols;
    private int rows;
    Square[][] squares;

    public final int PADDING = 10;
    public final int CELL_SIZE = 40;

    private Rectangle grid;

    public Grid(int cols, int rows){
        this.cols = cols;
        this.rows = rows;
        squares = new Square[cols][rows];
        squares = createSquares(squares);
        showSquares();

        grid = new Rectangle(PADDING, PADDING, cols * CELL_SIZE, rows * CELL_SIZE);

        grid.draw();
    }

    public int getRows() {
        return rows;
    }


    private Square[][] createSquares(Square[][] tempSquares){
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(j == i){
                    tempSquares[j][i] = new Square(Color.values()[0]);
                    continue;
                }
                if(j == (1 + 3 * i) % 8){
                    tempSquares[j][i] = new Square(Color.values()[1]);
                    continue;
                }
                if(j == (2 + 5 * i) % 8){
                    tempSquares[j][i] = new Square(Color.values()[2]);
                    continue;
                }
                if(j == (3 + 7 * i) % 8){
                    tempSquares[j][i] = new Square(Color.values()[3]);
                    continue;
                }
                if(j == (4 + 1 * i) % 8){
                    tempSquares[j][i] = new Square(Color.values()[4]);
                    continue;
                }
                if(j == (5 + 3 * i) % 8){
                    tempSquares[j][i] = new Square(Color.values()[5]);
                    continue;
                }
                if(j == (6 + 5 * i) % 8){
                    tempSquares[j][i] = new Square(Color.values()[6]);
                    continue;
                }
                if(j == (7 + 7 * i) % 8){
                    tempSquares[j][i] = new Square(Color.values()[7]);
                    continue;
                }
            }
        }
        return tempSquares;
    }

    private void showSquares(){
        for(int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.println(squares[j][i].getColor());
            }
            System.out.println("\n");
        }
    }
}

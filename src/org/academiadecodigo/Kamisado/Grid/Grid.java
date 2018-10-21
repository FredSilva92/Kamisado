package org.academiadecodigo.Kamisado.Grid;

import org.academiadecodigo.Kamisado.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Grid {

    private int cols;
    private int rows;
    private Square[][] squares;

    public final int PADDING = 10;
    public final int CELL_SIZE = 90;

    private Rectangle rectangle;
    private Picture board;

    public Grid(int cols, int rows){
        this.cols = cols;
        this.rows = rows;
        squares = new Square[cols][rows];
        squares = createSquares(squares);
        showSquares();

        rectangle = new Rectangle(PADDING, PADDING, cols * CELL_SIZE, rows * CELL_SIZE);
        board = new Picture(PADDING, PADDING, "resources/cut_board_814x816.png");
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public Square[][] getSquares() {
        return squares;
    }

    public Picture getBoard() {
        return board;
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

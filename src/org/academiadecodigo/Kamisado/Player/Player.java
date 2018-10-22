package org.academiadecodigo.Kamisado.Player;

import org.academiadecodigo.Kamisado.Color;
import org.academiadecodigo.Kamisado.Game.Game;
import org.academiadecodigo.Kamisado.Grid.Grid;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player {

    private Pawn[] pawns;
    private int playerNumber;
    private Grid grid;
    private boolean[][] possibleSquares;
    private Game game;
    private Pawn currentPawn;

    public Player(Grid grid, int playerNumber, Game game, Picture[] pawnPictures) {
        this.playerNumber = playerNumber;
        this.grid = grid;
        pawns = new Pawn[8];
        createPawns(pawnPictures);
        possibleSquares = new boolean[grid.getCols()][grid.getRows()];
        this.game = game;
    }

    public boolean firstMove(int col1, int row1, int col2, int row2) {

        pawnPossibleSquares(pawns[col1]);

        if (playerNumber == 1) {
            if (row2 > 0 && possibleSquares[col2][row2]) {
                pawns[col1].getPosition().setCol(col2);
                pawns[col1].getPosition().setRow(row2);
                grid.getSquares()[col2][row2].setOccupied(true);
                grid.getSquares()[col1][row1].setOccupied(false);
                pawns[col1].getPicture().translate((col2 - col1) * 90, (row2 - row1) * 90);
                return true;
            }
        }
        return false;
    }

    public boolean move(int col2, int row2) {

        pawnPossibleSquares(currentPawn);
        int col1 = currentPawn.getPosition().getCol();
        int row1 = currentPawn.getPosition().getRow();


        if (playerNumber == 1) {
            return p1Move(col1, row1, col2, row2);
        } else {
            return p2move(col1, row1, col2, row2);
        }
    }

    public boolean p1Move(int col1, int row1, int col2, int row2) {

        if (possibleSquares[col2][row2]) {

            if (col1 == col2) {
                for (int i = 0; i < row1 - row2; i++) {
                    if (grid.getSquares()[col1][row1 - i - 1].isOccupied()) {
                        return false;
                    }
                }
            }
            if (col1 < col2) {
                for (int i = 0; i < row1 - row2; i++) {
                    if (grid.getSquares()[col1 + i + 1][row1 - i - 1].isOccupied()) {
                        return false;
                    }
                }
            }
            if (col1 > col2) {
                for (int i = 0; i < row1 - row2; i++) {
                    if (grid.getSquares()[col1 - i - 1][row1 - i - 1].isOccupied()) {
                        return false;
                    }
                }
            }
            currentPawn.getPosition().setCol(col2);
            currentPawn.getPosition().setRow(row2);
            currentPawn.getPicture().translate((col2 - col1) * 90, (row2 - row1) * 90);
            grid.getSquares()[col2][row2].setOccupied(true);
            grid.getSquares()[col1][row1].setOccupied(false);

            return true;
        }
        return false;
    }

    public boolean p2move(int col1, int row1, int col2, int row2) {

        if (possibleSquares[col2][row2]) {

            if (col1 == col2) {
                for (int i = 0; i < row2 - row1; i++) {
                    if (grid.getSquares()[col1][row1 + i + 1].isOccupied()) {
                        return false;
                    }
                }
            }
            if (col1 < col2) {
                for (int i = 0; i < row2 - row1; i++) {
                    if (grid.getSquares()[col1 + i + 1][row1 + i + 1].isOccupied()) {
                        return false;
                    }
                }
            }
            if (col1 > col2) {
                for (int i = 0; i < row2 - row1; i++) {
                    if (grid.getSquares()[col1 - i - 1][row1 + i + 1].isOccupied()) {
                        return false;
                    }
                }
            }
            currentPawn.getPosition().setCol(col2);
            currentPawn.getPosition().setRow(row2);
            currentPawn.getPicture().translate((col2 - col1) * 90, (row2 - row1) * 90);
            grid.getSquares()[col2][row2].setOccupied(true);
            grid.getSquares()[col1][row1].setOccupied(false);

            return true;
        }
        return false;
    }


    public void createPawns(Picture[] pawnPictures) {
        for (int i = 0; i < Color.values().length; i++) {
            int col = i;
            int row;
            if (playerNumber == 2) {
                row = 0;
                pawns[i] = new Pawn(Color.values()[i], col, row, pawnPictures[i]);
                grid.getSquares()[col][row].setOccupied(true);
            } else {
                row = grid.getRows() - 1;
                pawns[i] = new Pawn(Color.values()[Color.values().length - 1 - i], col, row, pawnPictures[i]);
                grid.getSquares()[col][row].setOccupied(true);
            }

        }
    }

    public void pawnPossibleSquares(Pawn pawn) {
        int jAbs;
        boolean iTest;
        boolean jTest;

        int pRow = pawn.getPosition().getRow();
        int pCol = pawn.getPosition().getCol();

        for (int i = 0; i < grid.getRows(); i++) {
            for (int j = 0; j < grid.getCols(); j++) {
                jAbs = Math.abs(j - pCol);
                if (playerNumber == 1) {
                    iTest = i < pRow;
                } else {
                    iTest = i > pRow;
                }
                jTest = (j == pCol || jAbs == Math.abs(i - pRow));
                if (iTest && jTest && !grid.getSquares()[j][i].isOccupied()) {
                    possibleSquares[j][i] = true;
                    continue;
                }
                possibleSquares[j][i] = false;
            }
        }
    }

    public boolean testBlock() {

        int x = currentPawn.getPosition().getCol();
        int y = currentPawn.getPosition().getRow();

        boolean upLeft;
        boolean upCenter;
        boolean upRight;
        int inv = 1;

        if (playerNumber == 2) {
            inv = -1;
        }
        if (x == 0) {
            upLeft = true;
        } else {
            upLeft = grid.getSquares()[x - 1][y - inv].isOccupied();
        }
        if (x == 7) {
            upRight = true;
        } else {
            upRight = grid.getSquares()[x + 1][y - inv].isOccupied();
        }
        upCenter = grid.getSquares()[x][y - inv].isOccupied();
        if (upRight && upCenter && upLeft) {
            return true;
        }
        return false;
    }


    public void setCurrentPawn(int x, int y) {

        Color color = grid.getSquares()[x][y].getColor();

        for (int i = 0; i < pawns.length; i++) {
            if (pawns[i].getColor() == color) {
                currentPawn = pawns[i];
                pawns[i].getPosition().getCol();
                pawns[i].getPosition().getRow();
            }
        }

    }

    public Pawn getCurrentPawn() {
        return currentPawn;
    }

    public Pawn[] getPawns() {
        return pawns;
    }
}

package org.academiadecodigo.Kamisado.Player;

import org.academiadecodigo.Kamisado.Color;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Pawn {

    private Color color;
    private Position position;
    private Picture picture;

    public Pawn(Color color, int col, int row, Picture picture){
        this.color = color;
        this.picture = picture;
        position = new Position(col, row);
    }

    public Position getPosition() {
        return position;
    }

    public Color getColor() {
        return color;
    }

    public Picture getPicture() {
        return picture;
    }
}

package org.academiadecodigo.Kamisado;

import org.academiadecodigo.Kamisado.Game.Game;
import org.academiadecodigo.Kamisado.Game.MoveEvents;

public class Main {

    public static void main(String[] args) {

        Game g = new Game();

        MoveEvents moveEvents = new MoveEvents(g);
        moveEvents.test();

    }

}

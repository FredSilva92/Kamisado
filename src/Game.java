public class Game {

    Player player1;
    Player player2;
    Grid grid;

    Game(){
        grid = new Grid(8, 8);
        player1 = new Player("José", grid, 1);
        player2 = new Player("Alberto", grid, 2);

    }

    public void start(){



    }

}

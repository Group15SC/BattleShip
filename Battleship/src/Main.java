

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        Display display = new Display();
        game.getGrids();
        display.printComputergrid(game.getGrids().get(1));
        display.printPlayergrid(game.getGrids().get(0));

    }




}
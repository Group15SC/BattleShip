import java.util.ArrayList;
import java.util.List;

public class Game {

    public Game(){
        AddShipsToGrid(Player1);
        AddShipsToGrid(Player2);
        display.printPlayergrid(GridsOfPlayers.get(1));
        System.out.println("-------------------");
        display.printPlayergrid(GridsOfPlayers.get(0));
    }

    private List<Grid> GridsOfPlayers = new ArrayList<>();  /*generate two grids*/

    public List<Grid> getGrids() {
        GenerateGrids();
        return GridsOfPlayers;
    }
    public void GenerateGrids() {
        Grid grid1 = new Grid();
        Grid grid2 = new Grid();

        GridsOfPlayers.add(grid1);
        GridsOfPlayers.add(grid2);
    }

    public void AddShipsToGrid(List<Ship> Ships) {
        Grid m = new Grid();
//        Point [][]m = G.matrix;
        for (int i = 0; i < Ships.size(); i++) {
            for(int j = 0; j < Ships.get(i).getFields().size(); j++) {
                int x = Ships.get(i).getFields().get(j).getX();
                int y = Ships.get(i).getFields().get(j).getY();
                PointStatus Status = Ships.get(i).getFields().get(j).getPointStatus();
                m.getPoint(x,y).setPoint(x, y, Status);
            }
        }
        GridsOfPlayers.add(m);
    }

    Input input = new Input();

    List<Ship> Player1 = input.GetPlayer1();
    List<Ship> Player2 = input.GetPlayer2();

    Display display = new Display();

}
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    Input input = new Input();

    List<Ship> Player1 = input.GetPlayer1();
    List<Ship> Player2 = input.GetPlayer2();

    Display display = new Display();

    public Game(){
        AddShipsToGrid(Player1);
        AddShipsToGrid(Player2);
        GenerateGrids();
        display.printComputergrid(GridsOfPlayers.get(1));
        System.out.println("-------------------");
        display.printPlayergrid(GridsOfPlayers.get(0));
    }

    public void GameBegin() {
        Boolean GameOn = true;

        while(GameOn) {

            Random r = new Random();
            int turn = r.nextInt(1);
            if(turn == 0) {
                int[] ShootCoordinatesPlayer1 = input.InputShoot(0);
                if(HandleShot(Player2, ShootCoordinatesPlayer1)) {
                    GameOn = false;
                };
                display.printComputergrid(GridsOfPlayers.get(1));
                System.out.println("-------------------");
                display.printPlayergrid(GridsOfPlayers.get(0));
                int[] ShootCoordinatesPlayer2 = input.GenerateShootForComputer();
                if(HandleShot(Player1, ShootCoordinatesPlayer2)) {
                    GameOn = false;
                };
                display.printComputergrid(GridsOfPlayers.get(1));
                System.out.println("-------------------");
                display.printPlayergrid(GridsOfPlayers.get(0));


            } else {
                int[] ShootCoordinatesPlayer2 = input.GenerateShootForComputer();
                if(HandleShot(Player1, ShootCoordinatesPlayer2)) {
                    GameOn = false;
                };
                display.printComputergrid(GridsOfPlayers.get(1));
                System.out.println("-------------------");
                display.printPlayergrid(GridsOfPlayers.get(0));
                int[] ShootCoordinatesPlayer1 = input.InputShoot(0);
                if(HandleShot(Player2, ShootCoordinatesPlayer1)) {
                    GameOn = false;
                };
                display.printComputergrid(GridsOfPlayers.get(1));
                System.out.println("-------------------");
                display.printPlayergrid(GridsOfPlayers.get(0));
            }

        }
        System.out.println("Game is over");


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

    public boolean HandleShot(List<Ship> Ships, int [] ShootCoordinator) {
        int NumOfShips = 10;
        boolean GameOver = false;
        for(int i = 0; i < Ships.size(); i ++) {
            int HitCount = 0;
            for(int j = 0; j < Ships.get(i).getFields().size(); j++) {
                if(ShootCoordinator[0] == Ships.get(i).getFields().get(j).getX() && ShootCoordinator[1] == Ships.get(i).getFields().get(j).getY()) {
                    System.out.println("Hit!");
                    Ships.get(i).getFields().get(j).setPointStatus(PointStatus.HIT);
                    for(int k = 0; k < Ships.get(i).getFields().size(); k++) {
                        HitCount ++;
                    }
                    if(HitCount == Ships.get(i).getFields().size()) {
                        NumOfShips --;
                        for(int m = 0; m < Ships.get(i).getFields().size(); m++) {
                            Ships.get(i).getFields().get(m).setPointStatus(PointStatus.SUNK);
                        }
                    }
                }
            }
        }
        if(NumOfShips == 0) {
            GameOver = true;
        }
        return GameOver;
    }

}
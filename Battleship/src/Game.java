import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    Input input = new Input();

    List<Ship> Player1 = input.GetPlayer1();
    List<Ship> Player2 = input.GetPlayer2();

    public List<Ship> UpdatePlayer1() {
        return Player1;
    }

    public List<Ship> UpdatePlayer2() {
        return Player2;
    }

    Display display = new Display();

    //int NumOfShips = 10;
    int NumOfShipsPlayer1 = 1;
    int NumOfShipsPlayer2 = 1;

    public Game(){
//        AddShipsToGrid(Player1);
//        AddShipsToGrid(Player2);
//        GenerateGrids();
        display.printComputergrid(AddShipsToGrid(Player2));
        System.out.println("-------------------");
        display.printPlayergrid(AddShipsToGrid(Player1));
    }

    public void GameBegin() {
        Boolean GameOn = true;
        while(GameOn) {
            Random r = new Random();
            int turn = r.nextInt(2);
            if(turn == 0) {
                int[] ShootCoordinatesPlayer1 = input.InputShoot(0);
                if(HandleShot(Player2, ShootCoordinatesPlayer1, NumOfShipsPlayer2) == 1) {
                    GameOn = false;
                } else if (HandleShot(Player2, ShootCoordinatesPlayer1, NumOfShipsPlayer2) == 2) {
                    ShootCoordinatesPlayer1 = input.InputShoot(0);
                } else {
                    continue;
                }
                display.printComputergrid(AddShipsToGrid(Player2));
                System.out.println("-------------------");
                display.printPlayergrid(AddShipsToGrid(Player1));
                int[] ShootCoordinatesPlayer2 = input.GenerateShootForComputer();
                if(HandleShot(Player1, ShootCoordinatesPlayer2, NumOfShipsPlayer1) == 1) {
                    GameOn = false;
                } else if (HandleShot(Player1, ShootCoordinatesPlayer2, NumOfShipsPlayer1) == 2) {
                    ShootCoordinatesPlayer2 = input.InputShoot(0);
                } else {
                    continue;
                }
                display.printComputergrid(AddShipsToGrid(Player2));
                System.out.println("-------------------");
                display.printPlayergrid(AddShipsToGrid(Player1));


            } else {
                int[] ShootCoordinatesPlayer2 = input.GenerateShootForComputer();
                if(HandleShot(Player1, ShootCoordinatesPlayer2, NumOfShipsPlayer1) == 1) {
                    GameOn = false;
                } else if (HandleShot(Player1, ShootCoordinatesPlayer2, NumOfShipsPlayer1) == 2) {
                    ShootCoordinatesPlayer2 = input.InputShoot(0);
                } else {
                    continue;
                }
                display.printComputergrid(AddShipsToGrid(Player2));
                System.out.println("-------------------");
                display.printPlayergrid(AddShipsToGrid(Player1));
                int[] ShootCoordinatesPlayer1 = input.InputShoot(0);
                if(HandleShot(Player2, ShootCoordinatesPlayer1, NumOfShipsPlayer2) == 1) {
                    GameOn = false;
                } else if (HandleShot(Player2, ShootCoordinatesPlayer1, NumOfShipsPlayer2) == 2) {
                ShootCoordinatesPlayer1 = input.InputShoot(0);
                } else {
                continue;
                }
                display.printComputergrid(AddShipsToGrid(Player2));
                System.out.println("-------------------");
                display.printPlayergrid(AddShipsToGrid(Player1));
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

    public Grid AddShipsToGrid(List<Ship> Ships) {
        Grid m = new Grid();
        //List<Grid> gridsofplayers = new ArrayList<>(2);
        for (int i = 0; i < Ships.size(); i++) {
            for (int j = 0; j < Ships.get(i).getFields().size(); j++) {
                int x = Ships.get(i).getFields().get(j).getX();
                int y = Ships.get(i).getFields().get(j).getY();
                PointStatus Status = Ships.get(i).getFields().get(j).getPointStatus();
                m.getPoint(x, y).setPoint(x, y, Status);
            }
        }
        return m;
//        if (side == "human") {
//            gridsofplayers.set(0,m);
//        } else {
//            gridsofplayers.set(1,m);
//        }
    }

    public int HandleShot(List<Ship> Ships, int [] ShootCoordinator, int NumOfShips) {
        int GameOver = 0;
        //int HitCount = 0;
        int flag = 0;
        for(int i = 0; i < Ships.size(); i ++) {
            for (int j = 0; j < Ships.get(i).getFields().size(); j++) {
                if(ShootCoordinator[0] == Ships.get(i).getFields().get(j).getX() && ShootCoordinator[1] == Ships.get(i).getFields().get(j).getY()) {
                    flag = 1;
                } else {
                    continue;
                }
            }
        }

        if(flag == 0) {

        }

        for(int i = 0; i < Ships.size(); i ++) {
            for(int j = 0; j < Ships.get(i).getFields().size(); j++) {
                if(ShootCoordinator[0] == Ships.get(i).getFields().get(j).getX() && ShootCoordinator[1] == Ships.get(i).getFields().get(j).getY()) {
                    System.out.println("Hit!");
                    Ships.get(i).getFields().get(j).setPointStatus(PointStatus.HIT);
                    Ships.get(i).setHitcount(Ships.get(i).getHitcount()+1);
                    System.out.println(Ships.get(i).getHitcount());
                    if(Ships.get(i).getHitcount() == Ships.get(i).getFields().size()) {
                        System.out.println("You sunk a ship!");
                        NumOfShips --;
                        for(int m = 0; m < Ships.get(i).getFields().size(); m++) {
                            Ships.get(i).getFields().get(m).setPointStatus(PointStatus.SUNK);
                        } System.out.println(Ships.get(i).getFields().get(0).getPointStatus());
                    }
                } else if (Ships.get(i).getFields().get(j).getPointStatus()==PointStatus.EMPTY){
                    System.out.println("Missed!");
                    Ships.get(i).getFields().get(j).setPointStatus(PointStatus.MISSED);
                } else {
                    GameOver = 2; // invalid shot
                }
            }
        }
        if(NumOfShips == 0) {
            GameOver = 1;
        }
        return GameOver;
    }

    public Ship getShip(Point point, String side){
        Ship target = null;
        if(side == "human") {
            List<Ship> player = Player1;
            for (int i = 0; i < player.size(); i++) {
                Ship ship = player.get(i);
                List<Point> field = ship.getFields();
                if (field.contains(point)) {
                    target = ship;
                }
            }
        } else if (side == "computer") {
            List<Ship> player = Player2;
            for (int i = 0; i < player.size(); i++) {
                Ship ship = player.get(i);
                List<Point> field = ship.getFields();
                if ( field.contains(point)) {
                    target = ship;
                }
            }
        }
        return target;
    }

}
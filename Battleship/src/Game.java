import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    Input input = new Input();
    Display display = new Display();

    List<Ship> Fleet1 = input.GetFleet1();
    List<Ship> Fleet2 = input.GetFleet2();

//    public List<Ship> UpdatePlayer1() {
//        return Player1;
//    }
//
//    public List<Ship> UpdatePlayer2() {
//        return Player2;
//    }



    //int NumOfShips = 10;
//    int NumOfShipsPlayer1 = 10;
//    int NumOfShipsPlayer2 = 10;

//    Player player1 = new Player(Fleet1);
//    Player player2 = new Player(Fleet2); //computer


    public Game(){
//        AddShipsToGrid(Player1);
//        AddShipsToGrid(Player2);
//        GenerateGrids();
        display.printComputergrid(AddShipsToGrid(Fleet2));
        System.out.println("-------------------");
        display.printPlayergrid(AddShipsToGrid(Fleet1));
    }


    private void Humanturn() {
        int[] Humanshot = input.InputShoot(0);
        System.out.println("========================");
        System.out.println("You choose to shoot: ("+(char)(Humanshot[0]+'A')+Humanshot[1]+")");
        int shotresult = input.Handleshot(Fleet2, Humanshot);
        while (shotresult==2) { //if the input is invalid
            System.out.println("Already hit! Give another shot!");
            Humanshot = input.InputShoot(0); //input again
            System.out.println("You shoot: ("+(char)(Humanshot[0]+'A')+Humanshot[1]+")");
        }
        if (shotresult == 0) {
            System.out.println("Missed!");
            input.player2.getGrid().getPoint(Humanshot[0], Humanshot[1]).setPointStatus(PointStatus.MISSED);
        }
    }


//        if(input.Handleshot(Fleet2, Humanshot)==2) { //invalid input case, ask for another shoot
//            Humanshot = input.InputShoot(0);
////                    Humanshot[0] = input.InputShoot(0)[0];
////                    Humanshot[1] = input.InputShoot(0)[1];
//        } else if (input.Handleshot(Fleet2, Humanshot)==0) { //the coordinate is not within the fleet, hit empty point
//            System.out.println("Missed!");
//            input.player2.getGrid().getPoint(Humanshot[0], Humanshot[1]).setPointStatus(PointStatus.MISSED);
//        }
//        //update grid and print out
//        input.player1.updategrid(Fleet1);
//        input.player2.updategrid(Fleet2);
//        display.printComputergrid(input.player2.getGrid());
//        System.out.println("-------------------");
//        display.printPlayergrid(input.player1.getGrid());
//    }

    private void Computerturn() {
        int[] Computershot = input.GenerateShootForComputer();
        System.out.println("========================");
        System.out.println("Player2 chooses to shoot: ("+(char)(Computershot[0]+'A')+Computershot[1]+")");
        int shotresult = input.Handleshot(Fleet1, Computershot);
        while (shotresult == 2) { //if the input is invalid
            System.out.println("Already hit! Give another shot!");
            Computershot = input.GenerateShootForComputer(); //input again
            System.out.println("New choice: ("+(char)(Computershot[0]+'A')+Computershot[1]+")");
        }
        if (shotresult==0) {
            System.out.println("Missed!");
            input.player1.getGrid().getPoint(Computershot[0], Computershot[1]).setPointStatus(PointStatus.MISSED);
        }
    }


    public void GameOn() {
        Boolean GameOn = true;
        Random r = new Random();
        int turn = r.nextInt(2);
        while(GameOn) {
            if(turn == 0) { //human shoot first
                Humanturn();
                Computerturn();
                //update grid and print out
                input.player1.updategrid(Fleet1);
                input.player2.updategrid(Fleet2);
                display.printComputergrid(input.player2.getGrid());
                System.out.println("-------------------");
                display.printPlayergrid(input.player1.getGrid());
                int Hitpoints1 = 0;
                for(Ship ship: Fleet1) {
                    Hitpoints1 += ship.getHitcount();
                }
                if(Hitpoints1 == 31) {
                    System.out.println("Player 2 wins!");
                    System.out.println("Player 2's Ocean Grid:");
                    display.printPlayergrid(input.player2.getGrid());
                    GameOn = false;
                }
                int Hitpoints2 = 0;
                for(Ship ship: Fleet2) {
                    Hitpoints2 += ship.getHitcount();
                }
                if(Hitpoints2 == 31) {
                    System.out.println("Congrats! You win!");
                    GameOn = false;
                }
//                int[] Humanshot = input.InputShoot(0);
//                if(input.Handleshot(Fleet2, Humanshot)==2) { //invalid input case, ask for another shoot
//                    Humanshot = input.InputShoot(0);
////                    Humanshot[0] = input.InputShoot(0)[0];
////                    Humanshot[1] = input.InputShoot(0)[1];
//                } else if (input.Handleshot(Fleet2, Humanshot)==0) { //the coordinate is not within the fleet, hit empty point
//                    System.out.println("Missed!");
//                    input.player2.getGrid().getPoint(Humanshot[0], Humanshot[1]).setPointStatus(PointStatus.MISSED);
//                } else {
//                    continue;
//                }
//                input.player1.updategrid(Fleet1);
//                input.player2.updategrid(Fleet2);
//                display.printComputergrid(input.player2.getGrid());
//                System.out.println("-------------------");
//                display.printPlayergrid(input.player1.getGrid());

//                int[] Computershot = input.GenerateShootForComputer();
//                if(input.Handleshot(Fleet1, Computershot)==2) {
//                    Computershot[0] = input.GenerateShootForComputer()[0];
//                    Computershot[1] = input.GenerateShootForComputer()[1];
//                } else if (input.Handleshot(Fleet1, Computershot)==0) {
//                    System.out.println("Missed!");
//                    input.player1.getGrid().getPoint(Computershot[0], Computershot[1]).setPointStatus(PointStatus.MISSED);
//                } else {
//                    continue;
//                }
//                input.player1.updategrid(Fleet1);
//                input.player2.updategrid(Fleet2);
//                display.printComputergrid(input.player2.getGrid());
//                System.out.println("-------------------");
//                display.printPlayergrid(input.player1.getGrid());

            } else { //computer shoot first
                Computerturn();
                Humanturn();
                input.player1.updategrid(Fleet1);
                input.player2.updategrid(Fleet2);
                display.printComputergrid(input.player2.getGrid());
                System.out.println("-------------------");
                display.printPlayergrid(input.player1.getGrid());
//                int[] Computershot = input.GenerateShootForComputer();
//                if(input.Handleshot(Fleet1, Computershot)==2) {
//                    Computershot[0] = input.GenerateShootForComputer()[0];
//                    Computershot[1] = input.GenerateShootForComputer()[1];
//                } else if (input.Handleshot(Fleet1, Computershot)==0) {
//                    System.out.println("Missed!");
//                    input.player1.getGrid().getPoint(Computershot[0], Computershot[1]).setPointStatus(PointStatus.MISSED);
//                } else {
//                    continue;
//                }
//                input.player1.updategrid(Fleet1);
//                input.player2.updategrid(Fleet2);
//                display.printComputergrid(input.player2.getGrid());
//                System.out.println("-------------------");
//                display.printPlayergrid(input.player1.getGrid());
//
//                //human turn
//                int[] humanshot = input.InputShoot(0);
//                if(input.Handleshot(Fleet2, humanshot)==2) {
//                    humanshot[0] = input.InputShoot(0)[0];
//                    humanshot[1] = input.InputShoot(0)[1];
//                } else if (input.Handleshot(Fleet2, humanshot)==0) {
//                    System.out.println("Missed!");
//                    input.player1.getGrid().getPoint(humanshot[0], humanshot[1]).setPointStatus(PointStatus.MISSED);
//                } else {
//                    continue;
//                }
//                input.player1.updategrid(Fleet1);
//                input.player2.updategrid(Fleet2);
//                display.printComputergrid(input.player2.getGrid());
//                System.out.println("-------------------");
//                display.printPlayergrid(input.player1.getGrid());

                int Hitpoints1 = 0;
                for(Ship ship: Fleet1) {
                    Hitpoints1 += ship.getHitcount();
                }
                if(Hitpoints1 == 31) {
                    System.out.println("Player 2 wins!");
                    GameOn = false;
                }
                int Hitpoints2 = 0;
                for(Ship ship: Fleet2) {
                    Hitpoints2 += ship.getHitcount();
                }
                if(Hitpoints2 == 31) {
                    System.out.println("Player 1 wins!");
                    GameOn = false;
                }
            }
        }
        System.out.println("Game over!");
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

//    public int HandleShot(List<Ship> Ships, int [] ShootCoordinator, int NumOfShips) {
//        int GameOver = 0;
//        //int HitCount = 0;
//        int flag = 0;
//        for(int i = 0; i < Ships.size(); i ++) {
//            for (int j = 0; j < Ships.get(i).getFields().size(); j++) {
//                if(ShootCoordinator[0] == Ships.get(i).getFields().get(j).getX() && ShootCoordinator[1] == Ships.get(i).getFields().get(j).getY()) {
//                    flag = 1;
//                } else {
//                    continue;
//                }
//            }
//        }
//
//        if(flag == 0) {
//
//        }
//
//        for(int i = 0; i < Ships.size(); i ++) {
//            for(int j = 0; j < Ships.get(i).getFields().size(); j++) {
//                if(ShootCoordinator[0] == Ships.get(i).getFields().get(j).getX() && ShootCoordinator[1] == Ships.get(i).getFields().get(j).getY()) {
//                    System.out.println("Hit!");
//                    Ships.get(i).getFields().get(j).setPointStatus(PointStatus.HIT);
//                    Ships.get(i).setHitcount(Ships.get(i).getHitcount()+1);
//                    System.out.println(Ships.get(i).getHitcount());
//                    if(Ships.get(i).getHitcount() == Ships.get(i).getFields().size()) {
//                        System.out.println("You sunk a ship!");
//                        NumOfShips --;
//                        for(int m = 0; m < Ships.get(i).getFields().size(); m++) {
//                            Ships.get(i).getFields().get(m).setPointStatus(PointStatus.SUNK);
//                        } System.out.println(Ships.get(i).getFields().get(0).getPointStatus());
//                    }
//                } else if (Ships.get(i).getFields().get(j).getPointStatus()==PointStatus.EMPTY){
//                    System.out.println("Missed!");
//                    Ships.get(i).getFields().get(j).setPointStatus(PointStatus.MISSED);
//                } else {
//                    GameOver = 2; // invalid shot
//                }
//            }
//        }
//        if(NumOfShips == 0) {
//            GameOver = 1;
//        }
//        return GameOver;
//    }

//    public Ship getShip(Point point, String side){
//        Ship target = null;
//        if(side == "human") {
//            List<Ship> player = Fleet1;
//            for (int i = 0; i < player.size(); i++) {
//                Ship ship = player.get(i);
//                List<Point> field = ship.getFields();
//                if (field.contains(point)) {
//                    target = ship;
//                }
//            }
//        } else if (side == "computer") {
//            List<Ship> player = Fleet2;
//            for (int i = 0; i < player.size(); i++) {
//                Ship ship = player.get(i);
//                List<Point> field = ship.getFields();
//                if ( field.contains(point)) {
//                    target = ship;
//                }
//            }
//        }
//        return target;
//    }

}
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Input {
    //Scanner scanner = new Scanner();

//    List<Point> StartingAndEndingPointForPlayer = new ArrayList<>();
//    List<Point> StartingAndEndingPointForComputer = new ArrayList<>();

    /* store the ship list for two Players */
    public List<Ship> Fleet1 = new ArrayList<>();
    public List<Ship> Fleet2 = new ArrayList<>();

    Display display = new Display();

    Player player1 = new Player(Fleet1);
    Player player2 = new Player(Fleet2);

    public Input() {
        PlaceShipCarrier();
        PlaceShipBattleship();
        PlaceShipPatrolBoat();
        PlaceShipSubmarine();
    }


    /* Put the staring and ending point of one ship in a list*/
    private List<Point> AskStartingAndEndingPointForShip(int len) {

        List<Point> StartingAndEndingPointForPlayer = new ArrayList<>();

        int l = 100;
        Boolean Flag;
        Flag = true;
        while(Flag) {
            System.out.println("Input Starting and Ending coordinator for the ship: ");
            Scanner s = new Scanner(System.in);
            String Coordinator = s.nextLine();
            int col_starting = Coordinator.charAt(0) - 'A';
            int row_starting = Coordinator.charAt(1) - '0';
            int col_ending = Coordinator.charAt(3) - 'A';
            int row_ending = Coordinator.charAt(4) - '0';
//            System.out.println("Select column for the starting coordinator of the ship: ");
//            int col_starting = TransferToNumber(scanner.next().charAt(0));
//            scanner.nextLine();
//            System.out.println("Select row for the starting coordinator of the ship: ");
//            int row_starting = scanner.nextInt();
//            scanner.nextLine();
//
//            System.out.println("Select column for the Ending coordinator of the ship: ");
//            int col_ending = TransferToNumber(scanner.next().charAt(0));
//            scanner.nextLine();
//            System.out.println("Select row for the Ending coordinator of the ship: ");
//            int row_ending = scanner.nextInt();
//            scanner.nextLine();


            if(col_starting == col_ending && col_ending <= 10 && row_ending <= 10 && row_starting <= 10) {
                l = Math.abs(row_starting - row_ending);
            }
            else if(row_starting == row_ending && row_starting <= 10 && col_starting <= 10 && col_ending <= 10){
                l = Math.abs(col_starting - col_ending);
            }
            else {
                System.out.println("ERROR! Please retry!"); /* make sure the staring and ending point are in a line and inside the grids*/
            }

            if(len - 1 == l) {
                Point starting_point = new Point(col_starting, row_starting, PointStatus.EMPTY);
                Point ending_point = new Point(col_ending, row_ending, PointStatus.EMPTY);
                StartingAndEndingPointForPlayer.add(starting_point);
                StartingAndEndingPointForPlayer.add(ending_point);
                Flag = false;
            }
        }
        return StartingAndEndingPointForPlayer;
    }
    private List<Point> GenerateStartingAndEndingPointForComputer(int len) {

        List<Point> StartingAndEndingPointForComputer = new ArrayList<>();

        Boolean Flag = true;
        Random r = new Random();
        int StartCol = r.nextInt(10);
        int StartRow = r.nextInt(10);
        while(Flag) {
            int n1 = r.nextInt(4);
            if(n1 == 0) {
                int EndCol = StartCol;
                int EndRow = StartRow + (len - 1);
                if(EndRow < 10) {
                    Flag = false;
                    Point starting_point = new Point(StartCol, StartRow, PointStatus.EMPTY);
                    Point ending_point = new Point(EndCol, EndRow, PointStatus.EMPTY);
                    StartingAndEndingPointForComputer.add(starting_point);
                    StartingAndEndingPointForComputer.add(ending_point);
                }
            }
            else if(n1 == 1) {
                int EndCol = StartCol + (len - 1);
                int EndRow = StartRow;
                if(EndCol < 10) {
                    Flag = false;
                    Point starting_point = new Point(StartCol, StartRow, PointStatus.EMPTY);
                    Point ending_point = new Point(EndCol, EndRow, PointStatus.EMPTY);
                    StartingAndEndingPointForComputer.add(starting_point);
                    StartingAndEndingPointForComputer.add(ending_point);
                }
            }
            else if(n1 == 2) {
                int EndCol = StartCol;
                int EndRow = StartRow - (len - 1);
                if(EndRow >= 0) {
                    Flag = false;
                    Point starting_point = new Point(StartCol, StartRow, PointStatus.EMPTY);
                    Point ending_point = new Point(EndCol, EndRow, PointStatus.EMPTY);
                    StartingAndEndingPointForComputer.add(starting_point);
                    StartingAndEndingPointForComputer.add(ending_point);
                }
            }
            else {
                int EndCol = StartCol - (len - 1);
                int EndRow = StartRow;
                if(EndCol >= 0) {
                    Flag = false;
                    Point starting_point = new Point(StartCol, StartRow, PointStatus.EMPTY);
                    Point ending_point = new Point(EndCol, EndRow, PointStatus.EMPTY);
                    StartingAndEndingPointForComputer.add(starting_point);
                    StartingAndEndingPointForComputer.add(ending_point);
                }
            }
        }

        return StartingAndEndingPointForComputer;
    }
    public void PlaceShipCarrier() {
        /* Player1 User*/
        for(int i = 1; i > 0; i--) {
            Ship NewShip = new Ship(new ArrayList<>(), ShipType.CARRIER, 0);

            System.out.println("Now place Carrier, 6-block long");
            List<Point> StartingAndEndingPointForPlayer = AskStartingAndEndingPointForShip(6);
            if(StartingAndEndingPointForPlayer.get(0).getX() == StartingAndEndingPointForPlayer.get(1).getX()) {
                int x = StartingAndEndingPointForPlayer.get(0).getX();
                int y = Math.min(StartingAndEndingPointForPlayer.get(0).getY(), StartingAndEndingPointForPlayer.get(1).getY());
                System.out.println(x);
                System.out.println(y);
                for(int j = 0; j < 6; j++) {
                    NewShip.add(new Point(x, y + j, PointStatus.CARRIER));
                }
            }
            else {
                int y = StartingAndEndingPointForPlayer.get(0).getY();
                int x = Math.min(StartingAndEndingPointForPlayer.get(0).getX(), StartingAndEndingPointForPlayer.get(1).getX());
                for(int j = 0; j < 6; j++) {
                    NewShip.add(new Point(x + j, y, PointStatus.CARRIER));
                }
            }
            if(NewShip.isPlacementOk(NewShip, Fleet1)) {
                Fleet1.add(NewShip);
            }
            else {
                i++;
            }
            player1.updategrid(player1.getFleet());
            display.printComputergrid(new Grid());
            System.out.println("-------------------");
            display.printPlayergrid(player1.getGrid());

        }
        /* Player2 Computer*/
        for(int i = 1; i > 0; i--) {
            Ship NewShip = new Ship(new ArrayList<>(), ShipType.CARRIER, 0);

            List<Point> StartingAndEndingPoint = GenerateStartingAndEndingPointForComputer(6);
            if(StartingAndEndingPoint.get(0).getX() == StartingAndEndingPoint.get(1).getX()) {
                int x = StartingAndEndingPoint.get(0).getX();
                int y = Math.min(StartingAndEndingPoint.get(0).getY(), StartingAndEndingPoint.get(1).getY());
                for(int j = 0; j < 6; j++) {
                    NewShip.add(new Point(x, y + j, PointStatus.CARRIER));
                }
            }
            else {
                int y = StartingAndEndingPoint.get(0).getY();
                int x = Math.min(StartingAndEndingPoint.get(0).getX(), StartingAndEndingPoint.get(1).getX());
                for(int j = 0; j < 6; j++) {
                    NewShip.add(new Point(x + j, y, PointStatus.CARRIER));
                }
            }
            if(NewShip.isPlacementOk(NewShip, Fleet2)) {
                Fleet2.add(NewShip);
            }
            else {
                i++;
            }
        }

    }
    public void PlaceShipBattleship() {
        for(int i = 2; i > 0; i--) {
            Ship NewShip = new Ship(new ArrayList<>(), ShipType.BATTLESHIP, 0);

            System.out.println("Now place Battleship, 4-block long");
            List<Point> StartingAndEndingPointForPlayer = AskStartingAndEndingPointForShip(4);

            if(StartingAndEndingPointForPlayer.get(0).getX() == StartingAndEndingPointForPlayer.get(1).getX()) {
                int x = StartingAndEndingPointForPlayer.get(0).getX();
                int y = Math.min(StartingAndEndingPointForPlayer.get(0).getY(), StartingAndEndingPointForPlayer.get(1).getY());
                for(int j = 0; j < 4; j++) {
                    NewShip.add(new Point(x, y + j, PointStatus.BATTLESHIP));
                }
            }
            else {
                int y = StartingAndEndingPointForPlayer.get(0).getY();
                int x = Math.min(StartingAndEndingPointForPlayer.get(0).getX(), StartingAndEndingPointForPlayer.get(1).getX());
                for(int j = 0; j < 4; j++) {
                    NewShip.add(new Point(x + j, y, PointStatus.BATTLESHIP));
                }
            }
            if(NewShip.isPlacementOk(NewShip, Fleet1)) {
                Fleet1.add(NewShip);
            }
            else {
                i++;
            }
            player1.updategrid(player1.getFleet());
            display.printComputergrid(new Grid());
            System.out.println("-------------------");
            display.printPlayergrid(player1.getGrid());
        }

        for(int i = 2; i > 0; i--) {
            Ship NewShip = new Ship(new ArrayList<>(), ShipType.BATTLESHIP, 0);

            List<Point> StartingAndEndingPoint = GenerateStartingAndEndingPointForComputer(4);
            if(StartingAndEndingPoint.get(0).getX() == StartingAndEndingPoint.get(1).getX()) {
                int x = StartingAndEndingPoint.get(0).getX();
                int y = Math.min(StartingAndEndingPoint.get(0).getY(), StartingAndEndingPoint.get(1).getY());
                for(int j = 0; j < 4; j++) {
                    NewShip.add(new Point(x, y + j, PointStatus.BATTLESHIP));
                }
            }
            else {
                int y = StartingAndEndingPoint.get(0).getY();
                int x = Math.min(StartingAndEndingPoint.get(0).getX(), StartingAndEndingPoint.get(1).getX());
                for(int j = 0; j < 4; j++) {
                    NewShip.add(new Point(x + j, y, PointStatus.BATTLESHIP));
                }
            }
            if(NewShip.isPlacementOk(NewShip, Fleet2)) {
                Fleet2.add(NewShip);
            }
            else {
                i++;
            }
        }

    }
    public void PlaceShipSubmarine() {
        for(int i = 3; i > 0; i--) {
            Ship NewShip = new Ship(new ArrayList<>(), ShipType.SUBMARINE, 0);

            System.out.println("Now place Submarine, 3-block long");
            List<Point> StartingAndEndingPointForPlayer = AskStartingAndEndingPointForShip(3);
            if(StartingAndEndingPointForPlayer.get(0).getX() == StartingAndEndingPointForPlayer.get(1).getX()) {
                int x = StartingAndEndingPointForPlayer.get(0).getX();
                int y = Math.min(StartingAndEndingPointForPlayer.get(0).getY(), StartingAndEndingPointForPlayer.get(1).getY());
                for(int j = 0; j < 3; j++) {
                    NewShip.add(new Point(x, y + j, PointStatus.SUBMARINE));
                }
            }
            else {
                int y = StartingAndEndingPointForPlayer.get(0).getY();
                int x = Math.min(StartingAndEndingPointForPlayer.get(0).getX(), StartingAndEndingPointForPlayer.get(1).getX());
                for(int j = 0; j < 3; j++) {
                    NewShip.add(new Point(x + j, y, PointStatus.SUBMARINE));
                }
            }
            if(NewShip.isPlacementOk(NewShip, Fleet1)) {
                Fleet1.add(NewShip);
            }
            else {
                i++;
            }
            if(i!=1) {
                player1.updategrid(player1.getFleet());
                display.printComputergrid(new Grid());
                System.out.println("-------------------");
                display.printPlayergrid(player1.getGrid());
            }
        }

        for(int i = 3; i > 0; i--) {
            Ship NewShip = new Ship(new ArrayList<>(), ShipType.SUBMARINE, 0);

            List<Point> StartingAndEndingPoint = GenerateStartingAndEndingPointForComputer(3);
            if(StartingAndEndingPoint.get(0).getX() == StartingAndEndingPoint.get(1).getX()) {
                int x = StartingAndEndingPoint.get(0).getX();
                int y = Math.min(StartingAndEndingPoint.get(0).getY(), StartingAndEndingPoint.get(1).getY());
                for(int j = 0; j < 3; j++) {
                    NewShip.add(new Point(x, y + j, PointStatus.SUBMARINE));
                }
            }
            else {
                int y = StartingAndEndingPoint.get(0).getY();
                int x = Math.min(StartingAndEndingPoint.get(0).getX(), StartingAndEndingPoint.get(1).getX());
                for(int j = 0; j < 3; j++) {
                    NewShip.add(new Point(x + j, y, PointStatus.SUBMARINE));
                }
            }
            if(NewShip.isPlacementOk(NewShip, Fleet2)) {
                Fleet2.add(NewShip);
            }
            else {
                i++;
            }
        }

    }
    public void PlaceShipPatrolBoat() {
        for(int i = 4; i > 0; i--) {
            Ship NewShip = new Ship(new ArrayList<>(), ShipType.PATROLBOAT, 0);

            System.out.println("Now place Patrol Boat, 2-block long");
            List<Point> StartingAndEndingPointForPlayer = AskStartingAndEndingPointForShip(2);
            if(StartingAndEndingPointForPlayer.get(0).getX() == StartingAndEndingPointForPlayer.get(1).getX()) {
                int x = StartingAndEndingPointForPlayer.get(0).getX();
                int y = Math.min(StartingAndEndingPointForPlayer.get(0).getY(), StartingAndEndingPointForPlayer.get(1).getY());
                for(int j = 0; j < 2; j++) {
                    NewShip.add(new Point(x, y + j, PointStatus.PATROLBOAT));
                }
            }
            else {
                int y = StartingAndEndingPointForPlayer.get(0).getY();
                int x = Math.min(StartingAndEndingPointForPlayer.get(0).getX(), StartingAndEndingPointForPlayer.get(1).getX());
                for(int j = 0; j < 2; j++) {
                    NewShip.add(new Point(x + j, y, PointStatus.PATROLBOAT));
                }
            }
            if(NewShip.isPlacementOk(NewShip, Fleet1)) {
                Fleet1.add(NewShip);
            }
            else {
                i++;
            }
            player1.updategrid(player1.getFleet());
            display.printComputergrid(new Grid());
            System.out.println("-------------------");
            display.printPlayergrid(player1.getGrid());
        }

        for(int i = 4; i > 0; i--) {
            Ship NewShip = new Ship(new ArrayList<>(), ShipType.PATROLBOAT, 0);

            List<Point> StartingAndEndingPoint = GenerateStartingAndEndingPointForComputer(2);
            if(StartingAndEndingPoint.get(0).getX() == StartingAndEndingPoint.get(1).getX()) {
                int x = StartingAndEndingPoint.get(0).getX();
                int y = Math.min(StartingAndEndingPoint.get(0).getY(), StartingAndEndingPoint.get(1).getY());
                for(int j = 0; j < 2; j++) {
                    NewShip.add(new Point(x, y + j, PointStatus.PATROLBOAT));
                }
            }
            else {
                int y = StartingAndEndingPoint.get(0).getY();
                int x = Math.min(StartingAndEndingPoint.get(0).getX(), StartingAndEndingPoint.get(1).getX());
                for(int j = 0; j < 2; j++) {
                    NewShip.add(new Point(x + j, y, PointStatus.PATROLBOAT));
                }
            }
            if(NewShip.isPlacementOk(NewShip, Fleet2)) {
                Fleet2.add(NewShip);
            }
            else {
                i++;
            }
        }

    }


    public int[] InputShoot(int player) {
        int GamePlayer = player + 1;

        System.out.println("Player " + GamePlayer + " shoot, please enter your choice: (e.g. A0)");

        Scanner s = new Scanner(System.in);
        String Coordinator = s.nextLine();
        int col_shoot = Coordinator.charAt(0) - 'A';
        int row_shoot = Coordinator.charAt(1) - '0';

//        System.out.println("Select the column for shoot point:");
//        int col_shoot = TransferToNumber(scanner.next().charAt(0));
//        scanner.nextLine();
//
//        System.out.println("Select the row for shoot point:");
//        int row_shoot = scanner.nextInt();
//        scanner.nextLine();

        return new int[]{col_shoot, row_shoot};
    }

    public int[] GenerateShootForComputer() {
        int [] Shoot = new int[2];
        System.out.println("Player 2 shoot");
        Random r = new Random();
        int col_shoot = r.nextInt(10);
        int row_shoot = r.nextInt(10);
        Shoot[0] = col_shoot;
        Shoot[1] = row_shoot;
        return Shoot;
    }

    public int Handleshot(List<Ship> fleet, int [] ShootCoordinator) {
        int isshotok = 0;  /// default status: missed
        for(Ship ship: fleet) {
            //int Sunkflag = 0;
            for(Point point: ship.getFields()) {
                if(point.getX()==ShootCoordinator[0] && point.getY()==ShootCoordinator[1]) {
                    switch (point.getPointStatus()) {
                        case HIT:
                        case SUNKP:
                        case SUNKB:
                        case SUNKC:
                        case SUNKS:
                            System.out.println("Already hit! Give another shot!");
                            isshotok = 2; /// invalid shot
                            break;
                        case SUBMARINE:
                        case PATROLBOAT:
                        case CARRIER:
                        case BATTLESHIP:
                            point.setPointStatus(PointStatus.HIT);
                            System.out.println("Hit!");
                            ship.setHitcount(ship.getHitcount()+1);
                            isshotok = 1; /// hit a ship
                            break;
                    }
                }
            }
            if(ship.getHitcount() == ship.getFields().size()) {
                for(Point point: ship.getFields()) {
                    switch(ship.getShipType()) {
                        case CARRIER :
                            point.setPointStatus(PointStatus.SUNKC);
                            break;
                        case SUBMARINE:
                            point.setPointStatus(PointStatus.SUNKS);
                            break;
                        case PATROLBOAT:
                            point.setPointStatus(PointStatus.SUNKP);
                            break;
                        case BATTLESHIP:
                            point.setPointStatus(PointStatus.SUNKB);
                            break;
                        }
                    }
                }
                //System.out.println("You sunk a ship!");
//                NumOfShips --;
        }
        return isshotok;
    }

//        if(NumOfShips == 0) {
//            GameOver = true;
//        }
//        return GameOver;

    private Integer TransferToNumber(char Character) {
        if (Character == 'A') {
            return 0;
        }
        else if(Character == 'B') {
            return 1;
        }
        else if(Character == 'C') {
            return 2;
        }
        else if(Character == 'D') {
            return 3;
        }
        else if(Character == 'E') {
            return 4;
        }
        else if(Character == 'F') {
            return 5;
        }
        else if(Character == 'G') {
            return 6;
        }
        else if(Character == 'H') {
            return 7;
        }
        else if(Character == 'I') {
            return 8;
        }
        else if(Character == 'J') {
            return 9;
        }
        else {
            return 100;
        }
    }

    public List<Ship> GetFleet1() {
        return Fleet1;
    }

    public List<Ship> GetFleet2() {
        return Fleet2;
    }


}
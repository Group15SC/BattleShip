import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Input {
    private Scanner scanner = new Scanner(System.in);
    private List<Board> boards = new ArrayList<>();
    int choice;
    List<Point> StartingAndEndingPointForShip = new ArrayList<>();

    List<Ship> Ships = new ArrayList<>();

    public List<Board> getBoards() {
        generateBoard();
        return boards;
    }

    public Input() {

    }

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
        else {
            return 9;
        }
    }

    private List<Point> AskStartingAndEndingPointForShip() {
        this.StartingAndEndingPointForShip = new ArrayList<>();

        System.out.println("Select row for the starting coordinator of the ship: ");
        int row_starting = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Select column for the starting coordinator of the ship: ");
        int col_starting = TransferToNumber(scanner.next().charAt(0));
        scanner.nextLine();
        Point starting_point = new Point(row_starting, col_starting, PointStatus.SHIP);
        StartingAndEndingPointForShip.add(starting_point);

        System.out.println("Select row for the Ending coordinator of the ship: ");
        int row_ending = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Select column for the Ending coordinator of the ship: ");
        int col_ending = TransferToNumber(scanner.next().charAt(0));
        scanner.nextLine();
        Point ending_point = new Point(row_ending, col_ending, PointStatus.SHIP);
        StartingAndEndingPointForShip.add(ending_point);

        return StartingAndEndingPointForShip;
    }


    public Ship createShip(int player) {
        int GamePlayer = player + 1;
        Square shipPart;
        Ship ship;
        System.out.println("Player " + GamePlayer + " place Ship");
        CoordinatesAndShipType = AskCoordForShipAndType();
        int row = CoordinatesAndShipType.get(0);
        int col = CoordinatesAndShipType.get(1);
        int shipType = CoordinatesAndShipType.get(2);
        shipPart = new Square(row, col, SquareStatus.SHIP);
        ship = new Ship(new ArrayList<>(), ShipType.values()[shipType - 1]);
        boards.get(player).placeShip(shipPart, ship);
        return ship;
    }
    public List<Point> CreateShip(int player) {

    }

    public void generateBoard() {
        Board board1 = new Board();
        Board board2 = new Board();
        boards.add(board1);
        boards.add(board2);
    }

    public int[] shoot(int player) {
        int GamePlayer = player + 1;
        System.out.println("Player " + GamePlayer + " shoot");
        System.out.println("select row :");
        int row = scanner.nextInt();
        scanner.nextLine();
        System.out.println("select col: ");
        int col = scanner.nextInt();
        return new int[]{row, col};
    }


}
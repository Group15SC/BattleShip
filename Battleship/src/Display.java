public class Display {
    //private static Grid grid = new Grid();
    private void horizontalgridline(){
        System.out.print(" ");
        for (int col = 65; col < 75; col++) {  // Ascii: A is 65, J is 74
            System.out.print(" " + (char) col);
        } System.out.println();
    }

    private void printboundary() {
        System.out.print(" ");
        for (int i = 0; i < 21; i++) {
            if (i % 2 == 0) {
                System.out.print('+');
            } else {
                System.out.print('-');
            }
        } System.out.println();
    }

    private void playermiddlepart(Point[][] m, int x, int y) {
        switch (m[x][y].getCharacter()) {
            case 'E': // if the point is empty, print space
                System.out.print(" " + "|");
                break;
            case 'H': // if the point is hit, print X
                System.out.print("X" + "|");
                break;
            case 'M': // if the bomb missed, print o
                System.out.print("o" + "|");
                break;
            case 'C':
            case 'B':
            case 'S':
            case 'P':
                System.out.print(m[x][y].getCharacter() + "|"); // need to replace!!!
                break;
            case 'K': // for the ships that is sunk, print the initial character (how?)
                ShipType type;
                type = Point.getShip(m[x][y], "human").getShipType();
                switch (type) {
                    case CARRIER:
                        System.out.print("C" + "|");
                    case BATTLESHIP:
                        System.out.print("B" + "|");
                    case SUBMARINE:
                        System.out.print("S" + "|");
                    case PATROLBOAT:
                        System.out.print("P" + "|");
                }
                break;
        }
    }

    private void computermiddlepart(Point[][] m, int x, int y) {
        switch (m[x][y].getCharacter()) {
            case 'E': // if the point is empty or placed, print space
            case 'C':
            case 'B':
            case 'S':
            case 'P':
                System.out.print(" "+"|");
                break;
            case 'H': // if the point is hit, print X
                System.out.print("X"+"|");
                break;
            case 'M': // if the bomb missed, print o
                System.out.print("o"+"|");
                break;
            case 'K': // for the ships that is sunk, print the initial character (how?)
                ShipType type;
                type = Point.getShip(m[x][y], "computer").getShipType();
                switch (type){
                    case CARRIER:
                        System.out.print("C"+"|");
                    case BATTLESHIP:
                        System.out.print("B"+"|");
                    case SUBMARINE:
                        System.out.print("S"+"|");
                    case PATROLBOAT:
                        System.out.print("P"+"|");
                }
        }
    }
    public void printPlayergrid(Point[][] m) {

        // missing boolean: decide which grid to print
        System.out.println("====== Ocean Grid ======");

        // printout the columns
        horizontalgridline();
        printboundary();

        // printout the middle part of the ocean
        for(int y = 0; y < 10; y++) {
            for(int x = 0; x < 10; x++) {
                if (x == 0) {
                    System.out.print(y + "|");
                    playermiddlepart(m, x, y);
                } else if (x == 9) {
                    playermiddlepart(m, x, y);
                    System.out.print("|" + x);
                } else {
                    playermiddlepart(m, x, y);
                }
            } System.out.println();
        }

        // printout the lower part of the ocean
        printboundary();
        horizontalgridline();

        System.out.println("========================");
    }

    public void printComputergrid(Point[][] m) {

        System.out.println("====== Target Grid ======");

        // printout the columns
        horizontalgridline();
        printboundary();

        // printout the middle part of the ocean
        for(int y=0; y < 10; y++) {  /// REPLACE with alphabet!!
            for(int x = 0; x < 10; x++) {
                if (x == 0) {
                    System.out.print(y + "|");
                    computermiddlepart(m, x, y);
                } else if (x == 9) {
                    computermiddlepart(m, x, y);
                    System.out.print("|" + x);
                } else {
                    computermiddlepart(m, x, y);
                }
            } System.out.println();
        }

        // printout the lower part of the ocean
        printboundary();
        horizontalgridline();

        System.out.println("========================");
    }

}

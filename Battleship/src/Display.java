public class Display {

    public void printemptygrids() {
        System.out.println();
        System.out.println("Welcome to BATTLESHIP GAME!");
        System.out.println("In this game, there are two players. You are Player 1.\n");
        System.out.println("Each player has a fleet consists of 10 ships:");
        System.out.println("1 Carrier (6-block long)");
        System.out.println("2 Battleships (4-block long)");
        System.out.println("3 Submarines (3-block long)");
        System.out.println("4 Patrol boats (2-block long)\n");
        System.out.println("Please follow the hint and enter your coordinate choice(column first)");
        System.out.println("E.g. A0,A2 (no space)\n");
        System.out.println("Now, game begins! Have fun!");
        System.out.println("**************************");
        System.out.println("");
        printComputergrid(new Grid());
        System.out.println("------------------------");
        printPlayergrid(new Grid());
    }

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

//    Game game = new Game();

    private void playermiddlepart(Grid grid, int x, int y) {
        switch (grid.getPoint(x, y).getCharacter()) {
            case "E": // if the point is empty, print space
                System.out.print(" " + "|");
                break;
            case "H": // if the point is hit, print X
                System.out.print("X" + "|");
                break;
            case "M": // if the bomb missed, print o
                System.out.print("o" + "|");
                break;
            case "C":
            case "B":
            case "S":
            case "P":
                System.out.print(grid.getPoint(x, y).getCharacter() + "|"); // need to replace!!!
                break;
            case "KC":// for the ships that is sunk, print the initial character
                System.out.print("C" + "|");
                break;
            case "KB":
                System.out.print("B" + "|");
                break;
            case "KP":
                System.out.print("P" + "|");
                break;
            case "KS":
                System.out.print("S" + "|");
                break;
//                ShipType type;
//                Game game = new Game();
//                type = game.getShip(grid.getPoint(x, y), "human").getShipType();
//                switch (type) {
//                    case CARRIER:
//                        System.out.print("C" + "|");
//                    case BATTLESHIP:
//                        System.out.print("B" + "|");
//                    case SUBMARINE:
//                        System.out.print("S" + "|");
//                    case PATROLBOAT:
//                        System.out.print("P" + "|");
//                }
            default:
                System.out.print(" " + "|");
        }
    }

    private void computermiddlepart(Grid grid, int x, int y) {
        switch (grid.getPoint(x, y).getCharacter()) {
            case "E":
            case "C":
            case "B":
            case "S":
            case "P":
                System.out.print(" "+"|");
                break;
            case "H": // if the point is hit, print X
                System.out.print("X"+"|");
                break;
            case "M": // if the bomb missed, print o
                System.out.print("o"+"|");
                break;
            case "KC":// for the ships that is sunk, print the initial character
                System.out.print("C" + "|");
                break;
            case "KB":
                System.out.print("B" + "|");
                break;
            case "KP":
                System.out.print("P" + "|");
                break;
            case "KS":
                System.out.print("S" + "|");
                break;
            //case 'K': // for the ships that is sunk, print the initial character (how?)
                //ShipType type;
//                type = Toolkit.getShip(grid.getPoint(x, y), ).getShipType();
//                switch (type){
//                    case CARRIER:
//                        System.out.print("C"+"|");
//                    case BATTLESHIP:
//                        System.out.print("B"+"|");
//                    case SUBMARINE:
//                        System.out.print("S"+"|");
//                    case PATROLBOAT:
//                        System.out.print("P"+"|");
//                } break;
        }
    }

    public void printPlayergrid(Grid grid) {

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
                    playermiddlepart(grid, x, y);
                } else if (x == 9) {
                    playermiddlepart(grid, x, y);
                    System.out.print(y);
                } else {
                    playermiddlepart(grid, x, y);
                }
            } System.out.println();
        }

        // printout the lower part of the ocean
        printboundary();
        horizontalgridline();

        System.out.println("========================");
    }

    public void printComputergrid(Grid grid) {

        System.out.println("====== Target Grid ======");

        // printout the columns
        horizontalgridline();
        printboundary();

        // printout the middle part of the ocean
        for(int y=0; y < 10; y++) {  /// REPLACE with alphabet!!
            for(int x = 0; x < 10; x++) {
                if (x == 0) {
                    System.out.print(y + "|");
                    computermiddlepart(grid, x, y);
                } else if (x == 9) {
                    computermiddlepart(grid, x, y);
                    System.out.print(y);
                } else {
                    computermiddlepart(grid, x, y);
                }
            } System.out.println();
        }

        // printout the lower part of the ocean
        printboundary();
        horizontalgridline();

        System.out.println("========================");
    }

}
//-------------------------- backup -------------------------
// point[][] version
//    private void playermiddlepart(Point[][] m, int x, int y) {
//        switch (m[x][y].getCharacter()) {
//            case 'E': // if the point is empty, print space
//                System.out.print(" " + "|");
//                break;
//            case 'H': // if the point is hit, print X
//                System.out.print("X" + "|");
//                break;
//            case 'M': // if the bomb missed, print o
//                System.out.print("o" + "|");
//                break;
//            case 'C':
//            case 'B':
//            case 'S':
//            case 'P':
//                System.out.print(m[x][y].getCharacter() + "|"); // need to replace!!!
//                break;
//            case 'K': // for the ships that is sunk, print the initial character (how?)
//                ShipType type;
//                type = Point.getShip(m[x][y], "human").getShipType();
//                switch (type) {
//                    case CARRIER:
//                        System.out.print("C" + "|");
//                    case BATTLESHIP:
//                        System.out.print("B" + "|");
//                    case SUBMARINE:
//                        System.out.print("S" + "|");
//                    case PATROLBOAT:
//                        System.out.print("P" + "|");
//                }
//                break;
//        }
//    }
//------------------------------------------------------------




//Original!!!!!
//    public void printPlayergrid(Point[][] m) {
//
//        // missing boolean: decide which grid to print
//        System.out.println("====== Ocean Grid ======");
//
//        // printout the columns
//        horizontalgridline();
//        printboundary();
//
//        // printout the middle part of the ocean
//        for(int y = 0; y < 10; y++) {
//            for(int x = 0; x < 10; x++) {
//                if (x == 0) {
//                    System.out.print(y + "|");
//                    playermiddlepart(m, x, y);
//                } else if (x == 9) {
//                    playermiddlepart(m, x, y);
//                    System.out.print("|" + x);
//                } else {
//                    playermiddlepart(m, x, y);
//                }
//            } System.out.println();
//        }
//
//        // printout the lower part of the ocean
//        printboundary();
//        horizontalgridline();
//
//        System.out.println("========================");
//    }




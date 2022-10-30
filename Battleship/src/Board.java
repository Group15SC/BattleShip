public class Board {
    final int sizeX = 10;
    final int sizeY = 10;
    Point [][]matrix;

    public Board() {
        fillBoard(sizeX, sizeY);
    }

    public int getSizeX() {
        return sizeX;
    }
    public int getSizeY() {
        return sizeY;
    }

    public Point getPoint(int x, int y){
        return matrix[x][y];
    }

    public Point[][] fillBoard(int x, int y) {
        matrix = new Point[sizeX][sizeY];
        for (int row=0; row< x; row++) {
            for(int col= 0; col< y; col++) {
                matrix[row][col] = new Point(row,col,PointStatus.EMPTY);
            }
        }
        return  matrix;
    }



    public void placeShip(Point point, Ship ship) {
        switch (ship.getShipType().label){
            case 1:
                point.setPointStatus(PointStatus.SHIP);
                ship.add(point);
                break;
            case 2:
                point.setPointStatus(PointStatus.SHIP);
                ship.add(point);
                int x= point.getX();
                int y = point.getY();
                ship.add(new Point(x,y+1,PointStatus.SHIP));
            case 3:
                point.setPointStatus(PointStatus.SHIP);
                ship.add(point);
                x= point.getX();
                y = point.getY();
                ship.add(new Point(x,y+1,PointStatus.SHIP));
                ship.add(new Point(x,y+2,PointStatus.SHIP));
            case 4:
                point.setPointStatus(PointStatus.SHIP);
                ship.add(point);
                x= point.getX();
                y = point.getY();
                ship.add(new Point(x,y+1,PointStatus.SHIP));
                ship.add(new Point(x,y+2,PointStatus.SHIP));
                ship.add(new Point(x,y+3,PointStatus.SHIP));
        }
    }

}

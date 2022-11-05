//import java.util.List;
//import java.util.concurrent.CountDownLatch;
//import java.util.concurrent.CountedCompleter;
//
////import javafx.scene.effect.Light.Point;
//
//
//public class Logic{
//    private int remainingShips = 0;
//    private Grid grid;
//    private Ship ship;
//    private Point point;
//
//
//    public Logic(List<Ship>ships,Grid gird){
//        this.ships = ships;
//        this.grid = grid;
//    }
//
//    public Grid getgrid() {
//        return grid;
//    }
//
//    public Point getpoint(){
//        return point;
//    }
//
//
//
//    public boolean handleShot(int x, int y) {
//        for (Ship ship : ships) {
//            for(Point point : ship.getFields()) {
//                if(point.getY() == y && point.getX() == x && point.getPointStatus().equals(PointStatus.CARRIER && Count(point.pointstatus(CARRIER))<5)) {
//                    point.setPointStatus(PointStatus.HIT);
//                    grid.getPoint(x,y).setPointStatus(PointStatus.HIT);
//                    System.out.println("X");
//                    return true;
//                }
//                if (point.getY() == y && point.getX() == x && point.getPointStatus().equals(PointStatus.CARRIER && Count(Point.pointstatus(CARRIER)) == 5)) {
//                    Point.setPointStatus(PointStatus.SUNK); ///get the list of the ship
//                    grid.getPoint().setPointStatus(PointStatus.SUNK);
//                    System.out.println("C");
//                    return true;
//                }
//                if(point.getY() == y && point.getX() == x && point.getPointStatus().equals(PointStatus.BATTLESHIP1 && Count(Point.pointstatus(BATTLESHIP1))<3)) {
//                    point.setPointStatus(PointStatus.HIT);
//                    grid.getPoint(x,y).setPointStatus(PointStatus.HIT);
//                    System.out.println("X");
//                    return true;
//                }
//                if(point.getY() == y && point.getX() == x && point.getPointStatus().equals(PointStatus.BATTLESHIP1 &&  Count(Point.pointstatus(BATTLESHIP1)) == 3)) {
//                    point.setPointStatus(PointStatus.SUNK);
//                    grid.getPoint().setPointStatus(PointStatus.SUNK);
//                    System.out.println("B");
//                    return true;
//                }
//                if(point.getY() == y && point.getX() == x && point.getPointStatus().equals(PointStatus.SUBMARINE1 &&  Count(Point.pointstatus(SUBMARINE1))<2)) {
//                    point.setPointStatus(PointStatus.HIT);
//                    grid.getPoint(x,y).setPointStatus(PointStatus.HIT);
//                    System.out.println("X");
//                    return true;
//
//                    if(point.getY() == y && point.getX() == x && point.getPointStatus().equals(PointStatus.SUBMARINE1 &&   Count(Point.pointstatus(SUBMARINE1))== 2)) {
//                        Point.setPointStatus(PointStatus.SUNK);
//                        grid.getPoint().setPointStatus(PointStatus.SUNK);
//                        System.out.println("S");
//                        return true;
//                    }
//                    if(point.getY() == y && point.getX() == x && point.getPointStatus().equals(PointStatus.PATROLBOAT1 && Count(Point.pointstatus(PATROLBOAT1)<1))) {
//                        point.setPointStatus(PointStatus.HIT);
//                        grid.getPoint(x,y).setPointStatus(PointStatus.HIT);
//                        System.out.println("X");
//                        return true;
//                    }
//                    if(point.getY() == y && point.getX() == x && point.getPointStatus().equals(PointStatus.PATROLBOAT1 && Count(Point.pointstatus(PATROLBOAT1)) == 1)) {
//                        Point.setPointStatus(PointStatus.SUNK);
//                        grid.getPoint().setPointStatus(PointStatus.SUNK);
//                        System.out.println("P");
//                        return true;
//                    }
//
//                    if(point.getY() == y && point.getX() == x && point.getPointStatus().equals(PointStatus.HIT)){
//                        point.setPointStatus(PointStatus.HIT);
//                        grid.getPoint(x,y).setPointStatus(PointStatus.HIT);
//                        System.out.println("overlapping");
//                        return  false;
//                    }
//
//                }
//            }
//
//            grid.getPoint(x,y).setPointStatus(PointStatus.EMPTY);
//            point.setPointStatus(PointStatus.MISSED);
//            grid.getPoint(x,y).setPointStatus(PointStatus.MISSED);
//            System.out.println("O");
//            return  true;
//
//        }
//
//
//
//    }
//}
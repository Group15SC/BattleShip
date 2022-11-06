//import java.util.List;
//
////import javafx.scene.effect.Light.Point;
//
//
//public class Logic{
//    private Ship ship;
//    private static Grid grid;
//
//    public Logic(List<Ship>ships,Grid gird){
//        Logic.ships = ships;
//        Logic.grid = grid;
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
//    public static ship getship(string side){
//
//        boolean handleShot(int x ,int y ){
//            if(side == "human"){
//
//
//                for (Ship ship : ships) {
//                    for(Point point : ship.getFields()) {
//                        if(point.getY() == y && point.getX == x && point.getPointStatus().equals(PointStatus.CARRIER) || point.getPointStatus().equals(PointStatus.BATTLESHIP) || point.getPointStatus().equals(PointStatus.SUBMARINE) ||point.getPointStatus().equals(PointStatus.PATROLBOAT) && point(x,y).equals(Player1.list(ship).point())) {
//                            for(int i=0; i<ship.getFields().size();i++){
//                                point().setPointStatus(PointStatus.HIT);
//                                grid.getPoint(x,y).setPointStatus(PointStatus.HIT);
//                            }
//                            List(ship).point.setPointStatus(PointStatus.SUNK);
//                            grid.getList(ship).point.setPointStatus(PointStatus.SUNK);
//                            return true;
//                        }
//                    }
//                }
//            }
//
//
//
//            if(side == "computer"){
//                for (Ship ship : ships) {
//                    for(Point point : ship.getFields()) {
//                        if(point.getY() == y && point.getX == x && point.getPointStatus().equals(PointStatus.CARRIER) || point.getPointStatus().equals(PointStatus.BATTLESHIP) || point.getPointStatus().equals(PointStatus.SUBMARINE) ||point.getPointStatus().equals(PointStatus.PATROLBOAT) && point(x,y).equals(Player2.list(ship).point())) {
//                            for(int i=0; i<ship.getFields().size();i++){
//                                point().setPointStatus(PointStatus.HIT);
//                                grid.getPoint(x,y).setPointStatus(PointStatus.HIT);
//                            }
//                            List(ship).point.setPointStatus(PointStatus.SUNK);
//                            grid.getList(ship).point.setPointStatus(PointStatus.SUNK);
//                            return true;
//                        }
//                    }
//                }
//            }
//            if(point.getY() == y && point.getX() == x && point.getPointStatus().equals(PointStatus.HIT)){
//                Point().setPointStatus(PointStatus.HIT);
//                grid.getPoint(x,y).setPointStatus(PointStatus.HIT);
//                return  false;
//            }
//
//        }
//
//
//
//
//
//        grid.getPoint(x,y).setPointStatus(PointStatus.EMPTY);
//        point.setPointStatus(PointStatus.Missed);
//        grid.getPoint(x,y).setPointStatus(PointStatus.Missed);
//        return  true;
//
//
//    }
//
//
//
//}

public class Logic {



}
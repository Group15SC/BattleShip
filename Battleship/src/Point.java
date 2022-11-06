import java.util.List;

public class Point {

    private int x;
    private int y;
    private PointStatus pointStatus;


    public Point(int x, int y, PointStatus pointStatus) {
        this.x = x;
        this.y = y;
        this.pointStatus = pointStatus;
    }

    public void setPointStatus(PointStatus pointStatus) {
        this.pointStatus = pointStatus;
    }

    public void setPoint(int x, int y, PointStatus pointStatus) {
        this.x = x;
        this.y = y;
        this.pointStatus = pointStatus;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public PointStatus getPointStatus() {
        return pointStatus;
    }

//    public static Ship getShip(Point point, String side){
//        Game game = new Game();
//        Ship target = null;
//        if(side == "human") {
//            List<Ship> player = game.UpdatePlayer1();
//            for (int j = 0; j < player.size(); j++) {
//                Ship ship = player.get(j);
//                List<Point> field = ship.getFields();
//                if (field.contains(point)) {
//                    target = ship;
//                }
//            }
//        } else if (side == "computer") {
//            List<Ship> player = game.UpdatePlayer2();
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

    public String getCharacter() {
        String result= " ";
        switch (pointStatus) {

            case EMPTY :
                result = "E";
                break;
            case HIT:
                result = "H";
                break;
            case CARRIER:
                result = "C";
                break;
            case BATTLESHIP:
                result = "B";
                break;
            case SUBMARINE:
                result = "S";
                break;
            case PATROLBOAT:
                result = "P";
                break;
            case SUNKC:
                result = "KC";
                break;
            case SUNKB:
                result = "KB";
                break;
            case SUNKP:
                result = "KP";
                break;
            case SUNKS:
                result = "KS";
                break;
            case MISSED:
                result = "M";
                break;
        }
        return result;
    }
}

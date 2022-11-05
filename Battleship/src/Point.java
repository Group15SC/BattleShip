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



    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public PointStatus getPointStatus() {
        return pointStatus;
    }

    public static Ship getShip(Point point, String side){
        Input input = new Input();
        Ship target = null;
        if(side == "human") {
            List<Ship> player = input.GetPlayer1();
            for (int j = 0; j < player.size(); j++) {
                Ship ship = player.get(j);
                List<Point> field = ship.getFields();
                if (field.contains(point)) {
                    target = ship;
                }
            }
        } else if (side == "computer") {
            List<Ship> player = input.GetPlayer2();
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

    public char getCharacter() {
        char result=' ';
        switch (pointStatus) {

            case EMPTY :
                result = 'E';
                break;
            case HIT:
                result = 'H';
                break;
            case CARRIER:
                result = 'C';
                break;
            case BATTLESHIP:
                result = 'B';
                break;
            case SUBMARINE:
                result = 'S';
                break;
            case PATROLBOAT:
                result = 'P';
                break;
            case SUNK:
                result = 'K';
                break;
            case MISSED:
                result = 'M';
                break;
        }
        return result;
    }
}

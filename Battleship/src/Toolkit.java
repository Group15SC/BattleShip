import java.util.List;

public class Toolkit {
    public static Ship getShip(Point point, List<Ship> Fleet){
        Ship target = null;
        List<Ship> player = Fleet;
        for (int i = 0; i < player.size(); i++) {
            Ship ship = player.get(i);
            List<Point> field = ship.getFields();
            if (field.contains(point)) {
                target = ship;
            }
        }
        return target;
    }
}

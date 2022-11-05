import java.util.List;

public class Ship {

    private List<Point> NewShip;
    private ShipType shipType;

    public Ship(List<Point> fields, ShipType shipType) {
        this.NewShip = fields;
        this.shipType = shipType;
    }

    public boolean isPlacementOk(Ship ship1, List<Ship> ships) {
        boolean Flag = true;
        for(int i = 0; i < ships.size(); i++) {
            for(int j = 0; j < ships.get(i).getFields().size(); j++) {
                for(int k = 0; k < ship1.getFields().size(); k++) {
                    if((ship1.getFields().get(k).getX() == ships.get(i).getFields().get(j).getX() &&
                            ship1.getFields().get(k).getY() == ships.get(i).getFields().get(j).getY())) {
                        Flag = false;
                    }
                }
            }
        }
        return Flag;
    }



    public ShipType getShipType() {
        return shipType;
    }



    public List<Point> getFields() {
        return NewShip;
    }



    public void add(Point point) {

        NewShip.add(point);
    }
}

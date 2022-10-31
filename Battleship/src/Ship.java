import java.util.List;

public class Ship {

    private List<Point> NewShip;
    private ShipType shipType;

    public Ship(List<Point> fields, ShipType shipType) {
        this.NewShip = fields;
        this.shipType = shipType;
    }

    public boolean isPlacementOk(Ship ship1, List<Ship> ships, Board board) {
        int count = 0;
        for(int i= 0; i< ship1.getFields().size(); i++) {
            if((ship1.getFields().get(i).getY() > 10) ||
                    (ship1.getFields().get(i).getX() > 10)) {
                count++ ;
            }
            for(int k = 0; k < ships.size();k++) {
                for(int z= 0; z< ships.get(k).getFields().size(); z++) {
                    if((ship1.getFields().get(i).getX() == ships.get(k).getFields().get(z).getX() &&
                            ship1.getFields().get(i).getY() == ships.get(k).getFields().get(z).getY())) {
                        count ++ ;
                    }
                }
            }
        }
        if (count == 0) {
            return true;
        }
        return false;
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

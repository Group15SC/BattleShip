import java.util.List;

public class Player {

    private List<Ship> fleet;
    private Grid grid;

    //Input input = new Input();

    public Player(List<Ship> fleet) {
        this.fleet = fleet;
        this.grid = AddShipsToGrid(fleet);
    }

    public List<Ship> getFleet() {
        return fleet;
    }

    public Grid getGrid() {
        return grid;
    }

    public void setFleet(List<Ship> fleet) {
        this.fleet = fleet;
    }

    public Grid AddShipsToGrid(List<Ship> Ships) {
        Grid m = new Grid();
        for (int i = 0; i < Ships.size(); i++) {
            for (int j = 0; j < Ships.get(i).getFields().size(); j++) {
                int x = Ships.get(i).getFields().get(j).getX();
                int y = Ships.get(i).getFields().get(j).getY();
                PointStatus Status = Ships.get(i).getFields().get(j).getPointStatus();
                m.getPoint(x, y).setPoint(x, y, Status);
            }
        }
        return m;
    }

    public void updategrid(List<Ship> fleet) {
        for (int i = 0; i < fleet.size(); i++) {
            for (int j = 0; j < fleet.get(i).getFields().size(); j++) {
                int x = fleet.get(i).getFields().get(j).getX();
                int y = fleet.get(i).getFields().get(j).getY();
                PointStatus Status = fleet.get(i).getFields().get(j).getPointStatus();
                grid.getPoint(x, y).setPoint(x, y, Status);
            }
        }
    }

    public int Handleshot(List<Ship> fleet, int [] ShootCoordinator, int NumOfShips) {
        int isshotok = 0;  /// default status: missed
        for(Ship ship: fleet) {
            //int Sunkflag = 0;
            for(Point point: ship.getFields()) {
                if(point.getX()==ShootCoordinator[0] && point.getY()==ShootCoordinator[1]){
                    if(point.getPointStatus()==PointStatus.HIT || point.getPointStatus()==PointStatus.SUNKC ||
                            point.getPointStatus()==PointStatus.SUNKB || point.getPointStatus()==PointStatus.SUNKS ||
                            point.getPointStatus()==PointStatus.SUNKP) {
                        System.out.println("Already hit! Give another shot!");
                        isshotok = 2; /// invalid shot
                    } else {
                        point.setPointStatus(PointStatus.HIT);
                        System.out.println("Hit!");
                        ship.setHitcount(ship.getHitcount()+1);
                        isshotok = 1; /// hit a ship
                    }
                }
            }
            if(ship.getHitcount() == ship.getFields().size()) {
                for(Point point: ship.getFields()) {
                    switch(ship.getShipType()) {
                        case CARRIER :
                            point.setPointStatus(PointStatus.SUNKC);
                            break;
                        case SUBMARINE:
                            point.setPointStatus(PointStatus.SUNKS);
                            break;
                        case PATROLBOAT:
                            point.setPointStatus(PointStatus.SUNKP);
                            break;
                        case BATTLESHIP:
                            point.setPointStatus(PointStatus.SUNKB);
                            break;
                    }
                }
                //System.out.println("You sunk a ship!");
                NumOfShips --;
            }
        }
        return isshotok;
//        if(NumOfShips == 0) {
//            GameOver = true;
//        }
//        return GameOver;
    }

}

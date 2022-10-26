public enum ShipType {
    CARRIER(1),
    BATTLESHIP(2),
    SUBMARINE(3),
    PATROLBOAT(4);

    public final Integer label;

    private ShipType(Integer label) {
        this.label = label;
    }

}

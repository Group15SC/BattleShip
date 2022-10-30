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

    public char getCharacter() {
        char result=' ';
        switch (pointStatus) {

            case EMPTY :
                result = 'E';
                break;
            case HIT:
                result = 'H';
                break;
            case SHIP:
                result = 'S';
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

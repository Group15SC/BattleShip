import java.util.List;

public class Grid {
    int width = 10;

    int height = 10;
    Point [][] matrix;



    public Grid() {
        fillGrid(width, height);
    }

    public Point getPoint(int x, int y){
        return matrix[x][y];
    }

    public Point[][] fillGrid(int x, int y) {
        matrix = new Point[width][height];
        for (int row = 0; row < x; row++) {
            for(int col = 0; col < y; col++) {
                matrix[row][col] = new Point(row, col, PointStatus.EMPTY);
            }
        }
        return  matrix;
    }



}

package ir.rahkar.shortestPathFinding.util;

import com.sun.xml.internal.bind.v2.runtime.Coordinator;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

public class ShortestPathFinder {

    private static ShortestPathFinder shortestPathFinder = null;
    private static int[][] mat;
    private static Coordinate destinationCoordinate;
    private static int[][] surroundingCells = new int[][]{
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}};

    public static ShortestPathFinder getInstance(){
        if (shortestPathFinder == null)
            shortestPathFinder = new ShortestPathFinder();
        return shortestPathFinder;
    }

    public Coordinate findShortestPath(int[][] mat, int x, int y){
        ShortestPathFinder.mat = mat;
        if (mat == null)
            return null;
        Queue<Coordinate> queue = new LinkedList<>();
        boolean[][] visitedCells = new boolean [mat.length][mat[0].length];
        Coordinate front;
        findDestinationCoordinate();

        Coordinate source = new Coordinate(x,y,"",0);
        visitedCells[source.x][source.y] = true;
        queue.add(source);


        while (!queue.isEmpty()){
            int row,col;
            front = queue.peek();
            if (front.x == destinationCoordinate.x && front.y == destinationCoordinate.y)
                return front;

            queue.remove();

            for (int[] surroundingCell : surroundingCells) {
                row = front.x + surroundingCell[0];
                col = front.y + surroundingCell[1];
                if (isValid(row, col) && !visitedCells[row][col] && mat[row][col] > 0) {
                    visitedCells[row][col] = true;
                    queue.add(new Coordinate(row, col, front.getPath(), front.distance + 1));
                }
            }
        }
        return null;
    }

    private boolean isValid(int row,int col){
        return row >= 0 && row < mat.length && col >= 0 && col < mat.length;
    }

    private void findDestinationCoordinate(){
        for (int i=0; i< mat.length; i++){
            for (int j=0; j<mat[0].length; j++){
                if (mat[i][j] == 2){
                    destinationCoordinate = new Coordinate(i,j,"",0);
                    return;

                }
            }
        }
    }


    public class Coordinate{
       private int x;
       private int y;
       private String  path;
       private int distance;

       Coordinate(int x, int y, String path, int distance) {
            this.x = x;
            this.y = y;
            this.path = path + "->(" + x + "," + y + ")";
            this.distance = distance;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }


        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }


}

package ir.rahkar.shortestPathFinding;

import ir.rahkar.shortestPathFinding.util.ShortestPathFinder;

public class App 
{
    public static void main( String[] args )
    {
        int[][] mat = {
                { 1, 1, 1, 1, 1, 1, 0, 1, 1, 1 },
                { 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
                { 1, 1, 2, 1, 1, 1, 0, 1, 0, 1 },
                { 0, 0, 1, 0, 1, 0, 0, 0, 0, 1 },
                { 1, 1, 1, 0, 1, 1, 1, 1, 1, 0 },
                { 1, 0, 1, 1, 1, 1, 0, 1, 1, 0 },
                { 1, 0, 0, 0, 0, 0, 0, 0, 1, 1 },
                { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                { 1, 1, 0, 0, 0, 0, 1, 0, 0, 1 },
                { 1, 1, 0, 0, 0, 0, 1, 0, 0, 1 }
        };
        ShortestPathFinder.Coordinate coordinate = ShortestPathFinder.getInstance().findShortestPath(mat,9,9);
        if (coordinate != null)
            System.out.println(coordinate.getPath() + " distance is : " + coordinate.getDistance());
        else
            System.out.println("not found any path .....");
    }
}

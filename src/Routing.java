import sun.rmi.transport.Endpoint;

import java.util.*;

public class Routing {

    /**
     * TODO
     * <p>
     * The findPaths function takes a board and a list of goals that contain
     * endpoints that need to be connected. The function returns a list of
     * Paths that connect the points.
     */
    public static ArrayList<Wire>
    findPaths(Board board, ArrayList<Endpoints> goals) {
        // Iterate through each goal
        for (Endpoints goal : goals) {
            int id = goal.id;
            Coord start = goal.start;

            // Queue (uses endpoints to store start, end, and aggregate dist
            Queue<Endpoints> queue = new LinkedList<>();
            // Dictionary for path and cost
            Dictionary<Coord, Integer> paths = new Hashtable<>();

            for (Coord neighbor : board.adj(start)) {
                // Check if path to coord already found
                if (paths.)

                Endpoints edge = new Endpoints()
                queue.offer()
            }



        }
    }

}

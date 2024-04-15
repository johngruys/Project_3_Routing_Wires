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

        // Copy endpoints to new array list to leave original unmodified
        ArrayList<Endpoints> local = new ArrayList<>();
        for (Endpoints j : goals) {
            local.add(new Endpoints(j.id, j.start, j.end));
        }

        // Array lists to store wires
        ArrayList<Wire> result = new ArrayList<>();
        ArrayList<Wire> maxResult = new ArrayList<>();

        int i = 0;
        while (i!=local.size()) {
            Wire a = Routing.findWire(board, local.get(i));
            if (a == null) {
                i--;
                if (i == -1) {
                    return maxResult;
                }
                board.removeWire(result.get(i));

                maxResult=maxResult.size() < result.size() ? new ArrayList<>(result): maxResult;
                result.remove(i);
                local.add(local.remove(i));
            }
            else {
                i++;
                result.add(a);
            }
        }
        return result;
    }

    public static Wire findWire(Board board, Endpoints goal) {
        // Hashmap to store parents
        HashMap<Coord, Coord> parents = new HashMap<>();

        // Queue for BFS, storing points to be visited
        Queue<Coord> bfs = new ArrayDeque<>();
        boolean found = false;

        // Queue starting point
        bfs.add(goal.start);
        Coord current = null;

        // Do BFS while queue not empty
        while (!bfs.isEmpty()) {
            // Pop first element in queue
            current = bfs.poll();
            if (current.equals(goal.end)) {
                // If the current is the destination
                found = true;
                break;
            }
            // Check adjacent nodes
            for (Coord i : board.adj(current)) {
                // If not already visited, not an obstacle, or is the end point of the wires destination, add to queue
                if (!board.isObstacle(i) && (!board.isOccupied(i) || (board.getValue(i) == board.getValue(goal.end))) && !parents.containsKey(i)) {
                    bfs.add(i);
                    // Add to parents to store path and that it has been visited
                    parents.put(i, current);
                }
            }
        }

        if (found) {
            // Found path, backtrack through parents to get list of coords for wire
            ArrayList<Coord> tmp = new ArrayList<>();
            tmp.add(current);
            while (!current.equals(goal.start)) {
                Coord par = parents.get(current);
                tmp.add(par);
                current = par;
            }
            // Reverse order
            Collections.reverse(tmp);

            // Create, add and return new wire
            Wire a = new Wire(goal.id, tmp);
            board.placeWire(a);
            return a;
        } else {
            return null;
        }
    }

}

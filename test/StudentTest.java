import org.junit.jupiter.api.Test;
import java.time.Duration;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTimeout;

public class StudentTest {

//    @Test
//    public void testWire0() {
//        assertTimeout(Duration.ofMillis(1000), () -> {
//            Utilities.test("./test/inputs/wire0.in");
//        });
//    }

    // your tests go here
    @Test
    public void testWire1() throws Utilities.BoardConstructionException {

        ArrayList<Endpoints> goals     = new ArrayList<>();
        ArrayList<Integer[]> obstacles = new ArrayList<>();

        // Build the board.
        Board board = Utilities.buildBoard(goals, obstacles, "./test/inputs/wire1.in");

        // Call the findPaths function.

        // Start time
        long startTime = System.nanoTime();

        // Call Method
        ArrayList<Wire> wires = Routing.findPaths(board, goals);

        // Stop Time
        long endTime = System.nanoTime();
        long elapsedTime = (endTime - startTime) / 1000000;

        System.out.println("1000 x 1000 Grid --- 1 goal");
        System.out.println("Elapsed Time: " + elapsedTime + " milliseconds");
    }


    @Test
    public void testWire2() throws Utilities.BoardConstructionException {

        ArrayList<Endpoints> goals     = new ArrayList<>();
        ArrayList<Integer[]> obstacles = new ArrayList<>();

        // Build the board.
        Board board = Utilities.buildBoard(goals, obstacles, "./test/inputs/wire2.in");

        // Call the findPaths function.

        // Start time
        long startTime = System.nanoTime();

        // Call Method
        ArrayList<Wire> wires = Routing.findPaths(board, goals);

        // Stop Time
        long endTime = System.nanoTime();
        long elapsedTime = (endTime - startTime) / 1000000;

        System.out.println("1500 x 1500 Grid --- 1 goal");
        System.out.println("Elapsed Time: " + elapsedTime + " milliseconds");
    }

    @Test
    public void testWire3() throws Utilities.BoardConstructionException {

        ArrayList<Endpoints> goals     = new ArrayList<>();
        ArrayList<Integer[]> obstacles = new ArrayList<>();

        // Build the board.
        Board board = Utilities.buildBoard(goals, obstacles, "./test/inputs/wire3.in");

        // Call the findPaths function.

        // Start time
        long startTime = System.nanoTime();

        // Call Method
        ArrayList<Wire> wires = Routing.findPaths(board, goals);

        // Stop Time
        long endTime = System.nanoTime();
        long elapsedTime = (endTime - startTime) / 1000000;

        System.out.println("1500 x 1500 Grid --- 4 goal");
        System.out.println("Elapsed Time: " + elapsedTime + " milliseconds");
    }


}

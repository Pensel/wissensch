import java.util.Arrays;

public class Test {


    private static BFA bfa = new BFA();
    private static Dijkstra d = new Dijkstra();


    private static int[][] testNegativerCycle = {{0, 1, 2, 0, 0},
            {1, 0, -7, 5, 0},
            {2, -7, 0, 0, 7},
            {0, 5, 0, 0, 1},
            {0, 0, 7, 1, 0}};
    private static int[][] testNegativeKante = {{0, -1, 5, 0, 0},
            {-1, 0, 3, 3, 0},
            {5, 3, 0, 0, 2},
            {0, 3, 0, 0, 6},
            {0, 0, 2, 6, 0}};
    private static int[][] testStandard = {{0, 5, 1, 0, 0},
            {5, 0, 3, 2, 0},
            {1, 3, 0, 0, 11},
            {0, 2, 0, 0, 7},
            {0, 0, 11, 7, 0}};

    private static int[][] testDirected = {{0, 1, 0, 0, 0},
            {0, 0, 5, 10, 0},
            {3, 0, 0, 0, 2},
            {0, 0, 0, 0, 1},
            {0, 0, 0, 1, 0}};

    private static int[][] testBigger = {{0, 4, 0, 0, 0, 0, 0, 8, 0},
            {4, 0, 8, 0, 0, 0, 0, 11, 0},
            {0, 8, 0, 7, 0, 4, 0, 0, 2},
            {0, 0, 7, 0, 9, 14, 0, 0, 0},
            {0, 0, 0, 9, 0, 10, 0, 0, 0},
            {0, 0, 4, 14, 10, 0, 2, 0, 0},
            {0, 0, 0, 0, 0, 2, 0, 1, 6},
            {8, 11, 0, 0, 0, 0, 1, 0, 7},
            {0, 0, 2, 0, 0, 0, 6, 7, 0}
    };





    public static void tester(int[][] adjMatrix, int s)
    {
        bfa.wrapper(new Graph(adjMatrix),s);
        System.out.println();
        d.dijkstra(adjMatrix,s);
        System.out.println("____________________");
    }

    public static void main(String... arg)
    {

        tester(testNegativerCycle, 0);
        tester(testNegativeKante, 0);
        tester(testStandard, 0);
        tester(testDirected, 0);
        tester(testBigger, 0);

    }
}

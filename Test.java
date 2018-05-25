import java.util.Random;

public class Test {


    private static BFA bfa = new BFA();
    private static Dijkstra d = new Dijkstra();


    private static int[][] testNegativerCycle = {{0, 1, 2, 0, 0},
            {1, 0, -7, 5, 0},
            {2, 3, 0, 0, 7},
            {0, 5, 0, 0, 1},
            {0, 0, 7, 1, 0}};
    private static int[][] testNegativeKante = {{0, -1, 5, 0, 0},
            {1, 0, 3, 3, 0},
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




    public static void divider(int n)
    {
        for (int i=0; i<n; i++)
            System.out.println("____________________");
    }



    public static void testerHumanReadable(int[][] adjMatrix, int s)
    {
        Graph g = new Graph(adjMatrix);

        long startTime = System.nanoTime();
        bfa.bellmanFord(g,s,true);
        long endTime = System.nanoTime();
        divider(1);
        System.out.println("BFA Zeit in Nanosekunden:"+ (endTime - startTime));
        divider(1);
        startTime = System.nanoTime();
        d.dijkstra(adjMatrix,s,true);
        endTime = System.nanoTime();
        divider(1);
        System.out.println("Dijkstra Zeit in Nanosekunden:"+ (endTime - startTime));
        divider(2);
    }

    public static void testerDataDriven(int[][] adjMatrix)
    {
        Random random = new Random();

        int l = adjMatrix.length;
        Graph g;
        int rn;
        while (true)
        {
            rn = random.nextInt(l);
            long startTime = System.nanoTime();
            g = new Graph(adjMatrix);
            bfa.bellmanFord(g, rn, false);
            long endTime = System.nanoTime();
            System.out.println("B" + (endTime - startTime));

            startTime = System.nanoTime();
            d.dijkstra(adjMatrix, rn, false);
            endTime = System.nanoTime();
            System.out.println("D" + (endTime - startTime));
        }
    }

    public static void testerDataDrivenPremadeGraph(int[][] adjMatrix)
    {
        Random random = new Random();
        int l = adjMatrix.length;
        int rn;
        Graph g = new Graph(adjMatrix);
        while (true)
        {
            rn = random.nextInt(l);
            long startTime = System.nanoTime();

            bfa.bellmanFord(g, rn, false);
            long endTime = System.nanoTime();
            System.out.println("B" + (endTime - startTime));

            startTime = System.nanoTime();
            d.dijkstra(adjMatrix, rn, false);
            endTime = System.nanoTime();
            System.out.println("D" + (endTime - startTime));
        }
    }

    public static void main(String... args)
    {
        String flag;
        try
        {
            flag = args[0];
            if (flag.equals("POST"))
                testerDataDriven(testBigger);
            else if(flag.equals("PRE"))
                testerDataDrivenPremadeGraph(testBigger);
        }
        catch (Exception e)
        {

        }
        finally {
            testerHumanReadable(testNegativerCycle, 0);
            testerHumanReadable(testNegativeKante, 0);
            testerHumanReadable(testStandard, 0);
            testerHumanReadable(testDirected, 0);
            testerHumanReadable(testBigger, 0);
        }





    }
}

public class Test {

	private static BFA bfa = new BFA();
	private static Dijkstra d = new Dijkstra();

	private static int[][] testNegativerCycle = {{0, 9, 2, 0, 0},
            {9, 0, -8, 5, 0},
            {2, 3, 0, 0, 4},
			{0, 5, 0, 0, 1},
            {0, 0, 4, 1, 0}};
	private static int[][] testNegativeKante = {{0, 2, 1, 0, 0},
            {2, 0, -3, 5, 0},
            {1, 4, 0, 0, 1},
            {0, 5, 0, 0, 3},
            {0, 0, 1, 3, 0}};

    private static int[][] testStandard = {{0, 5, 1, 0, 0}, {5, 0, 3, 2, 0}, {1, 3, 0, 0, 11}, {0, 2, 0, 0, 7},
			{0, 0, 11, 7, 0}};

	/*private static int[][] testDirected = {{0, 1, 0, 0, 0}, {0, 0, 5, 10, 0}, {3, 0, 0, 0, 2}, {0, 0, 0, 0, 1},
			{0, 0, 0, 1, 0}};

	private static int[][] testBigger = {{0, 4, 0, 0, 0, 0, 0, 8, 0}, {4, 0, 8, 0, 0, 0, 0, 11, 0},
			{0, 8, 0, 7, 0, 4, 0, 0, 2}, {0, 0, 7, 0, 9, 14, 0, 0, 0}, {0, 0, 0, 9, 0, 10, 0, 0, 0},
			{0, 0, 4, 14, 10, 0, 2, 0, 0}, {0, 0, 0, 0, 0, 2, 0, 1, 6}, {8, 11, 0, 0, 0, 0, 1, 0, 7},
			{0, 0, 2, 0, 0, 0, 6, 7, 0}};
    */


    public static void tester(int[][] adjMatrix, int s, String identifier) {

		System.out.println("-------------------\n" + "|" + identifier + ":|" + "\n-------------------");
		Graph g = new Graph(adjMatrix);
		bfa.bellmanFord(g, s);
		System.out.println();
		d.dijkstra(adjMatrix, s);
		System.out.println("____________________");
	}

	public static void main(String... args) {
        tester(testStandard, 0, "Standard");
        tester(testNegativeKante, 0, "Negative Kante");
		tester(testNegativerCycle, 0, "Negativer Zyklus");


        //tester(testDirected, 0, "Gerichteter Graph");
		//tester(testBigger, 0, "Großer Graph");
	}
}

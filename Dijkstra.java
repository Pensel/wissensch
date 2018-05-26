import java.util.ArrayList;
import java.util.Arrays;

public class Dijkstra extends ShortestPath {
	private int[][] graph;
	private int[] distance;
	private int[] pred;
	private ArrayList<Integer> M;

	public Dijkstra() {
	}

	public void dijkstra(int[][] graph, int s) {
		M = new ArrayList<Integer>();
		this.graph = graph;
		int e1;
		distance = makeDistanceArray(graph.length,s); // Initialize Distances with Infinity and s with 0
		pred = new int[graph.length];
		M.add(s);
		pred[0] = -1;

		while (!M.isEmpty()) {
			e1 = getSmallestEdge(s);

			M.remove((Object) e1);
			for (int e2 = 0; e2 < graph[e1].length; e2++) {

				if (!(e2 == e1) && graph[e1][e2] != 0) {
					if (!(M.contains(e2)) && distance[e2] == Integer.MAX_VALUE) {
						M.add(e2);
					}
					relax(e1, e2);
				}

			}
		}
		pred[s] = s;
		//printOutput();

		printOutput("Dijkstra",distance,pred);
	}

	public void relax(int e1, int e2) {
		int temp = distance[e1] + graph[e1][e2];
		if (temp < distance[e2]) {
			distance[e2] = temp;
			pred[e2] = e1;
		}
	}

	public int getSmallestEdge(int s) {
		int index = s;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < distance.length; i++) {
			if (M.contains(i) && pred[i] != -1) {
				if (distance[i] < min) {
					min = distance[i];
					index = i;
				}
			}
		}
		return index;
	}

	/*public void printOutput() {
		System.out.println("Dijkstra: ");
		for (int i = 0; i < distance.length; i++) {

			System.out.println("Knoten: " + i + " | Distance: " + distance[i] + " | Pred: " + pred[i]);
		}
	}*/

}
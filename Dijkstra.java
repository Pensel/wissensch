import java.util.ArrayList;

public class Dijkstra extends ShortestPath {
	private int[][] graph;
	private int[] entfernungen, vorgaenger;
	private ArrayList<Integer> M;
	private int aktuellerKnoten;// momentan besuchter Knoten
	private int knotenAnzahl;// N

	public Dijkstra() {
	}

	public void dijkstra(int[][] graph, int s) {
		this.graph = graph;
		knotenAnzahl = graph.length;
		M = new ArrayList<Integer>();// Menge der bekannten unbesuchten Ecken
		entfernungen = makeDistanceArray(knotenAnzahl, s);// vererbte Methode
		vorgaenger = makePredecessor(s);// initialisiert Vorgänger
		M.add(s);
		while (!M.isEmpty()) {// läuft N mal durch, da jede Ecke in M aufgenommen wird
			aktuellerKnoten = getSmallestEdge(s); // ermittelt in M enthaltenen Knoten mit der geringsten Distanz zu s

			M.remove((Object) aktuellerKnoten);
			for (int nachbarKnoten = 0; nachbarKnoten < knotenAnzahl; nachbarKnoten++) {// läuft N mal durch

				if (!(nachbarKnoten == aktuellerKnoten) && graph[aktuellerKnoten][nachbarKnoten] != 0) {
					if (!(M.contains(nachbarKnoten)) && entfernungen[nachbarKnoten] == Integer.MAX_VALUE) {
						M.add(nachbarKnoten);
					}
					relax(aktuellerKnoten, nachbarKnoten);// relaxiert Kanten
				}

			}
		}
		vorgaenger[s] = s;

		printOutput("Dijkstra", entfernungen, vorgaenger);// vererbte Methode
	}

	public void relax(int aktuellerKnoten, int nachbarKnoten) {
		int temp = entfernungen[aktuellerKnoten] + graph[aktuellerKnoten][nachbarKnoten];
		if (temp < entfernungen[nachbarKnoten]) {
			entfernungen[nachbarKnoten] = temp;
			vorgaenger[nachbarKnoten] = aktuellerKnoten;
		}
	}

	public int getSmallestEdge(int s) {
		int index = s;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < knotenAnzahl; i++) {
			if (M.contains(i) && vorgaenger[i] != -1) {
				if (entfernungen[i] < min) {
					min = entfernungen[i];
					index = i;
				}
			}
		}
		return index;
	}

	public int[] makePredecessor(int s) {
		int[] temp = new int[knotenAnzahl];
		temp[s] = -1;
		return temp;
	}

}
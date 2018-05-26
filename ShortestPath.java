public class ShortestPath {

	public int[] makeDistanceArray(int laenge, int start) {
		int[] entfernung = new int[laenge];
		for (int i = 0; i < entfernung.length; i++) {
			entfernung[i] = Integer.MAX_VALUE;
		}
		entfernung[start] = 0;
		return entfernung;
	}

	public void printOutput(String identifier, int[] entfernungen, int[] vorherige) {
		System.out.println(identifier + ":");
		for (int i = 0; i < entfernungen.length; i++) {
			System.out.println("Knoten: " + i + " | Entfernung: " + entfernungen[i] + " | Vorgänger: " + vorherige[i]);
		}
	}

}

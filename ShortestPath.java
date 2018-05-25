public class ShortestPath {

    public int[] makeDistanceArray(int laenge, int start){
        int[] entfernung = new int[laenge];
        for(int i = 0; i < entfernung.length; i++){
            entfernung[i] = Integer.MAX_VALUE;
        }
        entfernung[start]=0;
        return entfernung;
    }


    public void printOutput(int[] entfernungen, int[]... vorherige) {
        System.out.println(vorherige.length > 0 ? "Dijkstra: " : "BFA");
        for (int i = 0; i < entfernungen.length; i++) {
            System.out.println(vorherige.length > 0 ? "Knoten: " + i + " | Distance: " + entfernungen[i] + " | Pred: " + vorherige[0][i] : "Knoten: " + i + " | Distance: " + entfernungen[i]);
        }
    }

}

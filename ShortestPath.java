public class ShortestPath {

    public int[] makeDistanceArray(int len, int s){
        int[] distance = new int[len];
        for(int i = 0; i < distance.length; i++){
            distance[i] = Integer.MAX_VALUE;
        }
        distance[s]=0;
        return distance;
    }


    public void printOutput(int[] entfernungen, int[]... vorherige) {
        System.out.println(vorherige.length > 0 ? "Dijkstra: " : "BFA");
        for (int i = 0; i < entfernungen.length; i++) {
            System.out.println(vorherige.length > 0 ? "Knoten: " + i + " | Distance: " + entfernungen[i] + " | Pred: " + vorherige[0][i] : "Knoten: " + i + " | Distance: " + entfernungen[i]);
        }
    }

}

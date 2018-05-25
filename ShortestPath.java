public class ShortestPath {

    public int[] makeDistanceArray(int len, int s){
        int[] distance = new int[len];
        for(int i = 0; i < distance.length; i++){
            distance[i] = Integer.MAX_VALUE;
        }
        distance[s]=0;
        return distance;
    }


}

public class BFA extends ShortestPath{

    public BFA()
    {

    }


    private void bfm(int[][] graph, int s) throws Exception{
        final int numberOfVertices = graph.length;
        int[] distance = makeDistanceArray(graph.length , s);
        int[] pred = new int[graph.length];


        //for (int y = 0; y < numberOfVertices-1; y++)
        for(int e1 = 0; e1<numberOfVertices-1;e1++) {
            for (int e2 = 0; e2 <numberOfVertices; e2++) {
                if (!(e1 == e2) && graph[e1][e2] != 0) {

                    int temp =distance[e1] + graph[e1][e2];
                    if (temp < distance[e2]) {
                        distance[e2] = temp;
                        pred[e2] = e1;
                    }
                }
            }
        }

        for(int e1 = 0; e1<numberOfVertices-1;e1++) {
            for (int e2 = 0; e2 < numberOfVertices-1; e2++) {
                if (!(e1 == e2) && graph[e1][e2] != 0) {
                    int temp =distance[e1] + graph[e1][e2];
                    if (temp < distance[e2]) {
                        throw new Exception();
                    }
                }
            }
        }

        printResult(distance,pred);


    }
    private static void printResult(int[] distance, int[] pred){
        System.out.println("Bellman-Ford: ");
        for(int i=0;i<distance.length  ;i++){
            System.out.println("Knoten: "+ i + " | Distance: "+distance[i]+" | Previous: "+ pred[i]);
        }
    }


    public void versuche(int[][] graph, int s)
    {
        try {
            bfm(graph,s);
        }
        catch (Exception e)
        {
            System.out.println("Negativer Zyklus");
        }

    }

}

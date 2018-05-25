public class BFA extends ShortestPath
{


    private int[] entfernungen;
    private int knotenAnzahl;
    private Kante[] kanten;

    public BFA()
    {

    }


    public void bellmanFord(Graph g, int s) throws Exception
    {
        knotenAnzahl = g.getKnotenAnzahl();
        entfernungen = this.makeDistanceArray(knotenAnzahl,s);
        kanten = g.getKanten();


        for (int i = 0; i< knotenAnzahl -1; i++)
        {
            for (Kante kante: kanten)
            {
                int u = kante.getQuelle();
                int v = kante.getZiel();
                int gewicht = kante.getGewicht();

                if (entfernungen[u] != Integer.MAX_VALUE && entfernungen[u]+ gewicht <entfernungen[v])
                    entfernungen[v] = entfernungen[u] +gewicht;
            }
        }

        //negative cycle?

        for (Kante kante: kanten)
        {
            int u = kante.getQuelle();
            int v = kante.getZiel();
            int gewicht = kante.getGewicht();

            if (entfernungen[u] != Integer.MAX_VALUE && entfernungen[u]+ gewicht <entfernungen[v])
                throw new Exception("Negativer Zyklus!");
                //System.out.println("Negativer Zyklus!");

        }

        printOutput();
    }


    public void wrapper(Graph g, int s)
    {
        try{
            bellmanFord(g,s);
        }
        catch (Exception e)
        {
            System.out.println("Negativer Zyklus");
        }
    }

    public void printOutput() {
        System.out.println("BFA: ");
        for (int i = 0; i < entfernungen.length; i++) {

            System.out.println("Knoten: " + i + " | Distance: " + entfernungen[i]);
        }
    }

}
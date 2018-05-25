public class BFA extends ShortestPath
{

    private Graph g;
    private int[] entfernungen;
    private int s, knoten, kanten;


    public BFA()
    {

    }


    public void bellmanFord(Graph g, int s) throws Exception
    {
        this.g = g;
        entfernungen = this.makeDistanceArray(g.getKnotenAnzahl(),s);
        knoten = g.getKnotenAnzahl();
        kanten = g.getKantenAnzahl();

        for (int i=0; i<knoten-1; i++)
        {
            for (int j=0; j<kanten; j++)
            {
                int u = g.getKanteN(j).getQuelle();
                int v = g.getKanteN(j).getZiel();
                int gewicht = g.getKanten()[j].getGewicht();

                if (entfernungen[u] != Integer.MAX_VALUE && entfernungen[u]+ gewicht <entfernungen[v])
                    entfernungen[v] = entfernungen[u] +gewicht;
            }
        }

        //negative cycle?

        for (int k=0; k<kanten; k++)
        {
            int u = g.getKanteN(k).getQuelle();
            int v = g.getKanteN(k).getZiel();
            int gewicht = g.getKanteN(k).getGewicht();

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
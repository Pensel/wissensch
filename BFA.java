public class BFA extends ShortestPath
{


    private int[] entfernungen, vorgaenger;
    private int knotenAnzahl;
    private Kante[] kanten;
    private final String identifier = "BFA";

    public BFA()
    {

    }


    public void bellmanFord(Graph g, int s)
    {
        knotenAnzahl = g.getKnotenAnzahl();
        entfernungen = makeDistanceArray(knotenAnzahl,s); //vererbte Methode
        kanten = g.getKanten();
        vorgaenger = new int[knotenAnzahl];


        for (int i = 0; i< knotenAnzahl -1; i++) // n-1 durchläufe
        {
            for (Kante kante: kanten)
            {
                int ursprungsKnoten = kante.getUrsprungsKnoten();
                int zielKnoten = kante.getZielKnoten();
                int gewicht = kante.getGewicht();

                if (entfernungen[ursprungsKnoten] != Integer.MAX_VALUE && entfernungen[ursprungsKnoten]+ gewicht <entfernungen[zielKnoten]) // Relaxen der Kanten
                {
                    entfernungen[zielKnoten] = entfernungen[ursprungsKnoten] +gewicht;
                    vorgaenger[zielKnoten] = ursprungsKnoten;
                }
            }
        }


        for (Kante kante: kanten) //der N-te Durchlauf. Nach n-1 Durchläufen ist der schnellste Weg gefunden. Der n-te zeigt ob es negative Zyklen gibt.
        {
            int u = kante.getUrsprungsKnoten();
            int v = kante.getZielKnoten();
            int gewicht = kante.getGewicht();

            if (entfernungen[u] != Integer.MAX_VALUE && entfernungen[u]+ gewicht <entfernungen[v]) {
                System.out.println("Negativer Zyklus");
                break;
            }
        }



        printOutput(identifier,entfernungen, vorgaenger);
    }


}
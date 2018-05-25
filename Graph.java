public class Graph {

    private int knotenAnzahl, kantenAnzahl;
    private Kante[] kanten;


    public Graph(int[][] adjMatrix)
    {

        knotenAnzahl = adjMatrix.length;
        kantenAnzahl = 0;

        for (int i=0; i<adjMatrix.length; i++)
        {
            for (int j=0; j<adjMatrix.length; j++)
            {
                if(adjMatrix[i][j] != 0)
                    kantenAnzahl++;
            }
        }

        kanten = new Kante[kantenAnzahl];
        int counter = 0;

        for (int i=0; i<adjMatrix.length; i++)
        {
            for (int j=0; j<adjMatrix.length; j++)
            {
                if(adjMatrix[i][j] != 0)
                {
                    kanten[counter] = new Kante(i,j,adjMatrix[i][j]);
                    counter++;
                }
            }
        }

    }

    public int getKnotenAnzahl() {
        return knotenAnzahl;
    }

    public int getKantenAnzahl() {
        return kantenAnzahl;
    }

    public Kante[] getKanten() {
        return kanten;
    }

    public Kante getKanteN(int n)
    {
        return kanten[n];
    }
}

public class Graph {

    private int knotenAnzahl, kantenAnzahl;
    private Kante[] kanten;


    public Graph(int[][] adjazenzmatrix)
    {

        knotenAnzahl = adjazenzmatrix.length; //siehe Erklärung in der Arbeit
        kantenAnzahl = 0; //Zähler

        for (int ursprungsKnoten=0; ursprungsKnoten<adjazenzmatrix.length; ursprungsKnoten++)
        {
            for (int zielKnoten=0; zielKnoten<adjazenzmatrix.length; zielKnoten++)
            {
                if(adjazenzmatrix[ursprungsKnoten][zielKnoten] != 0)
                    kantenAnzahl++;
            }
        }

        kanten = new Kante[kantenAnzahl];

        int zaehler = 0; // nötig um alle Kanten zu setzen

        for (int ursprungsKnoten=0; ursprungsKnoten<adjazenzmatrix.length; ursprungsKnoten++)
        {
            for (int zielKnoten=0; zielKnoten<adjazenzmatrix.length; zielKnoten++)
            {
                if(adjazenzmatrix[ursprungsKnoten][zielKnoten] != 0) // wenn es eine Verbindung zwischen zwei Knoten gibt
                {
                    kanten[zaehler] = new Kante(ursprungsKnoten,
                            zielKnoten,
                            adjazenzmatrix[ursprungsKnoten][zielKnoten]); //Da ausgeschlossen ist das die Verbindung 0 ist, muss das das Gewicht zwischen den beiden sein.
                    zaehler++;
                }
            }
        }
    }

    public int getKnotenAnzahl() {
        return knotenAnzahl;
    }


    public Kante[] getKanten() {
        return kanten;
    }

}

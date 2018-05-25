public class Kante {

    private int quelle, ziel, gewicht;
    public Kante(int quelle, int ziel, int gewicht) {
        this.quelle = quelle;
        this.gewicht = gewicht;
        this.ziel = ziel;
    }

    public int getQuelle() {
        return quelle;
    }

    public int getZiel() {
        return ziel;
    }

    public int getGewicht() {
        return gewicht;
    }
}
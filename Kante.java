public class Kante {

    private int quelle, ziel, gewicht;
    public Kante(int quelle, int ziel, int gewicht) {
        this.quelle = quelle;
        this.gewicht = gewicht;
        this.ziel = ziel;
    }

    public void setQuelle(int quelle) {
        this.quelle = quelle;
    }

    public void setZiel(int ziel) {
        this.ziel = ziel;
    }

    public void setGewicht(int gewicht) {
        this.gewicht = gewicht;
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
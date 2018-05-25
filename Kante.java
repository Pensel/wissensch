public class Kante {

    private int ursprungsKnoten, zielKnoten, gewicht;
    public Kante(int ursprungsKnoten, int zielKnoten, int gewicht) {
        this.ursprungsKnoten = ursprungsKnoten;
        this.gewicht = gewicht;
        this.zielKnoten = zielKnoten;
    }

    public int getUrsprungsKnoten() {
        return ursprungsKnoten;
    }

    public int getZielKnoten() {
        return zielKnoten;
    }

    public int getGewicht() {
        return gewicht;
    }
}
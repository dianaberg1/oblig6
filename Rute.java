abstract public class Rute { //Skal ikke vaere mulig aa opprette instanser av klassen rute, derfor abstract
    
    protected int rader;
    protected int kolonner;
    protected Labyrint lab;

    public Rute(int rader, int kolonner, Labyrint lab){
        this.rader = rader;
        this.kolonner = kolonner;
        this.lab = lab;
    }

    //Referanser til sine eventuelle naboruter
    protected Rute nord;
    protected Rute soer;
    protected Rute oest;
    protected Rute vest;

    //Metoder for aa sette naboruter

    public void settNord(Rute nord){
        this.nord = nord;
    }

    public void settSoer(Rute soer){
        this.soer = soer;
    }

    public void settOest(Rute oest){
        this.oest = oest;
    }

    public void settVest(Rute vest){
        this.vest = vest;
    }

    //Finn-metode som skal redefineres i subklassene
    abstract public void finn(Rute fra);

    //Maa redefinere toString-metoden i subklassene
    abstract public String toString();
}

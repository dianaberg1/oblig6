public class SortRute extends Rute{

    public SortRute(int rader, int kolonner, Labyrint lab){
        super(rader, kolonner, lab);
    }

    //Finn-metoden i SortRute skal ikke gjoere noe ettersom de sorte rutene ikke er en vei
    @Override
    public void finn(Rute fra){
        return;
    }

    //Redefinerer toString
    @Override
    public String toString(){
        return " #";
    }
}

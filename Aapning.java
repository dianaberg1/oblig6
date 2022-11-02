public class Aapning extends HvitRute{

    public Aapning(int rader, int kolonner, Labyrint lab){
        super(rader, kolonner, lab);
    }

    //Naar en aapning blir funnet printes koordinatene ut
    @Override
    public void finn(Rute fra){
        System.out.println("(" + rader + "," + kolonner + ")");
    }
}

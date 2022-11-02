public class HvitRute extends Rute{

    public HvitRute(int rader, int kolonner, Labyrint lab){
        super(rader, kolonner, lab);
    }

    /*Spoer alle naboruter om veien videre, slik at vi kommer til en aapning uten aa gaa tilbake til 
    der vi kom fra*/
    @Override
    public void finn(Rute fra){
        if (nord != fra){
            nord.finn(this);
        } if (soer != fra){
            soer.finn(this);
        } if (vest != fra){
            vest.finn(this);
        } if (oest != fra){
            oest.finn(this);
        }
        return;
    }

    //Redefinerer toString
    @Override
    public String toString(){
        return " .";
    }
}

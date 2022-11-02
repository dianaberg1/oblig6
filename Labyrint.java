import java.io.*;
import java.util.*;

public class Labyrint{

    private int rader;
    private int kolonner;
    private Rute[][] lab; //Todimensjonal array som skal ta vare paa rader og kolonner

    public Labyrint(String filnavn){
        Scanner sc = null;
        try {
            File fil = new File(filnavn);
            sc = new Scanner(fil);
        } catch (FileNotFoundException e){ //Programmet skal terminere om filen ikke finnes
            System.out.println("Filen ble ikke funnet");
        }
        String linje = sc.nextLine();
        String[] info = linje.split(" "); //Splitter der det er mellomrom
        rader = Integer.parseInt(info[0]); //Foerste tall er rad
        kolonner = Integer.parseInt(info[1]); //Andre tall er kolonne
        lab = new Rute[rader][kolonner]; //Oppretter rutenettet
        int radTeller = 0; //Posisjonen til raden vi er paa

        while (sc.hasNextLine()){
            String ruter = sc.nextLine();
            String[] rutedata = ruter.split(""); //Splitter hvert eneste tegn
            //Looper gjennom alle tegnene og sjekker om det er en hvit eller sort rute
            /*Hvis det er en hvit rute maa vi sjekke om det er en aapning ved aa sjekke om vi befinner oss
            paa en av kantene til labyrinten*/
            Rute rute = null;
            for (int i = 0; i < kolonner; i++){
                //Hvis vi er paa oeverste eller nederste rad, sjekker vi om det finnes en aapning
                if (radTeller == 0 || radTeller == rader){
                    if (rutedata[i].equals(".")){
                        rute = new Aapning(radTeller, i, this);
                    } else if (rutedata[i].equals("#")){
                        rute = new SortRute(radTeller, i, this);
                    }
                //Sjekker for radene mellom oeverste og nederste
                } else {
                    if (rutedata[i].equals(".")){
                        //Hvis vi er paa venstre eller hoeyre kant, sjekker vi om det finnes en aapning
                        if (i == 0 || i == kolonner - 1){
                        rute = new Aapning(radTeller, i, this);
                    //Hvis vi ikke er paa kantene lager vi bare en vanlig hvit rute
                    } else {
                        rute = new HvitRute(radTeller, i, this);
                    }
                    //Lager sort rute
                    } else if (rutedata[i].equals("#")){
                        rute = new SortRute(radTeller, i, this);
                    }
                }
                lab[radTeller][i] = rute; //Setter inn ruten vi er paa i labyrinten
            }
            radTeller++; //Oeker linjetelleren (altsaa raden vi er paa)
        }
        sc.close(); //Lukker scanner

        //Setter naboene
        for (int i = 0; i < kolonner; i++){
            for (int j = 0; j < rader; j++){
                Rute rute = lab[j][i];
                if (i > 0){ //Hvis i > 0 betyr det at ruten har en nabo i vest
                    rute.settVest(lab[j][i-1]); //Setter inn naboruten
                } if (i < kolonner-1){ //Hvis i < kolonner-1 betyr det at ruten har en nabo i oest
                    rute.settOest(lab[j][i+1]); //Setter inn naboruten
                } if (j > 0){ //Hvis j > 0 betyr det at ruten har en nabo i nord
                    rute.settNord(lab[j-1][i]); //Setter inn naboruten
                } if (j < rader-1){ //Hvis j < rader-1 betyr det at ruten har en nabo i soer
                    rute.settSoer(lab[j+1][i]); //Setter inn naboruten
                } 
            }
        }
    }

    //Metode som kaller paa finn i ruten som ligger i posisjon (rad, kol) i labyrinten
    public void finnUtveiFra(int rad, int kol){
        Rute start = lab[rad][kol];
        start.finn(null); //Lar kallet for startruten vaere finn(null)
        return;
    }

    
    //Redefinerer toString-metoden slik at labyrinten kan skrives ut
    @Override 
    public String toString(){
        String string = "";
        //Itererer gjennom alle ruter og legger de til utskriften
        for (int i = 0; i < rader; i++){
            for (int j = 0; j < kolonner; j++){
                string += lab[i][j];
            }
            string += "\n";
        }
        return string;
    } 
}
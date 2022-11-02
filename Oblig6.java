import java.util.*;

public class Oblig6 {

    public static void main(String[] args){

        Labyrint lab = new Labyrint(args[0]); //Oppretter en labyrint av filnavnet som skrives inn
        //Printer labyrinten
        System.out.println("\nSlik ser labyrinten ut: \n");
        System.out.println(lab);

        Scanner sc = new Scanner(System.in); //Oppretter scanner
        boolean kommandoloekke = true;

        //Oppretter en kommandoloekke, skal kjoere helt til brukeren skriver inn -1
        while (kommandoloekke = true){
            System.out.println("\nSkriv inn koordinater <rad> <kolonne> ('-1' for aa avslutte)");
            String koordinater = sc.nextLine(); //Leser input fra brukeren
            //Hvis brukeren taster -1 gaar vi ut av kommandoloekken
            if (koordinater.equals("-1")){
                kommandoloekke = false;
                sc.close();
                System.exit(0);
            } else {
                System.out.println("\nAapninger: \n");
                int rad = Integer.parseInt(koordinater.split(" ")[0]);
                int kol = Integer.parseInt(koordinater.split(" ")[1]);
                //Finner aapningen fra koordinatene brukeren har skrevet inn
                lab.finnUtveiFra(rad, kol);
            }
        }
    }
}

import java.util.ArrayList;

public class Spiel {

	private String gesWort;
	private int fehlerAnzahl = 0;
	private char[] wortArr;
	private ArrayList <Character> schonVersucht = new ArrayList<Character>();
	private boolean gewonnen = false;
	private boolean verloren = false;
	private static final String validLetters = "abcdefghijklmnopqrstuvwxyzäöüß";
	
	Spiel(String gesWort){
		this.gesWort = gesWort.toLowerCase();
		this.wortArr = new char[gesWort.length()];
		for(int i = 0; i<wortArr.length; i++) {
			wortArr[i] = '_';
		}
	}
	
	public void verglChar(char eingabe){/*vergleicht den eingegebenen Buchstaben mit dem gesuchten Wort und den schon versuchten Buchstaben */
		eingabe = Character.toLowerCase(eingabe);
		if(validateInput(eingabe)) {
			if (schonVersucht(eingabe)) {
				System.out.println("Diesen Buchstaben hast du schon versucht");
			}else if(contains(eingabe, gesWort)) {
				for(int i = 0; i<gesWort.length(); i++) {
					if(eingabe == gesWort.charAt(i)){
						wortArr[i]=eingabe;
					}
				}
			}else{
				fehlerAnzahl++;
				schonVersucht.add(eingabe);
			}
		}else {
			System.out.println("Eingabe ist nicht gueltig, bitte erneut versuchen");
		}
	}
	
	private boolean schonVersucht(char test){/*ueberprueft ob der Buschstabe zuvor schonmal eingegeben wurde*/
		for(int i=0; i < schonVersucht.size(); i++){
			if(test == schonVersucht.get(i)){
				return true;
			}
		}
		//schonVersucht.add(test);
		return false;
		
	}
	
	private static boolean contains(char in, String pruefWert) { /*ueberprueft ob das gesuchte Wort den Buschstabe enthält*/
		for(int i =0; i<pruefWert.length(); i++) {
			if(in == pruefWert.charAt(i)) {
				return true;
			}
		}
		return false;
	}
	
	private static boolean validateInput(char input) { /*ueberprueft die ob die Eingabe im Deffinierten Wertebereich liegt*/
		input = Character.toLowerCase(input);
		if(contains(input,validLetters)) {
			return true;
		}else{
			return false;
		}
	}
	
	public void zeichneSpiel() {/* zeichnet den aktuellen Spielstand*/
		System.out.println("\n");
		switch (fehlerAnzahl) {
		case 0: break;
		case 1: System.out.println(" _____");
				System.out.println("/     \\");
				break;
		case 2: System.out.println("   |");
				System.out.println("   |");
				System.out.println("   |");
				System.out.println(" __|__");
				System.out.println("/     \\");
				break;
		case 3: System.out.println("   |´");
				System.out.println("   |");
				System.out.println("   |");
				System.out.println(" __|__");
				System.out.println("/     \\");
				break;
		case 4: System.out.println("   _____");
				System.out.println("   |´");
				System.out.println("   |");
				System.out.println("   |");
				System.out.println(" __|__");
				System.out.println("/     \\");
				break;
		case 5: System.out.println("   _____");
				System.out.println("   |´   `");
				System.out.println("   |");
				System.out.println("   |");
				System.out.println(" __|__");
				System.out.println("/     \\");
				break;
		case 6: System.out.println("   _____");
				System.out.println("   |´   ò");
				System.out.println("   |");
				System.out.println("   |");
				System.out.println(" __|__");
				System.out.println("/     \\");
				break;
		case 7: System.out.println("   _____");
				System.out.println("   |´   ò");
				System.out.println("   |    O");
				System.out.println("   |");
				System.out.println(" __|__");
				System.out.println("/     \\");
				break;
		case 8: System.out.println("   _____");
				System.out.println("   |´   ò");
				System.out.println("   |   /O");
				System.out.println("   |");
				System.out.println(" __|__");
				System.out.println("/     \\");
				break;
		case 9: System.out.println("   _____");
				System.out.println("   |´   ò");
				System.out.println("   |   /O\\");
				System.out.println("   |");
				System.out.println(" __|__");
				System.out.println("/     \\");
				break;
		case 10: System.out.println("   _____");
				System.out.println("   |´    ò");
				System.out.println("   |    /O\\");
				System.out.println("   |    /");
				System.out.println(" __|__");
				System.out.println("/     \\");
				break;
		case 11: System.out.println("   _____");
				System.out.println("   |´    ò");
				System.out.println("   |    /O\\");
				System.out.println("   |    / \\");
				System.out.println(" __|__");
				System.out.println("/     \\");
				break;
		}
		System.out.println();
		for(int j =0; j<wortArr.length; j++) {
			System.out.print(wortArr[j] + " ");
		}System.out.println();
		System.out.println();
		System.out.print("Schonmal geratene Buschstaben: ");
		System.out.println(schonVersucht);
		System.out.println("\n");
	}
	public boolean getStatus(){
		if(fehlerAnzahl >= 11) { // wurden mehr als 11 Fehler gemacht gilt das Spiel verloren
			verloren = true;
		}
		gewonnen = true;
		for (int i = 0;i < gesWort.length();i++) {
			/*Wenn alle Buchstaben erraten wurden ist das spiel gewonnen.
			 * Dies wird über eine for-Schleife geprüft die alle erratenen Buchstaben mit dem gesuchten wort abgleicht
			 * wenn ein Buchstabe fehlt wird die gewonnen Variable wieder auf falsch gesetzt*/
			if(wortArr[i] != gesWort.charAt(i)) {
				gewonnen = false;
				break;
			}
		}
		/*sofern das Spiel noch nicht gewonnen oder verloren wurde wird der Status true ausgegeben
		 * das spiel läuft also noch weiter*/
		if (gewonnen == false && verloren == false) {
			return true;								
		}else if(gewonnen == true) { //wenn das Spiel gewonnen wurde wird eine Siegernachricht ausgegeben und der Spielstatus auf falsch gesetzt
			System.out.println("Hurra du hast das Spiel gewonnen!!!!");
			return false;
		}else{
			/*wenn das Spiel verloren wurde wird eine Trostnachricht ausgegeben und der Spielstatus auf falsch gesetzt
			 *trifft keine der vorigen abfragen zu gilt das spiel als verloren dies ist notwendig da java bedingte returns nicht anerkennt
			 *und immer ein default das in jedem fall ausgelöst werden kann braucht*/
			System.out.println("Leider hast du dieses Spiel verloren. Vielleicht klappt es ja beim nächsten Mal.");
			System.out.println("Das zu erratende Wort war übrigens " + gesWort + ".");
			return false;
		}
	}
	public static boolean prüfeEingabe(String Wort){ //Überprüft ein Wort ob es mindestens 2 Buchstaben hat und alle buchstaben akzeptiert sind. Diese Überprüfung muss extern durchgeführt werden.
		boolean wert = true;
		for(int i=0; i<Wort.length(); i++) {
			if(!validateInput(Wort.charAt(i))){
				wert = false;
				break;
			}
		}
		if(Wort.length() < 2) {
			wert = false;
		}
		return wert;
	}
}

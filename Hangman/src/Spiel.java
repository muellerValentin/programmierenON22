import java.util.ArrayList;

public class Spiel {

	private String gesWort;
	private int fehlerAnzahl = 0;
	private char[] wortArr;
	private ArrayList <Character> schonVersucht = new ArrayList<Character>();
	private boolean gewonnen = false;
	private boolean verloren = false;
	private static final String validLetters = "abcdefghijklmnopqrstuvwxyzöäüß";
	
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
	
	private boolean contains(char in, String pruefWert) { /*ueberprueft ob das gesuchte Wort den Buschstabe enthält*/
		for(int i =0; i<pruefWert.length(); i++) {
			if(in == pruefWert.charAt(i)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean validateInput(char input) { /*ueberprueft die ob die Eingabe im Deffinierten Wertebereich liegt*/
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
}

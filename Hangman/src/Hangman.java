import java.util.Scanner;
import java.util.Random;

public class Hangman {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int spielmodus = 0;
		String input = "";
		// Vorgegebene Wörter für Spielmodus 1
		String[] woerter = {"Christbaumkugel", "Weihnachten", "Rentierschlitten", "Glühwein", "Heiligabend"};
		
		
		/////////////////////////////////////////////////////////
		///////////////// Abfrage Spielmodus ////////////////////
		/////////////////////////////////////////////////////////
		
		// Abfrage: Welcher Spielmodus soll gestartet werden?
		// Spielmodus 1: Gegen den Computer (mit vorgegebenen Wörtern).
		// Spielmodus 2: Wort wird selbst eingegeben und dann gespielt.
		while(!input.equals("exit")) {
		
		System.out.println("Das Spiel Hangman wurde gestartet! \n"
				+ "\n"
				+ "Spielmodus 1: Spiele gegen den Computer \n"
				+ "Spielmodus 2: Gib ein eigenes Wort ein (Multiplayer) \n"
				+ "\n"
				+ "Wähle den Spielmodus aus: Tippe 1 oder 2\n"
				+ "Tippe 3 um das Spiel zu beenden\n");
		
		spielmodus = scan.nextInt();
		String xx = scan.nextLine();		// Wird benötigt, damit keine Fehlermeldung kommt
		
		switch(spielmodus) {
			case 1 -> {
				/////////////////////////////////////////////////////////
				//////////////////// Spielmodus 1 ///////////////////////
				/////////////////////////////////////////////////////////
				
				System.out.println("Es wurde Spielmodus 1 gewählt.");
				// Zufällige Zahl für die Wortauswahl
				int min = 0;
				int max = woerter.length;
				
				Random random = new Random();
				
				int randomNumber = random.nextInt(max + min);
				System.out.println(randomNumber);
				
				System.out.println(woerter[randomNumber]);
				
				// Die Variable input wird auf das zufällig gewählte Wort gesetzt
				input = woerter[randomNumber];
			}
			case 2 -> {
				/////////////////////////////////////////////////////////
				//////////////////// Spielmodus 2 ///////////////////////
				/////////////////////////////////////////////////////////
				
				System.out.println("Es wurde Spielmodus 2 gewählt.\n \n");
				
				System.out.println("Gib ein zu erratendes Wort ein:");
				// Die Variable input wird auf das eingegebene Wort gesetzt
				input = scan.nextLine();
			}
			case 3 ->System.out.println("Das Spiel wird beendet.");
			default -> System.out.println("Falsche Eingabe!");
		}
		if(spielmodus == 3) {
			break;
		}
		Spiel gg = new Spiel(input);
		
		char inChar;
		input = "Start";
		
		for(int i=0; i<60;i++) {
	        System.out.println();
		}
		System.out.println("Wenn du das Laufende Spiel beenden möchtest,\n kannst du exit eingeben.");
		while(gg.getStatus()&&(!input.equals("exit"))) {
			System.out.print("Ein Buchstabe bitte: ");
			input = scan.nextLine();
			for(int i=0; i<30;i++) {
		        System.out.println();
			}
			inChar = input.charAt(0);
			gg.verglChar(inChar);
			gg.zeichneSpiel();
		}
	}
		System.out.println("Das Programm wurde beendet");
		scan.close();
	}

}

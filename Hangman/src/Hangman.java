import java.util.Scanner;
import java.util.Random;

public class Hangman {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		/////////////////////////////////////////////////////////
		///////////////// Abfrage Spielmodus ////////////////////
		/////////////////////////////////////////////////////////
		
		// Abfrage: Welcher Spielmodus soll gestartet werden?
		// Spielmodus 1: Gegen den Computer (mit vorgegebenen Wörtern).
		// Spielmodus 2: Wort wird selbst eingegeben und dann gespielt.
		
		System.out.println("Das Spiel Hangman wurde gestartet! \n"
				+ "\n"
				+ "Spielmodus 1: Spiele gegen den Computer \n"
				+ "Spielmodus 2: Gib ein eigenes Wort ein (Multiplayer) \n"
				+ "\n"
				+ "Wähle den Spielmodus aus: Tippe 1 oder 2");
		
		int spielmodus = scan.nextInt();
		String xx = scan.nextLine();		// Wird benötigt, damit keine Fehlermeldung kommt
		String input = "";
		
		switch(spielmodus) {
			case 1 -> {
				/////////////////////////////////////////////////////////
				//////////////////// Spielmodus 1 ///////////////////////
				/////////////////////////////////////////////////////////
				
				System.out.println("Es wurde Spielmodus 1 gewählt.");
			
				// Vorgegebene Wörter für Spielmodus 1
				String[] woerter = {"Christbaumkugel", "Weihnachten", "Rentierschlitten", "Glühwein", "Heiligabend"};
				
				// Zufällige Zahl für die Wortauswahl
				int min = 0;
				int max = 4;
				
				Random random = new Random();
				
				int randomNumber = random.nextInt(max + min) + min;
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
			default -> System.out.println("Falsche Eingabe!");
		}
	
		Spiel gg = new Spiel(input);
		
		char inChar;
		input = "Start";
		
		for(int i=0; i<60;i++) {
	        System.out.println();
		}
		while(!input.equals("exit")) {
			System.out.print("Ein Buchstabe bitte: ");
			input = scan.nextLine();
			for(int i=0; i<30;i++) {
		        System.out.println();
			}
			inChar = input.charAt(0);
			gg.verglChar(inChar);
			gg.zeichneSpiel();
		}
		System.out.println("Du hast das Programm beendet");
		scan.close();
	}

}

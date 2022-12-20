import java.util.Scanner;
import java.util.Random;

public class Hangman {

	public static void main(String[] args) {
		
		// Initialisierung & Deklaration der benötigten Variablen
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
		// Spielmodus 3: Das Spiel wird beendet.
		
		// Spielabbruch bei der Eingabe "exit"
		while(!input.equals("exit")) {
		
			// Erste Textausgabe beim Starten des Spiels
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
				// Berechnung einer zufälligen Zahl für die Wortauswahl
				int min = 0;
				int max = woerter.length;
				
				Random random = new Random();
				
				int randomNumber = random.nextInt(max + min);
				
				// Ausgabe der zufälligen Zahl 
				// System.out.println(randomNumber);
				
				// Ausgabe des zufällig gewählten Wortes aus dem Array.
				System.out.println(woerter[randomNumber]);
				
				// Die Variable input wird auf das zufällig gewählte Wort gesetzt
				input = woerter[randomNumber];
			}
			case 2 -> {
				/////////////////////////////////////////////////////////
				//////////////////// Spielmodus 2 ///////////////////////
				/////////////////////////////////////////////////////////
				
				System.out.println("Es wurde Spielmodus 2 gewählt.\n \n");
				while(!input.equals("exit")) {
				System.out.println("Gib ein zu erratendes Wort ein:");
				
				// Die Variable input wird auf das eingegebene Wort gesetzt
				input = scan.nextLine();
				boolean wert = Spiel.prüfeEingabe(input);
				if (wert == false) 
					System.out.println("Das Wort sollte mindesten 2 Zeichen und kein Sonderzeichen beinhalten. Bitte erneut eingeben!");
				else break;
				}		
				
			}
			case 3 -> {
				/////////////////////////////////////////////////////////
				//////////////////// Spielmodus 3 ///////////////////////
				/////////////////////////////////////////////////////////
				System.out.println("Das Spiel wird beendet.");
			}
			default -> System.out.println("Falsche Eingabe!");
		}
		
		// Das Spiel wird im Spielmodus 3 beendet
		if(spielmodus == 3) {
			break;
		}
		
		// Ein neues Objekt der Klasse Spiel wird geschaffen, an dieses wird die Variable "input" übergeben.
		// "input" ist ein zufälliges Wort aus dem Array (Spielmodus 1) oder ein eingegebenes Wort (Spielmodus 2).
		Spiel gg = new Spiel(input);
		
		char inChar;
		
		// Input wird auf "" gesetzt, falls bei Spielmodus 2 das zu erratende Wort "exit" war. Ansonsten würde das Spiel in der nächsten while-Schleife abgebrochen werden.
		input = "";
		
		// In der Console werden 60 leere Zeilen ausgegeben, damit die Console "leer" angezeigt wird. Die alten Inhalte werden einfach nach oben geschoben.
		for(int i=0; i<60;i++) {
	        System.out.println();
		}
		System.out.println("Wenn du das Spiel beenden möchtest,\n kannst du exit eingeben.");
		while(gg.getStatus()&&(!input.equals("exit"))) {
			System.out.print("Ein Buchstabe bitte: ");
			input = scan.nextLine();
			for(int i=0; i<30;i++) {
		        System.out.println();
			}
			if(input.length() >0) { //wird nur ausgeführt wenn eine die eingabe mindestens ein Zeichen enthält
				inChar = input.charAt(0);
				gg.verglChar(inChar);
			}
			gg.zeichneSpiel();
		}
	}
		System.out.println("Das Programm wurde beendet");
		scan.close();
	}

}
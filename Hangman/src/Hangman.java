import java.util.Scanner;

public class Hangman {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		// Abfrage: Welcher Spielmodus soll gestartet werden?
		// Spielmodus 1: Gegen den Computer (mit vorgegebenen Wörtern).
		// Spielmodus 2: Wort wird selbst eingegeben und dann gespielt.
		
		System.out.println("Das Spiel Hangman wurde gestartet! \n"
				+ "Spielmodus 1: Spiele gegen den Computer \n"
				+ "Spielmodus 2: Gib ein eigenes Wort ein (Multiplayer) \n"
				+ "\n"
				+ "Wähle den Spielmodus aus: Tippe 1 oder 2");
		
		int spielmodus = scan.nextInt();
		
		switch(spielmodus) {
			case 1 -> System.out.println("Es wurde Spielmodus 1 gewählt.");
			case 2 -> System.out.println("Es wurde Spielmodus 2 gewählt.");
			default -> System.out.println("Falsche Eingabe!");
		}
		
		
		System.out.println("Wort vorschlag eingeben");
		String input = scan.nextLine();
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

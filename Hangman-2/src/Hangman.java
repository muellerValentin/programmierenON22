import java.util.Scanner;

public class Hangman {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
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
import java.util.Scanner;

public class DrawHangman {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int a=0;
		while (a<13) {
			System.out.println("get new number:");
		a = scanner.nextInt();
		switch (a) {
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
	}
		scanner.close();
	}
}

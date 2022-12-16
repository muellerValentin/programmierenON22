import java.util.Random;

public class Spielmodus1 {
	String[] woerter = {"Christbaumkugel", "Weihnachten", "Rentierschlitten", "Glühwein", "Heiligabend"};
	
	int min = 0;
	int max = 4;

	Random random = new Random();

	int randomNumber = random.nextInt(max + min) + min;
	System.out.println(randomNumber);
	
	//for(i = random, )
}

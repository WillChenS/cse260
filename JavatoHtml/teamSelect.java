import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;
public class TeamSelection {

	public static void teamSelect() {
		
		boolean blah = true; char c = 'l';
		/*try {
			Scanner = new Scanner(new File("in2.txt"));
			String testCases = s.nextLine();
			String jerseyNumbers = s.nextLine();
			String heights = s.nextLine();*/
			//take in all inputs as strings.
			
			int tests = (int)(testCases.charAt(0)-48);
			String [] jerseys = jerseyNumbers.split("\\s");
			String [] height = heights.split("\\s");
			LinkedList<String> removed = new LinkedList<>();
			//convert inputs to String arrays
			
			for(int k = 0; k < tests; k++) {
				for(int i = 0; i < jerseys.length-1; i++) {
					for (int j = i+1; j < jerseys.length; j++) {
						if(height[i].compareTo(height[j])<0) {
							removed.add(jerseys[i]);
							break;
						}
					}
				}
			}
			//compare and remove players.
			for(String player:jerseys) {
				if(!removed.contains(player)) System.out.print(player + " ");
			}
			s.close();
			
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found.");
		}
	}
	
	public static void main (String[]args) {
		teamSelect();
	}
}

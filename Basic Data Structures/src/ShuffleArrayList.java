import java.util.ArrayList;
import java.util.Arrays;

public class ShuffleArrayList {

	public static <E> void shuffle(ArrayList<E> list) {
		for(int i = list.size()-1; i>0; i--) {
			randomSwap(list,i);
		}
		randomSwap(list,0);
	}
	
	private static <E> void randomSwap(ArrayList<E> list, int i) {
		int swapIndex = (int)(Math.random()*(i));
		E temp = list.get(i);
		list.set(i, list.get(swapIndex));
		list.set(swapIndex, temp);
	}
	
	public static void main (String[]args) {
		ArrayList<String> test = new ArrayList<String>(Arrays.asList("1", "2", "3", "4"));
		shuffle(test);
		for(String s:test) {
			System.out.println(s);
		}
	}
	
}

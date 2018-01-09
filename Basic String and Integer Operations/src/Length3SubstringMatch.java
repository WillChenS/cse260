/*
 * Finds the number of length 3 substrings common to two strings.
 */
public class Length3SubstringMatch {
	
	/*
	 * Returns the number of length 3 substrings common to two strings.
	 * @param a the first string.
	 * @param b the second string.
	 * @return the number of common triples.
	 * 
	 */
	public static int stringMatch3(String a, String b) {
		String firstGroupThree = "";
		String secondGroupThree = "";
		int matchCount = 0;
		for(int index = 0; index < a.length()-2; index++) {
			firstGroupThree = a.substring(index, index+3);
			secondGroupThree = b.substring(index, index+3);
			if (firstGroupThree.equals(secondGroupThree)) matchCount++;
			/*for (int bIndex = 0; bIndex < b.length()-3; bIndex++) {
				secondGroupThree = b.substring(bIndex, bIndex+3);
				if (firstGroupThree.equals(secondGroupThree)) matchCount++;
			}*/
			//Commented code ignores order.
		}
		return matchCount;
		
	}
	
}

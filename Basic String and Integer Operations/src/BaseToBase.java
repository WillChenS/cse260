/*
 * A class to convert between bases.
 */
public class BaseToBase {
	
	/*
	 * Converts from one base to another.
	 * @param n the string containing the number to be converted.
	 * @param b1 the base to convert from.
	 * @param b2 the base to convert to.
	 * @return the number in the desired base.
	 */
	public static String base2base(String n, int b1, int b2) {
		int base10 = toBase10(n, b1);
		if (base10 == -1) return "Invalid input";
		String result = fromBase10(base10, b2);
		return result;
	}
	
	private static int toBase10(String n, int b1) {
		int power = 0;
		int base10Total = 0;
		for (int index = n.length()-1; index >= 0; index--) {
			int digit = (int)(n.charAt(index));
			if(digit>=48 && digit<=57) digit -= 48;
			else if (digit>= 65 && digit<=90) digit -= 55;
			else return -1;
			base10Total += (Math.pow(b1, power)*digit);
			power++;
		}
		return base10Total;
	}
	
	private static String fromBase10(int base10, int b2) {
		String result = "";
		int divisor = base10;
		int remainder = 0;
		while(divisor != 0) {
			remainder = divisor%b2;
			if (remainder > 9) result = (char)(remainder+55) + result;
			else result = remainder+result;
			divisor /= b2;
		}
		return result;
	}
	
}

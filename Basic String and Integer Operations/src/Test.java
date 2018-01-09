/*
 * Test method.
 * William Chen, 9.12.2017
 * 
 */
public class Test {

	public static void main (String[]args) {
		
		System.out.println(Length3SubstringMatch.stringMatch3("sdgndsgyudsaiufb","sadufygyudsafbnsaicgaf"));
		System.out.println(Length3SubstringMatch.stringMatch3("banana","bananas"));
		System.out.println(BaseToBase.base2base("12345", 6, 8));
		System.out.println(BaseToBase.base2base("STONY", 36, 19));
		System.out.println(BaseToBase.base2base("832K1", 26, 15));
		
		System.out.println(RunLengthEncoding.encode("XYZAAAAAAGGTCCCCCCTTTAAAAAAAAAAAAAAKK", '*'));
		System.out.println("XYZ*A6GGT*C6TTT*A14KK");
		System.out.println(RunLengthEncoding.encode("KKKKKKKKKKKKKBCCDDDDDDDDDDDDDDDKKKKKMNUUUGGGGG", '$'));
		
		System.out.println(GreekMoney.howManyOboloi(2, 32, 59, 3));
	}
	
}

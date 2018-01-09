
public class Complex extends Number implements Comparable<Complex>{

	private double rational = 0;
	private double irrational = 0;
	
	public Complex(double rational, double irrational) {
		this.rational = rational;
		this.irrational = irrational;
	}
	
	public Complex add(Complex secondComplex) {
		double a = rational+secondComplex.rational;
		double b = irrational+secondComplex.irrational;
		return new Complex(a,b);
	}
	
	public Complex multiply(Complex secondComplex) {
		//(a + bi)(c + di) = (ac - bd)(ad + bc)
	}
	
	@Override
	public String toString() {
		return (rational + " + " + irrational + "i");
	}
}

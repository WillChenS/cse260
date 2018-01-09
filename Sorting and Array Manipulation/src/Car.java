public class Car {

	//should have made a super class that car and repairTicket implements.
	
	private String vin;
	private String make;
	private int year;
	
	public Car(String vin, String make, int year) {
		this.vin = vin;
		this.make = make;
		this.year = year;
	}
	
	public String getVIN() {
		return vin;
	}
	
	public String getMake() {
		return make;
	}
	
}


public class RepairTicket {
	private String vin;
	private double cost;
	private String description;
	private int ticketNo;
	private String make;
	
	public RepairTicket(String vin, double cost, String description, int ticketNo, String make) {
		this.vin = vin;
		this.cost = cost;
		this.description = description;
		this.ticketNo = ticketNo;
		this.make = make;
	}
	
	public double getCost() {
		return cost;
	}
	
	public String getVIN() {
		return vin;
	}
	
	public int getTicketNo() {
		return ticketNo;
	}
	
	public String getMake() {
		return make;
	}
	
	public void setCost(double cost) {
		this.cost = cost;
	}
	
}

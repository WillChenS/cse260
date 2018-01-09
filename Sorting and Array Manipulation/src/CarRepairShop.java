public class CarRepairShop {	
	
	private Car[]cars;
	private RepairTicket[]tickets;
	private String[]makes;
	private int ticketCounter;
	private int carCounter;
	
	public CarRepairShop() {
		cars = new Car[0];
		tickets = new RepairTicket[0];
		makes = new String[0];
		ticketCounter = 0;
		carCounter = 0;
	}
			
	public int addNewCar(String vin, String make, int year) {
		
		for(int i = 0; i<cars.length; i++) {
			if(cars[i].getVIN().equals(vin)) return -1;
		}
		Car[] newCars = new Car[cars.length+1];
		for(int i = 0; i<cars.length; i++) {
			newCars[i]=cars[i];
		}
		cars = newCars;
		cars[cars.length-1] = new Car(vin,make,year);
		
		
		String[] newMakes = new String[makes.length+1];
		for(int i = 0; i<makes.length; i++) {
			newMakes[i]=makes[i];
		}
		makes = newMakes;
		makes[makes.length-1] = make;
		
		carCounter++;
		return carCounter;
	}
	
	public int addRepairTicket(String vin, double cost, String description) {
		String badMake = "";
		boolean match = false;
		for(Car car:cars) {
			if(vin.equals(car.getVIN())) {
				match = true;
				badMake = car.getMake();
			}
		}
		if(!match) return -1;
		RepairTicket[] newTickets = new RepairTicket[tickets.length+1];
		for(int i = 0; i<tickets.length; i++) {
			newTickets[i]=tickets[i];
		}
		tickets = newTickets;
		ticketCounter++;
		tickets[tickets.length-1] = new RepairTicket(vin, cost, description, ticketCounter, badMake);
		return ticketCounter;
	}
	
	public double getRepairCost(int ticketNum) {
		for(RepairTicket t:tickets) {
			if(t.getTicketNo() == ticketNum) return t.getCost();
		}
		return -1.0;
	}
	
	public double getTotalRepairCosts(String vin) {
		double cost = 0;
		double vinCount = 0;
		for(RepairTicket tick:tickets) {
			if(tick.getVIN().equals(vin)) cost += tick.getCost();
			vinCount++;
		}
		if(vinCount == 0) return -1.0;
		return cost;
	}

	public String getWorstCarMake() {
		if (cars.length == 0) return null;
		int repairCount = 0;
		String worstMake = "";
		for(String make:makes) {
			int tempCount = 0;
			for(RepairTicket tick:tickets) {
				if (tick.getMake().equals(make)) tempCount++;
			}
			if (tempCount > repairCount) {
				repairCount = tempCount;
				worstMake = make;
			}
		}
		return worstMake;
	}
	
	public boolean updateRepairCost(int ticketNum, double newCost) {
		boolean match = false;
		for(RepairTicket tick:tickets) {
			if (ticketNum == tick.getTicketNo()) {
				tick.setCost(newCost);
				match = true;
			}
		}
		return match;
	}
	
	public boolean deleteRepair(int ticketNum) {
		int tickIndex = 0;
		for(RepairTicket tick:tickets) {
			if (ticketNum == tick.getTicketNo()) {
				RepairTicket[] newTickets = new RepairTicket[tickets.length-1];
				for(RepairTicket ticket:tickets) {
					if (ticket != tick) {
						newTickets[tickIndex] = ticket;
						tickIndex++;
					}
				}
				tickets = newTickets;
				return true;
			}
		}
		return false;
	}
	
	public boolean deleteAllRepairsForCar(String VIN) {
		boolean match = true;
		for(RepairTicket tic:tickets) {
			if (tic.getVIN().equals(VIN)) match = deleteRepair(tic.getTicketNo());
		}
		return match;
	}
	
	public boolean deleteCarAndRepairs(String VIN) {
		deleteAllRepairsForCar(VIN);
		int carIndex = 0;
		for (Car car:cars) {
			if(car.getVIN().equals(VIN)) {
				Car[] newCars = new Car[cars.length-1];
				for(Car oldCar:cars) {
					if (oldCar != car) {
						newCars[carIndex] = oldCar;
						carIndex++;
					}
				}
				cars = newCars;
				return true;
			}
		}
		return false;
	}
}
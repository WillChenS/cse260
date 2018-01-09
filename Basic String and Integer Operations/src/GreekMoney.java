/*
 * Keeps track of and calculates conversion factors between Greek currency. 
 */
public class GreekMoney {
	
//1 talent = 60 minae
//1 mina = 70 drachmae
//1 drachma = 6 oboloi

	/*
	 * Calculates oboloi value given any number of Greek currency.
	 * @param talents number of talents
	 * @param minae number of minae
	 * @param drachmae number of drachmae
	 * @param oboloi number of oboloi
	 * @return oboloi value of currency
	 * 
	 */
	public static int howManyOboloi(int talents, int minae, int drachmae, int oboloi) {
		int total = 0;
		total += oboloi;
		total += drachmaeToOboloi(drachmae);
		total += drachmaeToOboloi(minaToDrachmae(minae));
		total += drachmaeToOboloi(minaToDrachmae(talentToMinae(talents)));
		return total;
	}
	
	private static int drachmaeToOboloi(int drachmae) {
		return drachmae*6;
	}
	
	private static int minaToDrachmae(int minae) {
		return 70*minae;
	}
	
	private static int talentToMinae(int talents) {
		return 60*talents;
	}
	
}

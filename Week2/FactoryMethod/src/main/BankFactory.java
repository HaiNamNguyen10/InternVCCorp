package main;

public class BankFactory {
	private BankFactory() {
		
	}	
	public static final Bank getBank(BankType bank) {
		switch(bank) {
		
		case BIDV: 
			return new Bidv();
		case VIETCOMBANK:
			return new Vietcombank();
		default:
			System.out.println("This bank is not supported");
			return null;
		}
	}
}

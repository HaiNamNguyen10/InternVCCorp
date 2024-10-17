package main;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bank bank = BankFactory.getBank(BankType.BIDV);
		System.out.println(bank.getName());
	}

}

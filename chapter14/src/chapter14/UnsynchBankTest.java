package chapter14;


class Bank
{
	private final double[] accounts;
	
	public Bank(int n, double initalBalance) {
		accounts = new double[n];
		for(int i=0; i<n; i++) {
			accounts[i] = initalBalance;
		}
	}
	
	private double getTotalBalance() {
		double sum = 0;
		for(double each: accounts)
			sum += each;
		return sum;
	}
	
	public void transfer(int from, int to, double account) {
		if(account < accounts[from])
			return;
		System.out.print(Thread.currentThread());
		accounts[from] -= account;
		System.out.printf("%10.2f from %d to %d\n", account, from, to);
		accounts[to] += account;
		System.out.printf("TotalBalanc: %10.2f%\n", this.getTotalBalance());
	} 
	public int getAccoutsSize() {
		return accounts.length;
	}
}

class TransferRunable implements Runnable{
	private Bank bank;
	private int fromAccount;
	private double maxAccount;
	private int DELAY = 10;
	
	
	public TransferRunable(Bank b, int from, double max) {
		bank = b;
		fromAccount = from;
		maxAccount = max;
	}

	public void run() {
		try {
			while (true) {
				int toAccount = (int)(bank.getAccoutsSize() * Math.random());
				double account = maxAccount * Math.random();
				bank.transfer(fromAccount, toAccount, account);
				Thread.sleep((int)(DELAY * Math.random())); 	
			}
		}
		catch (InterruptedException e) {
			// TODO: handle exception
		}
	}
}

public class UnsynchBankTest {
	public static void main(String[] args) {
		System.out.print("begin.....");
		Bank bank = new Bank(NACCOUNT, INITIALBALANCE);
		for(int i = 0; i < NACCOUNT; i++) {
			TransferRunable runable = new TransferRunable(bank, i, INITIALBALANCE);
			Thread thread = new Thread(runable);
			thread.start();
		}
	}
	public static final int NACCOUNT = 100;
	public static final double INITIALBALANCE = 1000;
}

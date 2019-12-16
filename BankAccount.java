
public class BankAccount extends User {
	private double balance;
	private String user;
	private String pswrd;

	public BankAccount(String name, String address, String email, String occupation, String user, String pswrd, double balance) {
		super(name,address,email,occupation);
		this.user = user;
		this.pswrd = pswrd;
		this.balance = balance;
	}
	
	public BankAccount(String user, String pswrd) {
		this.user = user;
		this.pswrd = pswrd;
		this.balance = 0;
	}

	public BankAccount(String user, String pswrd, double balance) {
		this.user = user;
		this.pswrd = pswrd;
		this.balance = balance;
	}

	public void deposit(double amount) {
		if (amount > 0)
			balance += amount;
		else
			System.out.println("Invalid deposit");
	}

	public void withdraw(double amount) {
		if (amount > balance)
			System.out.println("\nSorry you have insufficient funds at this moment");
		else if (amount > 0)
			balance -= amount;
		else
			System.out.println("Invalid deposit. Please enter a valid deposit amount ");
	}

	public double getBalance() {
		return balance;
	}

	public String getuser() {
		return user;
	}
	
	public boolean authenticate(String password){
		return this.pswrd.equals(password);
	}

}

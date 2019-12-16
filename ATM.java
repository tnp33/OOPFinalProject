import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ATM {

	public static ArrayList <BankAccount> accounts;
	public static BankAccount current;
	
	public static void main(String[] args) {
		setup();
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter your user name:");
		String user = sc.next();
		System.out.println("Enter your user password:");
		String password = sc.next();
		
		int tries = 3;
		while(!authenticate(user, password) && tries>0){
			System.out.println("Incorrect credentials try again, retries left: "+tries);
			System.out.println("Enter your user name:");
			user = sc.next();
			System.out.println("Enter your user password:");
			password = sc.next();
			tries --;
		}
		
		if(current == null){
			System.out.println("Unfortunately, you have reached the maximum number of tries");
			System.exit(-1);
		}
		
		System.out.println();
		System.out.println("~~~ Welcome to Schmeding Bank, "+current.name+ " ~~~");
		
		boolean stop = false;
		while(!stop){
			 System.out.print("\nPlease Choose From the Following Options:"
	                    + "\n 1. Balance \n 2. Deposit"
	                    + "\n 3. Withdraw\n 4. Log Out\n\n");
			 
			 int menuOption = sc.nextInt();
			 
			 while(menuOption<1 || menuOption>4){
				 System.out.println("Invalid entry try again.");
			 }
			 
			 switch (menuOption)
	            {
	            case 1:
	            	System.out.println("Your current balance is: "+current.getBalance());
	                break;
	            case 2:
	                System.out.print("\nPlease enter Amount to Deposit: $ ");
	                double depositAmt = sc.nextDouble();
	                current.deposit(depositAmt);
	                System.out.println("Your current balance is: "+current.getBalance());
	                break;
	            case 3:
	                System.out.print("\nPlease enter Amount to Withdrawl: $ ");
	                double withdrawAmt = sc.nextDouble();
	                current.withdraw(withdrawAmt);
	                System.out.println("\nYour current balance is: "+current.getBalance());
	                break;
	            case 4:
	                System.out.print("\n Thank you for choosing Schmeding Bank! You may now remove your card!");
	                System.exit(0);
	                break;
	            } 
			
		}

	}
	
	public static boolean authenticate(String user, String password){
		for(BankAccount bc : accounts){
			if(bc.getuser().equals(user)){
				if(bc.authenticate(password)){
					current = bc;
					return true;
				}
			}
		}
		return false;
	}
	
	public static void setup(){
		File file = new File("users.txt"); 
		accounts = new ArrayList <BankAccount>();
		Scanner fr = null;
		try {
			fr = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		} 
			  
		while (fr.hasNextLine()){ 
			String line = fr.nextLine();
			if(line.equals("--USER--")){
				String name = fr.nextLine();
				String address =fr.nextLine();
				String email =fr.nextLine();
				String occupation = fr.nextLine();
				String user = fr.nextLine();
				String password = fr.nextLine();
				double balance = fr.nextDouble();
				BankAccount bc = new BankAccount(name,address,email,occupation,user,password,balance);
				accounts.add(bc);
			}
		} 
	}

}

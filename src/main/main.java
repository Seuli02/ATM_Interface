package main;

import java.util.Scanner;

import model.User;
import service.ATM;

public class main {
	static int count = 0;
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter User ID: ");
	        String userId = scanner.nextLine();
	        System.out.print("Enter PIN: ");
	        String pin = scanner.nextLine();

	        User user = new User(userId, pin);
	        ATM atm = new ATM(user);
	        
	        if(user.checkUserLogin()) { //Check User Login (I have kept here UserId as "Seuli" && Password as "1234").
	        
	        boolean quit = false;
	        while (!quit) {
	            System.out.println("\n1. Deposit\n2. Withdraw\n3. Transfer\n4. Transaction History\n5. Quit");
	            System.out.print("Choose an option: ");
	            int option = scanner.nextInt();
	            switch (option) {
	                case 1:
	                    System.out.print("Enter amount to deposit: INR ");
	                    double depositAmount = scanner.nextDouble();
	                    atm.deposit(depositAmount);
	                    break;
	                case 2:
	                    System.out.print("Enter amount to withdraw: INR ");
	                    double withdrawAmount = scanner.nextDouble();
	                    atm.withdraw(withdrawAmount);
	                    break;
	                case 3:
	                    System.out.print("Enter amount to transfer: INR ");
	                    double transferAmount = scanner.nextDouble();
	                    System.out.print("Enter recipient's name: ");
	                    String recipient = scanner.next();
	                    atm.transfer(transferAmount, recipient);
	                    break;
	                case 4:
	                    atm.showTransactionHistory();
	                    break;
	                case 5:
	                    quit = true;
	                    System.out.println("Thank you for using Seuli's ATM. Goodbye!");
	                    break;
	                default:
	                    System.out.println("Invalid option. Please choose again.");
	            }
	        }
	        } else {
	        	if(count <= 3) {
	        		count++;
	        	System.out.println("Invalid Credentials. Please Try Again.");
	        	main(null);
	        	}
	        	else {
	        		System.out.println("Maximum Five Attempts has been used. Your Id has been blocked for 24 hours");
	        	}
	        }
	    }
}

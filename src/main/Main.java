package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	private ArrayList<User> users;
	private Scanner sc;
	
	public Main() {
		// ArrayList of User to simulate user database
		users = new ArrayList<>();
		addDummyData();
		
		// Scanner
		sc = new Scanner(System.in);
		
		do {
			System.out.println("Welcome:");
			System.out.println("1. Login");
			System.out.println("2. Register");
			
			System.out.print("\nSelect: ");
			
			switch (sc.nextLine()) {
			case "1":
				if (loginMenu()) {
					System.out.println("User login succesfully\n");
					System.out.println("Welcome user, this is our application\n");
					System.out.println("This our main menu\n");
					mainMenu();
				} else {
					System.out.println("Something Unexpected just happen!");
					System.out.println("Please Try Again later!");
					System.out.println("\nPress enter to continue...");
					
					sc.nextLine();
				}
				break;
				
			case "2":
				if (registerMenu()) {
					System.out.println("User has been succesfully registered!\n");
					System.out.println("Redirecting you to the login page...\n");
				} else {
					System.out.println("Something went wrong!");
					System.out.println("Please try again later!");
					System.out.println("\nPress enter to continue...");
					
					sc.nextLine();
				}
				break;

			default:
				break;
			}
			
		} while (true);
			
	}
	
	// Case "1": Login
	private boolean loginMenu() {
		String email = "", password = "";
		
		System.out.print("Enter your email: ");
		email = sc.nextLine();
		
		System.out.print("Enter your password: ");
		password = sc.nextLine();
		
		Login login = new Login(users, email, password);
		
		return login.isSuccess();
	}
	
	// Case "2": Register
	private boolean registerMenu() {
		String name = "", email = "", password = "";
		
		System.out.print("Enter your name: ");
		name = sc.nextLine();
		
		System.out.print("Enter your email: ");
		email = sc.nextLine();
		
		System.out.print("Enter your password: ");
		password = sc.nextLine();
		
		Register register = new Register(users, name, email, password);
		
		return register.isSuccess();
	}
	
	// Main Menu after user is logged in
	private void mainMenu() {
		System.out.println("Welcome!");
		
		System.out.println("\nPress enter to log out...");
		sc.nextLine();
	}
	
	// ==================================
	
	public static void main(String[] args) {
		new Main();
	}
	
	// ==================================
	
	private void addDummyData() {
		users.add(new User("Endra", "endra@binus.ac.id", "12345"));
		users.add(new User("Fajar", "fajar@binus.ac.id", "abcde"));
	}
	
}

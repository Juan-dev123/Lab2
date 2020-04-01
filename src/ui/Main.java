package ui;
import java.util.Scanner;
import model.Company;

public class Main{
	//Relations
	private Company company;
	private Scanner read;

	//Methods
	public static void main(String args[]){
		Main main=new Main();	
		main.menu();
	}

	Main(){
		read=new Scanner(System.in);
		System.out.println("Enter the name of your company");
		String name=read.nextLine();
		company=new Company(name);
	}
	/**
	 * Name: menu
	 * It prints the menu on the console.
	 */
	public void menu(){
		int option;
		boolean quit=false;
		while(!quit){
			System.out.println("Choose a number:");
			System.out.println("1 Register the clients");
			System.out.println("2 Upload a load to the ship");
			option=read.nextInt();
			read.nextLine();
			switch (option) {
				case 1:
					addClient();
					break;
				case 2:
					addLoad();
					break;
			}
			String answer;
			System.out.print("Do you want to run another app?, yes or not: ");
			answer = read.nextLine();
			while(!((answer.equalsIgnoreCase("not") || answer.equalsIgnoreCase("yes")))){
				System.out.print("There are only two options, yes or not: ");	
				answer = read.nextLine();
			}
			if(answer.equalsIgnoreCase("not")){
				quit = true;
			}
		}
		
	}
	/**
	 * Name: addClient
	 * It registers and adds a client
	 */
	public void addClient(){
		String name;
		int crn;
		String date;
		String typeClient;
		System.out.println("Enter the data of a client");
		System.out.print("Enter the name:");
		name=read.nextLine();
		System.out.print("Enter the Commercial Register Number:");
		crn=read.nextInt();
		read.nextLine();
		System.out.print("Enter the date:"); //Corregir la fecha
		date=read.nextLine();
		System.out.print("Enter the type of client:");
		typeClient=read.nextLine();
		System.out.println(company.registerClient(name, crn, date, typeClient));
	}

	public void addLoad(){
		int option;
		int numBoxes;
		int weightBox;
		int typeLoad;

		System.out.println("Choose the owner of the load");
		printClients();
		option=read.nextInt();
		System.out.println("Enter the number of boxes");
		numBoxes=read.nextInt();
		System.out.println("Enter the weight in grams of a box");
		weightBox=read.nextInt();
		System.out.println("Choose the type of load");
		System.out.println("1 Perishable");
		System.out.println("2 No Perishable");
		System.out.println("3 Dangerous");
		typeLoad=read.nextInt();
		System.out.println(company.addLoad(numBoxes, weightBox, typeLoad, company.getClients()[option]));
		
	}

	public void printClients(){
		for(int i=0; i<company.getClients().length && company.getClients()[i]!=null; i++){
			System.out.printf("%d ", i+1);
			System.out.println(company.getClients()[i].getName());
			System.out.println("  "+company.getClients()[i].getCrn());
		}
	}

}
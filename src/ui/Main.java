package ui;
import java.util.Scanner;
import java.util.GregorianCalendar;

import model.Client;
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
			System.out.println("Choose an option:");
			System.out.println("1 Register a client");
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
		int day;
		int month;
		int year;
		boolean firsTime;
		GregorianCalendar date;
		int typeClient=Client.NORMAL;
		System.out.println("Enter the data of a client");
		System.out.print("Enter the name:");
		name=read.nextLine();
		System.out.print("Enter the Commercial Register Number:");
		crn=read.nextInt();
		read.nextLine();
		System.out.println("Enter the registration issue date"); //Mirar febrero y años bisiestos...
		System.out.print("Enter the day:");
		firsTime=true;
		do{
			if(!firsTime){
				System.out.print("Enter a valid number:");
			}
			day=read.nextInt();
			firsTime=false;
		}while(!(day>=1 && day<=31));
		System.out.println("Choose a month");
		System.out.println("1 January");
		System.out.println("2 February");
		System.out.println("3 March");
		System.out.println("4 April");
		System.out.println("5 May");
		System.out.println("6 June");
		System.out.println("7 July");
		System.out.println("8 August");
		System.out.println("9 September");
		System.out.println("10 October");
		System.out.println("11 November");
		System.out.println("12 December");
		firsTime=true;
		do{
			if(!firsTime){
				System.out.print("Enter a valid number:");
			}
			month=read.nextInt();
			firsTime=false;
		}while(!(month>=1 && month<=12));
		System.out.println("Enter the year:");
		firsTime=true;
		do{
			if(!firsTime){
				System.out.print("Enter a valid number:");
			}
			year=read.nextInt();
			firsTime=false;
		}while(!(year>=1900));
		date=new GregorianCalendar(year, month-1, day);
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
		boolean firsTime=true;
		do{
			if(!firsTime){
				System.out.print("Enter a valid number 1/2/3:");
			}
			typeLoad=read.nextInt();
			firsTime=false;
		}while(!(typeLoad>=1 && typeLoad<=3));
		System.out.println(company.addLoad(numBoxes, weightBox, typeLoad, option-1));
		
	}

	public void printClients(){
		for(int i=0; i<company.getClients().length && company.getClients()[i]!=null; i++){
			System.out.printf("%d ", i+1);
			System.out.println(company.getClients()[i].getName());
			System.out.println("  "+company.getClients()[i].getCrn());
		}
	}

}
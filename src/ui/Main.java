package ui;
import java.util.Scanner;
import java.util.GregorianCalendar;
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
	//A los constructores se les hace contrato?////////////////////////////////////////
	public Main(){
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
			System.out.println("3 Give the total to pay of a client");
			System.out.println("4 Download the ship");
			option=read.nextInt();
			read.nextLine();
			switch (option) {
				case 1:
					addClient();
					break;
				case 2:
					addLoad();	
					break;
				case 3:
					giveTotalPay();
					break;
				case 4:
					downloadShip();
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
		GregorianCalendar date;
		int typeClient=1;
		System.out.println("Enter the data of a client");
		System.out.print("Enter the name:");
		name=read.nextLine();
		System.out.print("Enter the Commercial Register Number:");
		crn=read.nextInt();
		read.nextLine();
		System.out.println("Enter the registration issue date"); 
		date=enterDate();
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

	public void giveTotalPay(){
		System.out.println("Choose the client");
		printClients();
		int option=read.nextInt();
		String name=company.getClients()[option-1].getName();
		int crn=company.getClients()[option-1].getCrn();
		double totalPay=company.getClients()[option-1].getTotalPayLoad();
		System.out.printf("The client %s with the Commercial Register Number: %d should pay until now: %.2f%n", name, crn, totalPay);
		
	}

	public void downloadShip(){
		System.out.println(company.downloadLoad());
	}

	public void printClients(){
		for(int i=0; i<company.getClients().length && company.getClients()[i]!=null; i++){
			System.out.printf("%d ", i+1);
			System.out.println(company.getClients()[i].getName());
			System.out.println("  "+company.getClients()[i].getCrn());
		}
	}

	public GregorianCalendar enterDate(){
		boolean firsTime;
		int day=0;
		int month;
		int year;
		GregorianCalendar date;
		//Enter the month
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
		//Check if the number entered is valid for a month
		firsTime=true;
		do{
			if(!firsTime){
				System.out.print("Enter a valid number for a month (1-12):");
			}
			month=read.nextInt();
			firsTime=false;
		}while(!(month>=1 && month<=12));

		//Enter the year
		System.out.println("Enter the year (major than 1900):");
		//Check if the number entered is valid for a year
		firsTime=true;
		do{
			if(!firsTime){
				System.out.print("Enter a valid number for a year:");
			}
			year=read.nextInt();
			firsTime=false;
		}while(!(year>=1900 && year<=2020));
		firsTime=true;
		//Check if a year is a leap year
		boolean leapYear=leapYear(year);
		System.out.print("Enter the day:");
		//Check if the day entered is valid for the month
		//if the month has 31 days
		if(month==1 || month==3 ||month==5 ||month==7 ||month==8 ||month==10 ||month==12){
			do{
				if(!firsTime){
					System.out.print("Enter a valid number for a day:");
				}
				day=read.nextInt();
				firsTime=false;
			}while(!(day>=1 && day<=31));
		}
		//if the month has 30 days
		if(month==4 || month==6 ||month==9 ||month==11){
			do{
				if(!firsTime){
					System.out.print("Enter a valid number for a day:");
				}
				day=read.nextInt();
				firsTime=false;
			}while(!(day>=1 && day<=30));
		}
		//if the month is february 
		if(month==2){
			//if the year is a leap year
			if(leapYear){
				do{
					if(!firsTime){
						System.out.print("Enter a valid number for a day:");
					}
					day=read.nextInt();
					firsTime=false;
				}while(!(day>=1 && day<=29));
			}else{
				do{
					if(!firsTime){
						System.out.print("Enter a valid number for a day:");
					}
					day=read.nextInt();
					firsTime=false;
				}while(!(day>=1 && day<=28));
			}
		}
		date=new GregorianCalendar(year, month-1, day);
		return date;
	}

	public boolean leapYear(int year){
		boolean leapYear;
		if(year%4==0){
			if(year%100==0){
				if(year%400==0){
					leapYear=true;
				}else{
					leapYear=false;
				}
			}else{
				leapYear=true;
			}
		}else{
			leapYear=false;
		}
		return leapYear;
	}

}
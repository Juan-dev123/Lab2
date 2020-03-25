package ui;
import java.util.Scanner;
import model.Company;

public class Main{
	//Relations
	private Company company;
	//
	public static Scanner read=new Scanner(System.in);

	//Methods
	public static void main(String args[]){
		Scanner read=new Scanner(System.in);
		System.out.println("Enter the name of your company");
		String name=read.nextLine();
		Main main=new Main(name);	
		main.addClient();
		main.company.imprimirCliente(4); //CORREGIRRRRRRRRRRRRRR Y QUITARRRRR

	}

	Main(String name){
		company=new Company(name);
	}

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
		System.out.println(company.addClient(name, crn, date, typeClient));
	}

}
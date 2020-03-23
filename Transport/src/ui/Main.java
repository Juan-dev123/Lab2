import java.util.Scanner;

public class Main{
	public static void main(String args[]){
		String name;
		int weightLoads;
		String typeLoads;
		int quantityLoads;
		Scanner read=new Scanner(System.in);
		System.out.println("Enter the name of the ship");
		name=read.nextLine();
		System.out.println("Enter the weight of the loads");
		weightLoads=read.nextInt();
		read.nextLine();
		System.out.println("Enter the type of Load");
		typeLoads=read.nextLine();
		System.out.println("Enter the quantity of the loads");
		quantityLoads=read.nextInt();
		Ship ship1=new Ship(name, weightLoads, typeLoads, quantityLoads);
		System.out.println(ship1.getWeight());	
	}
}
public class Client{

	private String name;
	private int nrm;
	private String dateRegister;
	private int quantityKilos;
	private int totalPrice;
	private String typeClient;

	public Cliente(String name, int nrm, String dateRegister, int quantityKilos, int totalPrice, String typeClient){
		this.name=name;
		this.nrm=nrm;
		this.dateRegister=dateRegister;
		this.quantityKilos=quantityKilos;
		this.totalPrice=totalPrice;
		this.typeClient=typeClient;
	}
	public static int addPrice(int price){
		totalPrice+=price;
	}
	public static void updateType()
	
}
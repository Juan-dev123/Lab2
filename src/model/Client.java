package model;
import java.util.GregorianCalendar;
public class Client{
    //Constants
    public static final int NORMAL=1;
    public static final int SILVER=2;
    public static final int GOLD=3;
    public static final int PLATINUM=4;
    public static final double DISCOUNT_S=0.015;
    public static final double DISCOUNT_G=0.03;
    public static final double DISCOUNT_P=0.05;

    //Atributes
    private String name;
    private int crn;
    private GregorianCalendar date;
    private double quantityKilosLoad;
    private double totalPayLoad;
    private double totalPay;
    private double totalQuantityKilos;
    private int typeClient;

    //Methods
    /**
     * It initializes the atributes of a client.
     * @param name The name.
     * @param crn The Commercial Register Number of the client.
     * @param date The registration issue date.
     * @param typeClient The category of the client. typeClient>=1 &amp;&amp; typeClient<=4.
     */
    public Client(String name, int crn, GregorianCalendar date, int typeClient){
        this.name=name;
        this.crn=crn;
        this.date=date;
        this.typeClient=typeClient;
    }

    /**
     * It adds kilos to the client.
     * @param quantityKilos The quantity of kilos.
     */
    public void updateKilos(double quantityKilos){
        this.quantityKilosLoad+=quantityKilos;
        this.totalQuantityKilos+=quantityKilos; 
        
    }

    /**
     * It adds money to pay to the client.
     * @param pay The money to pay.
     */
    public void updatePayment(double pay){
        totalPayLoad+=pay;
        totalPay+=pay;
    }

    //---------------------------------------------------------------
    //getters
    /**
     * @return The name.
     */
    public String getName() {
        return name;
    }
    /**
     * @return The Commercial Register Number.
     */
    public int getCrn() {
        return crn;
    }
    /**
     * @return The registration issue date.
     */
    public GregorianCalendar getDate() {
        return date;
    }
    /**
     * @return The quantity of kilos in the current journey.
     */
    public double getQuantityKilosLoad() {
        return quantityKilosLoad;
    }
    /**
     * @return What the client should pay for the loads of the current journey.
     */
    public double getTotalPayLoad() {
        return totalPayLoad;
    }
    /**
     * @return All what the client has paid.
     */
    public double getTotalPay() {
        return totalPay;
    }
    /**
     * @return The total quantity of kilos of a client has transported.
     */
    public double getTotalQuantityKilos() {
        return totalQuantityKilos;
    }
    /**
     * @return The type of client.
     */
    public int getTypeClient() {
        return typeClient;
    }

    
   

    //---------------------------------------------------------------
    //setters
    /**
     * @param name The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @param crn The Commercial Register Number to set. crn>=0.
     */
    public void setCrn(int crn) {
        this.crn = crn;
    }
    /**
     * @param date The registration issue date to set.
     */
    public void setDate(GregorianCalendar date) {
        this.date = date;
    }
    /**
     * @param quantityKilosLoad The quantity of kilos in the current journey to set. quantityKilosLoad>=0.
     */
    public void setQuantityKilosLoad(double quantityKilosLoad) {
        this.quantityKilosLoad = quantityKilosLoad;
    }
    /**
     * @param totalPayLoad What the client should pay for the loads of the current journey to set. totalPayLoad>=0.
     */
    public void setTotalPayLoad(double totalPayLoad) {
        this.totalPayLoad = totalPayLoad;
    }
    /**
     * @param totalPay All what the client has paid to set. totalPay>=0.
     */
    public void setTotalPay(double totalPay) {
        this.totalPay = totalPay;
    }
    /**
     * @param totalQuantityKilos The total quantity of kilos of a client has transported to set. totalQuantityKilos>=0.
     */
    public void setTotalQuantityKilos(double totalQuantityKilos) {
        this.totalQuantityKilos = totalQuantityKilos;
    }
    /**
     * @param typeClient The type of client to set. typeClient>=1 &amp;&amp; typeClient<=4.
     */
    public void setTypeClient(int typeClient) {
        this.typeClient = typeClient;
    }

 
}
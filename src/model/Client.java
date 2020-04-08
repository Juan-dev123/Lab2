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

    public Client(String name, int crn, GregorianCalendar date, int typeClient){
        this.name=name;
        this.crn=crn;
        this.date=date;
        this.typeClient=typeClient;
    }

    public void updateKilos(double quantityKilos){
        this.quantityKilosLoad+=quantityKilos;
        this.totalQuantityKilos+=quantityKilos; 
        
    }

    public void updatePayment(double pay){
        totalPayLoad+=pay;
        totalPay+=pay;
    }

    //---------------------------------------------------------------
    //getters
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @return the crn
     */
    public int getCrn() {
        return crn;
    }
    /**
     * @return the date
     */
    public GregorianCalendar getDate() {
        return date;
    }
    /**
     * @return the quantityKilosLoad
     */
    public double getQuantityKilosLoad() {
        return quantityKilosLoad;
    }
    /**
     * @return the totalPayLoad
     */
    public double getTotalPayLoad() {
        return totalPayLoad;
    }
    /**
     * @return the totalPay
     */
    public double getTotalPay() {
        return totalPay;
    }
    /**
     * @return the totalQuantityKilos
     */
    public double getTotalQuantityKilos() {
        return totalQuantityKilos;
    }
    /**
     * @return the typeClient
     */
    public int getTypeClient() {
        return typeClient;
    }

    
   

    //---------------------------------------------------------------
    //setters
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @param crn the crn to set
     */
    public void setCrn(int crn) {
        this.crn = crn;
    }
    /**
     * @param date the date to set
     */
    public void setDate(GregorianCalendar date) {
        this.date = date;
    }
    /**
     * @param quantityKilosLoad the quantityKilosLoad to set
     */
    public void setQuantityKilosLoad(double quantityKilosLoad) {
        this.quantityKilosLoad = quantityKilosLoad;
    }
    /**
     * @param totalPayLoad the totalPayLoad to set
     */
    public void setTotalPayLoad(double totalPayLoad) {
        this.totalPayLoad = totalPayLoad;
    }
    /**
     * @param totalPay the totalPay to set
     */
    public void setTotalPay(double totalPay) {
        this.totalPay = totalPay;
    }
    /**
     * @param totalQuantityKilos the totalQuantityKilos to set
     */
    public void setTotalQuantityKilos(double totalQuantityKilos) {
        this.totalQuantityKilos = totalQuantityKilos;
    }
    /**
     * @param typeClient the typeClient to set
     */
    public void setTypeClient(int typeClient) {
        this.typeClient = typeClient;
    }

 
}
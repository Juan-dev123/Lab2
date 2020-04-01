package model;
import java.util.GregorianCalendar;
public class Client{
    //Constants
    public static final int NORMAL=1;
    public static final int SILVER=2;
    public static final int GOLD=3;
    public static final int PLATINUM=4;
    public static final double DISCOUNT_S=0.015;
    public static final double DISCOUNT_O=0.03;
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
    /**
     * @return the nrm
     */
    public int getCrn() {
        return crn;
    }

    public void updateKilos(double quantityKilos){
        this.quantityKilosLoad+=quantityKilos;
        this.totalQuantityKilos+=quantityKilos; 
        
    }

    public void updatePayment(double pay){
        totalPayLoad+=pay;
        totalPay+=pay;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

}
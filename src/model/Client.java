package model;
public class Client{
    //Atributes
    private String name;
    private int crn;
    private String date;
    private int quantityKilos;
    private int totalPay;
    private String typeClient;

    public Client(String name, int crn, String date, String typeClient){
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

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @return the quantityKilos
     */
    public int getQuantityKilos() {
        return quantityKilos;
    }

    /**
     * @return the totalPay
     */
    public int getTotalPay() {
        return totalPay;
    }

    /**
     * @return the typeClient
     */
    public String getTypeClient() {
        return typeClient;
    }
}
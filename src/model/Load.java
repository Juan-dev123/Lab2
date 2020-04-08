package model;
public class Load{
    //Constants
    public static final int PERISHABLE=1;
    public static final int NO_PERISHABLE=2;
    public static final int DANGEROUS=3;
    public static final int PRICE_KILO_P=250000;
    public static final int PRICE_KILO_NP=80000;
    public static final int PRICE_KILO_D=390000;

    //Atributes
    private int numBoxes;
    private double weightBox; //Weight in kilos
    private int typeLoad;
    
    //Relations
    private Client owner;

    //Methods
    public Load(int numBoxes, double weightBox, int typeLoad, Client owner){
        this.numBoxes=numBoxes;
        this.weightBox=weightBox;
        this.typeLoad=typeLoad;
        this.owner=owner;
    }

    public double getTotalWeight(){
        double totalWeight=numBoxes*weightBox;
        return totalWeight;
    }

    //---------------------------------------------------------------
    //getters

    /**
     * @return the numBoxes
     */
    public int getNumBoxes() {
        return numBoxes;
    }

    /**
     * @return the weightBox
     */
    public double getWeightBox() {
        return weightBox;
    }

    /**
     * @return the typeLoad
     */
    public int getTypeLoad() {
        return typeLoad;
    }



    //---------------------------------------------------------------
    //setters

    /**
     * @param numBoxes the numBoxes to set
     */
    public void setNumBoxes(int numBoxes) {
        this.numBoxes = numBoxes;
    }

    /**
     * @param weightBox the weightBox to set
     */
    public void setWeightBox(double weightBox) {
        this.weightBox = weightBox;
    }

    /**
     * @param typeLoad the typeLoad to set
     */
    public void setTypeLoad(int typeLoad) {
        this.typeLoad = typeLoad;
    }

}
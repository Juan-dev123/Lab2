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
    /**
     * It initializes the atributes of a load.
     * @param numBoxes The number of boxes. numBoxes>0.
     * @param weightBox The weight in kilos of a box. weightBox>0.
     * @param typeLoad The type o the load. typeLoad>=1 &amp;&amp; typeLoad<=3.
     * @param owner The owner.
     */
    public Load(int numBoxes, double weightBox, int typeLoad, Client owner){
        this.numBoxes=numBoxes;
        this.weightBox=weightBox;
        this.typeLoad=typeLoad;
        this.owner=owner;
    }

    /**
     * It multiplies the number of boxes with the weight of a box.
     * @return The total weight of a load.
     */
    public double getTotalWeight(){
        double totalWeight=numBoxes*weightBox;
        return totalWeight;
    }

    //---------------------------------------------------------------
    //getters

    /**
     * @return The number of boxes.
     */
    public int getNumBoxes() {
        return numBoxes;
    }

    /**
     * @return The weight of a box.
     */
    public double getWeightBox() {
        return weightBox;
    }

    /**
     * @return The type of the load.
     */
    public int getTypeLoad() {
        return typeLoad;
    }



    //---------------------------------------------------------------
    //setters

    /**
     * @param numBoxes The number of boxes to set
     */
    public void setNumBoxes(int numBoxes) {
        this.numBoxes = numBoxes;
    }

    /**
     * @param weightBox The weight of a box to set
     */
    public void setWeightBox(double weightBox) {
        this.weightBox = weightBox;
    }

    /**
     * @param typeLoad The type of the load to set
     */
    public void setTypeLoad(int typeLoad) {
        this.typeLoad = typeLoad;
    }

}
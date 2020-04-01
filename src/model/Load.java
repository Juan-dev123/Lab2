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
    private int weightBox;
    private int typeLoad;
    private Client client;

    //Methods
    public Load(int numBoxes, int weightBox, int typeLoad, Client client){
        this.numBoxes=numBoxes;
        this.weightBox=weightBox;
        this.typeLoad=typeLoad;
        this.client=client;
    }

    public int getTotalWeight(){
        int totalWeight=numBoxes*weightBox;
        return totalWeight;
    }

    /**
     * @return the typeLoad
     */
    public int getTypeLoad() {
        return typeLoad;
    }

}
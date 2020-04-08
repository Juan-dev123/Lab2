package model;
import java.util.ArrayList;

public class Ship{

    //Constants
    public static final int MAX_WEIGHT=28000;
    public static final int MIN_WEIGHT=12000;
    public static final int MIN_LOADS=2;

    //Atributes
    private String name;
    private double totalWeightLoads; //Weight in kilos
    private int[] typeLoads;

    //Relations
    private ArrayList<Load> loads; 

    //Methods
    public Ship(String name){
        this.name=name;
        totalWeightLoads=0;
        typeLoads=new int[2];
        loads=new ArrayList<Load>();
    }

    public void updateTotalWeightLoads(double weight){
        totalWeightLoads+=weight;
    }
    
    public void uploadLoad(int numBoxes, int weightBox, int typeLoad, Client client){
        loads.add(new Load(numBoxes, weightBox, typeLoad, client));
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
     * @return the totalWeightLoads
     */
    public double getTotalWeightLoads() {
        return totalWeightLoads;
    }

    public int getTypeLoad(int index){
        return typeLoads[index];
    }

    /**
     * @return the loads
     */
    public ArrayList<Load> getLoads() {
        return loads;
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
    * @param totalWeightLoads the totalWeightLoads to set
    */
    public void setTotalWeightLoads(double totalWeightLoads) {
        this.totalWeightLoads = totalWeightLoads;
    }

    public void setTypeLoads(int index, int typeLoad){
        typeLoads[index]=typeLoad;
    }
    
}
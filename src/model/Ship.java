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
    /**
     * It initializes the atributes name and typeLoads. Also creates a new ArrayList. 
     * @param name The name of the ship.
     */
    public Ship(String name){
        this.name=name;
        totalWeightLoads=0;
        typeLoads=new int[2];
        loads=new ArrayList<Load>();
    }

    /**
     * It adds kilos to the ship.
     * @param weight The weight in kilos to add. weight>0.
     */
    public void updateTotalWeightLoads(double weight){
        totalWeightLoads+=weight;
    }
    
    /**
     * It uploads a load in the ship.
     * @param numBoxes Number of boxes. numBoxes>0.
     * @param weightBox Weight in kilos of a box. weightBox>0.
     * @param typeLoad The type of the load. typeLoad>=1 &amp;&amp; typeLoad<=3.
     * @param client The owner of the load.
     */
    public void uploadLoad(int numBoxes, int weightBox, int typeLoad, Client client){
        loads.add(new Load(numBoxes, weightBox, typeLoad, client));
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
     * @return The total weight of the ship.
     */
    public double getTotalWeightLoads() {
        return totalWeightLoads;
    }

    /**
     * @param index The position. index>=0 &amp;&amp; index<=2.
     * @return The type of load in the ship.
     */
    public int getTypeLoads(int index){
        return typeLoads[index];
    }

    /**
     * @return The loads
     */
    public ArrayList<Load> getLoads() {
        return loads;
    }

    //---------------------------------------------------------------
    //setters

    /**
     * @param name The name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
    * @param totalWeightLoads The total weight of the ship to set
    */
    public void setTotalWeightLoads(double totalWeightLoads) {
        this.totalWeightLoads = totalWeightLoads;
    }

    /**
     * @param index The position. index>=0 &amp;&amp; index<=2.
     * @param typeLoad The type of load to set.
     */
    public void setTypeLoads(int index, int typeLoad){
        typeLoads[index]=typeLoad;
    }
    
}
package model;

import java.util.ArrayList;

public class Ship{

    //Constants
    public static final int MAX_WEIGHT=28000;
    public static final int MIN_WEIGHT=12000;
    public static final int MIN_LOADS=2;

    //Atributes
    private String name;
    private double totalWeightLoads;
    private int[] typeLoads;
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
    
    public void updateTypeLoads(int index, int typeLoad){
        typeLoads[index]=typeLoad;
    }

    public int getTypeLoad1(){
        return typeLoads[0];
    }

    public int getTypeLoad2(){
        return typeLoads[1];
    }

    public void uploadLoad(int numBoxes, int weightBox, int typeLoad, Client client){
        loads.add(new Load(numBoxes, weightBox, typeLoad, client));
    }

    /**
     * @return the totalWeightLoads
     */
    public double getTotalWeightLoads() {
        return totalWeightLoads;
    }
}
package model;
public class Ship{
    //Constants
    public static final int MAX_LOAD=28000;
    public static final int MAX_LOADS=10;
    //añadir peso minimo y cargas minimas
    //Attributes
    private String name;
    /*private int weightLoads;
    private String typeLoads;
    private int quantityLoads; 
    Convertir a metodos
    */
    //Relations
    private Load[] loads;
    //Methods
    
    public Ship (String name, int weigthLoads, String typeLoads, int quantityLoads){
        this.name=name;
        this.weightLoads=weigthLoads;
        this.typeLoads=typeLoads;
        this.quantityLoads=quantityLoads;
        loads=new Load[MAX_LOADS];
    }
    public int getWeight(){
        return weightLoads;
    }
    public void updateWeight(int peso){
        weightLoads+=peso;
    }
    public boolean checkTravel(int quantityLoads, int weightLoads){
        if(quantityLoads>=2 || weightLoads>12000){
            return true;
        }
        else{
            return false;
        }
    }
    public void updateTypeLoad(String typeLoad){
        String type=typeLoad.toUpperCase();
        //FALTAAAAAAA UN MONTONNNNNN

    }
   
}
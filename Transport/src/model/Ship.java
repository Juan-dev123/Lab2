public class Ship{
    //Constants
    final int MAX_LOAD=28000;
    //Attributes
    private String name;
    private int weightLoads;
    private String typeLoads;
    private int quantityLoads;

    public Ship(String name, int weigthLoads, String typeLoads, int quantityLoads){
        this.name=name;
        this.weightLoads=weigthLoads;
        this.typeLoads=typeLoads;
        this.quantityLoads=quantityLoads;
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
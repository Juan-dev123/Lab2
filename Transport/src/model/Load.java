public class Load{
    private int numberBoxes;
    private int weightBox;
    private String typeLoad;

    public Load(int numberBoxes, int weightBox, String typeLoad){
        this.numberBoxes=numberBoxes;
        this.weightBox=weightBox;
        this.typeLoad=typeLoad;
    }
    public boolean checkLoad(String typeLoad, int totalWeight){

    }
    public int getTotalWeight(){
        int totalWeight=this.numberBoxes*this.weightBox;
        return totalWeight;
    }
}
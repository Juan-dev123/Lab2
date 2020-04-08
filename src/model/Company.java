package model;
import java.util.GregorianCalendar;
public class Company{
    //Constants
    public static final int NUM_CLIENTS=5;

    //Atributes
    private String name;

    //Relations
    private Client[] clients;
    private Ship ship1;

    //Methods
    /**
     * It initializes the name of the company and also creates two clients.
     * @param name The name of the company.
     */
    public Company(String name){
        this.name=name;
        clients=new Client[NUM_CLIENTS];
        clients[0]=new Client("Postobon", 12345, new GregorianCalendar(1993, 3, 12), Client.NORMAL);
        clients[1]=new Client("Tecnoquimicas", 12346, new GregorianCalendar(1981, 7, 10), Client.NORMAL);
        ship1=new Ship("El Pirata");
    }
    //----------------------------------------------------------------------------------------------------
    //Requirement 1
    //Register a client        
    //----------------------------------------------------------------------------------------------------
    /**
        * It registers a company after verificate it doesn't exist.
        * @param name The name of the client.
        * @param crn The Commercial Register Number of the client.
        * @param date The registration issue date.
        * @param typeClient The category of the client. typeClient>=1 &amp;&amp; typeClient<=4.
        * @return A message that says if the client registered successfull.
    */
    public String registerClient(String name, int crn, GregorianCalendar date, int typeClient){
        String message;
        //Check if the client is already registered.
        if(searchClient(crn)!=null){
            message="The client with the Commercial Register Number:"+crn+" is already registered";
        }else{
            int positionAvailable=getPositionEmpty(clients);
            clients[positionAvailable]=new Client(name, crn, date, typeClient);
            message="The client with the Commercial Register Number:"+crn+" has been registered successfully";
        }
        return message;
    }

    //----------------------------------------------------------------------------------------------------
    //Requirement 2
    //Register a load to the ship 
    //----------------------------------------------------------------------------------------------------
    /**
     * It adds a load to the ship if it is possible. Also it charges the load to the owner
     * @param numBoxes The number of boxes of the load 
     * @param weightBox The weight in grams of a box
     * @param typeLoad The type of the load. typeLoad>=1 &amp;&amp; typeLoad<=3  
     * @param positionClient The position of the client in the array clients
     * @return A message informing the status of the load
     */
    public String addLoad(int numBoxes, int weightBox, int typeLoad, int positionClient){
        String message=""; 
        boolean createNewLoad=true;
        double requiredWeight=numBoxes*weightBox/1000; //Converts grams into kilos
        //Evaluate if there is space in the ship
        if(Ship.MAX_WEIGHT-ship1.getTotalWeightLoads() < requiredWeight){
            message="There is not space for the load.";
            createNewLoad=false;
        }
        //Evaluate the type of the load
        else if(ship1.getTypeLoads(0)==3 || ship1.getTypeLoads(1)==3){
            if(typeLoad==1){
                message="There is a load type DANGEROUS in the ship, you can't add a load type PERISHABLE";
                createNewLoad=false;
            }
        }else if(ship1.getTypeLoads(0)==1 || ship1.getTypeLoads(1)==1){
            if(typeLoad==3){
                message="There is a load type PERISHABLE in the ship, you can't add a load type DANGEROUS";
                createNewLoad=false;
            }
        }

        if(createNewLoad){
            ship1.uploadLoad(numBoxes, weightBox, typeLoad, clients[positionClient]);
            ship1.updateTotalWeightLoads(requiredWeight);
            message="The load was uploaded successfully";
            if(ship1.getTypeLoads(0)==0){
                ship1.setTypeLoads(0, typeLoad);
            }else if(ship1.getTypeLoads(1)==0 && typeLoad!=ship1.getTypeLoads(0)){
                ship1.setTypeLoads(1, typeLoad);
            }
            clients[positionClient].updateKilos(requiredWeight);
            clients[positionClient].updatePayment(calculatePaymentLoad(typeLoad, requiredWeight, positionClient));
        }

        //The next part doesn't belong to the requirement, but I think that could be helpful for Morgan
        if(clients[positionClient].getTotalPay()>=5000000 && clients[positionClient].getTypeClient()!=Client.PLATINUM){
            message+="\nIf you want you can upload this client to Platinum";
        }else if((clients[positionClient].getTotalQuantityKilos()>=55000 || clients[positionClient].getTotalPay()>=2000000) && clients[positionClient].getTypeClient()==Client.SILVER || clients[positionClient].getTypeClient()==Client.NORMAL){
            message+="\nIf you want you can upload this client to Gold";
        }else if(clients[positionClient].getTotalQuantityKilos()>=35000 && clients[positionClient].getTypeClient()==Client.NORMAL){
            message+="\nIf you want you can upload this client to Silver";
        } 
        return message;

    }

    //----------------------------------------------------------------------------------------------------
    //Requirement 3
    //Give the total value to pay to a client
    //----------------------------------------------------------------------------------------------------
    /**
     * It gets what a client should pay.
     * @param positionClient The position of the client in the array of the clients.
     * @return What a client should pay.
     */
    public double getTotalPayClient(int positionClient){
        double totalPay;
        Client client=clients[positionClient];
        totalPay=client.getTotalPayLoad();
        return totalPay;
    }

    //----------------------------------------------------------------------------------------------------
    //Requirement 4
    //Download the ship
    //----------------------------------------------------------------------------------------------------
    /**
     * It deletes all the information of the current load.
     * @return A message informing the situation.
     */
    public String downloadLoad(){
        ship1.setTotalWeightLoads(0);
        ship1.getLoads().clear();
        ship1.setTypeLoads(0, 0);
        ship1.setTypeLoads(1, 0);
        boolean stop=false;
        for(int i=0; i<clients.length && !stop; i++){
            if(clients[i]==null){
                stop=true;
            }else{
                clients[i].setTotalPayLoad(0);
                clients[i].setQuantityKilosLoad(0);
            }
        }
        String message="The load has been downloaded. The ship is ready for another trip";
        return message;
    }

    //----------------------------------------------------------------------------------------------------
    //Requirement 5
    //Give the total weight in the ship
    //----------------------------------------------------------------------------------------------------
    /**
     * It gets the total weight in the ship.
     * @return The total weight in kilos that there is in the ship.
     */
    public double getTotalShipWeight(){
        double totalWeight=ship1.getTotalWeightLoads();
        return totalWeight;
    }

    //----------------------------------------------------------------------------------------------------
    //Requirement 6
    //Check if the ship is able to set sail
    //----------------------------------------------------------------------------------------------------
    /**
     * It checks if the ship is able to set sail.
     * @return A message informing if the ship is able to set sail.
     */
    public String setSail(){
        String message;
        if(ship1.getLoads().size()>=Ship.MIN_LOADS){
            message="The ship is able to set sail%nThere are %d loads in the ship with a total weight of %.2f kilos%n";
        }else if(ship1.getTotalWeightLoads()>Ship.MIN_WEIGHT){
            message="The ship is able to set sail%nThere are %d loads in the ship with a total weight of %.2f kilos%n";
        }else{
            message="The ship is not able to set sail%nThere are %d loads in the ship with a total weight of %.2f kilos%n";
        }
        return message;
    }

    //----------------------------------------------------------------------------------------------------
    //Requirement 7
    //Update the category of a client
    //----------------------------------------------------------------------------------------------------
    /**
     * It updates the category of a client if the client meets all the requirements.
     * @param category The new category. category>=1 &amp;&amp; category<=4.
     * @param positionClient The position of the client in the array of the clients.
     * @return A message informing if the client could be updated.
     */
    public String updateCategory(int category, int positionClient){
        String message;
        Client client=clients[positionClient];
        if(category==Client.SILVER){
            if(client.getTotalQuantityKilos()>=35000){
                client.setTypeClient(category);
                message="The category of the client was uploaded to Silver";
            }else{
                message="The client can't be Silver because it hasn't transported at least 35.000 kilos";
            }
        }else if(category==Client.GOLD){
            if(client.getTotalQuantityKilos()>=55000 || client.getTotalPay()>=2000000){
                client.setTypeClient(category);
                message="The category of the client was uploaded to Gold";
            }else{
                message="The client can't be Gold because it hasn't transported at least 55.000 kilos or it hasn't paid 2 million pesos";
            }   
        }else{
            if(client.getTotalPay()>=5000000){
                client.setTypeClient(category);
                message="The category of the client was uploaded to Platinum";
            }else{
                message="The client can't be Platinum because it hasn't paid at least 5 million pesos";
            } 
        }
        return message;
    }

    /**
     * It searches a client in an array type Client.
     * @param crn The Commercial Register Number of the client.
     * @return The client with the Commercial Register Number entered. If the client doesn't exist return null.
     */
    public Client searchClient(int crn){ 
        Client client=null;
        boolean stop=false;
        for(int i=0; i<NUM_CLIENTS && !stop; i++){
            if(clients[i]==null){
                stop=true;
            }else if(clients[i].getCrn()==crn){
                client=clients[i];
                stop=true;   
            }
        }
        return client;
    }

    /**
     * It gets a postion empty in a array type Client.
     * @param array The array.
     * @return A position empty in the array.
     */
    public int getPositionEmpty(Client[] array){
        int position=0;
        boolean stop=false;
        for(int i=0; i<NUM_CLIENTS && !stop; i++){
            if(clients[i]==null){
                position=i;
                stop=true;
            }
        }
        return position;
    } 

    /**
     * It calculates what a client should pay for its load.
     * @param typeLoad The type of load. typeLoad>=1 &amp;&amp; typeLoad<=3.
     * @param kilos The weight of the load in kilos.
     * @param positionClient The position of client in the array clients.
     * @return What a client should pay for its load.
     */
    public double calculatePaymentLoad(int typeLoad, double kilos, int positionClient){
        Client client=clients[positionClient];
        double payment;
        //Charge the value by kilo
        if(typeLoad==Load.PERISHABLE){
            payment=Load.PRICE_KILO_P*kilos;
        }else if(typeLoad==Load.NO_PERISHABLE){
            payment=Load.PRICE_KILO_NP*kilos;
        }else{
            payment=Load.PRICE_KILO_D*kilos;
        }
        //Make the discount if apply
        if(client.getTypeClient()==Client.SILVER){
            if(typeLoad==Load.PERISHABLE){
                payment=payment-payment*Client.DISCOUNT_S;
            }
        }else if(client.getTypeClient()==Client.GOLD){
            if(typeLoad==Load.PERISHABLE || typeLoad==Load.NO_PERISHABLE){
                payment=payment-payment*Client.DISCOUNT_G;
            }
        }else if(client.getTypeClient()==Client.PLATINUM){
            payment=payment-payment*Client.DISCOUNT_P;
        }
        return payment; 
    }
    
    /**
    * It checks if there is space in the array clients.
    * @return True if there is space. False if it doesn't.
    */
    public boolean lookForSpace(){
        boolean space=true;
        if(clients[NUM_CLIENTS-1]!=null){
            space=false;
        }
        return space;
    }
    //----------------------------------------------------
    //getters
    /**
     * It gets the name of the company.
     * @return The name.
     */
    public String getName() {
        return name;
    }

    /**
     * It gets the object ship1.
     * @return The ship1.
     */
    public Ship getShip1() {
        return ship1;
    }
    /**
     * It gets the array of clients.
     * @return The array of clients.
     */
    public Client[] getClients() {
        return clients;
    }

    //----------------------------------------------------
    //setters
    /**
     * It sets the name of the company.
     * @param name The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

}
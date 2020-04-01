package model;
public class Company{
    //Constants
    public static final int NUM_CLIENTS=5;

    //Atributes
    private String name;

    //Relations
    private Client[] clients;
    private Ship ship1;

    //Methods
    public Company(String name){
        this.name=name;
        clients=new Client[NUM_CLIENTS];
        ship1=new Ship("El Pirata");
    }

   //Requirement 1
   //Register a client         //Revisa este requerimientooooo

   /**
    * Name: registerClient
    * <b>pre: </b> The category entered is a valid category of a company.<br>
    * It registers a company after verificate it doesn't exist
    * @param name The name of the company
    * @param crn The Commercial Register Number of the company
    * @param date The registration issue date
    * @param typeClient The category of the company
    * @return A message that says whether the company registered successfull.
    */
    public String registerClient(String name, int crn, String date, String typeClient){
        String message;
        if(searchClient(crn)!=null){
            message="The client with the Commercial Register Number:"+crn+" is already registered";
        }else{
            if(clients[NUM_CLIENTS-1]!=null){
                message="There is not space. You can't add another client";
            }else{
                int positionAvailable=getPositionEmpty(clients);
                clients[positionAvailable]=new Client(name, crn, date, typeClient);
                message="The client with the Commercial Register Number:"+crn+" has been registered successfully";
            } 
        }
        return message;
    }

    //Requirement 2
    //Register a load to the ship  //Revisa este requerimientoooooooo

    public String addLoad(int numBoxes, int weightBox, int typeLoad, Client client){
        String message=""; 
        boolean createNewLoad=true;
        int requiredWeight=convertGtoK(numBoxes*weightBox);
        //Evaluate if there is space
        if(Ship.MAX_WEIGHT-ship1.getTotalWeightLoads() < requiredWeight){
            message="There is not space for the load.";
            createNewLoad=false;
        }
        //Evaluate the type of the load
        else if(ship1.getTypeLoad1()==3 || ship1.getTypeLoad1()==3){
            if(typeLoad==1){
                message="There is a load type DANGEROUS in the ship, you can't add a load type PERISHABLE";
                createNewLoad=false;
            }
        }
        if(createNewLoad){
            ship1.uploadLoad(numBoxes, weightBox, typeLoad, client);
            message="The load was uploaded successfully";
            if(ship1.getTypeLoad1()==0){
                ship1.updateTypeLoads(0, typeLoad);
            }else if(ship1.getTypeLoad2()==0 && typeLoad!=ship1.getTypeLoad1()){
                ship1.updateTypeLoads(1, typeLoad);
            }
            client.updateKilos(requiredWeight);

            client.updatePayment(calculatePaymentLoad(typeLoad, requiredWeight));
        }
        return message;

    }
    /**
     * Name: searchClient
     * It searches a company in an array type Client
     * @param crn The Commercial Register Number of the company
     * @return The company with the Commercial Register Number entered
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
     * Name: getPositionEmpty
     * It gets a postion empty in a array type Client
     * @param array The array
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
     * @return the clients
     */
    public Client[] getClients() {
        return clients;
    }

    public int calculatePaymentLoad(int typeLoad, int kilos){
        int payment;
        if(typeLoad==Load.PERISHABLE){
            payment=Load.PRICE_KILO_P*kilos;
        }else if(typeLoad==Load.NO_PERISHABLE){
            payment=Load.PRICE_KILO_NP*kilos;
        }else{
            payment=Load.PRICE_KILO_D*kilos;
        }
        return payment; 
    }

    public int convertGtoK(int grams){
        int kilos=grams/1000;
        return kilos;
    }
}
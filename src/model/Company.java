package model;
public class Company{
    //Constants
    public static final int NUM_CLIENTS=5;

    //Atributes
    private String name;

    //Relations
    private Client[] clients;

    //Methods
    public Company(String name){
        this.name=name;
        clients=new Client[NUM_CLIENTS];
    }

   //Requirement 1
   //Register a client

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
                System.out.println(positionAvailable); 
                message="The client with the Commercial Register Number:"+crn+" has been registered successfully";
            } 
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
}
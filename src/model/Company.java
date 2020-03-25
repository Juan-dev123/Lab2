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

    public String addClient(String name, int crn, String date, String typeClient){
        String message;
        boolean exist=searchClient(crn);
        if(exist){
            message="The client with the Commercial Register Number:"+crn+" is already registered";
        }else{
            int positionAvailable=getPositionEmpty(clients);
            clients[positionAvailable]=new Client(name, crn, date, typeClient);
            System.out.println(positionAvailable); 
            message="The client with the Commercial Register Number:"+crn+" has been registered successfully";
        }
        return message;
    }

    public boolean searchClient(int crn){ //CORREGIRRRRRRR
        boolean exist=false;
        boolean stop=false;
        for(int i=0; i<NUM_CLIENTS && !stop; i++){
            if(clients[i]==null){
                stop=true;
            }else if(clients[i].getCrn()==crn){
                exist=true;
                stop=true;   
            }
        }
        return exist;
    }

    public int getPositionEmpty(Client[] array){ //CORREGIRRRRR
        int position=0;
        boolean stop=false;
        for(int i=0; i<NUM_CLIENTS && !stop; i++){
            if(clients[i]==null){
                position=i;
            }
        }
        return position;
    }
    public void imprimirCliente(int posicion){
        System.out.println(clients[posicion].getName());
        System.out.println(clients[posicion].getCrn());
        System.out.println(clients[posicion].getDate());
        System.out.println(clients[posicion].getTypeClient());
    }
}
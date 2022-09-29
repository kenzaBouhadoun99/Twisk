package twisk.simulation;

import twisk.monde.Etape;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class GestionnaireClients  implements Iterable<Client>{
     private ArrayList<Client> clients ;
     int nbClients ;

    /**
     * Constructeur de gestionnaire clients
     * @param nbClients
     */
    public GestionnaireClients(int nbClients){
        clients = new ArrayList<>(nbClients);
    }

    public void setNbClients(int nbClients ){
        this.nbClients = nbClients;

    }
    public ArrayList<Client> getGestclients(){
        return clients;
    }
    public void setClients(int[] tabClients ){
        for(int client : tabClients){
            clients.add(new Client(client));
        }

    }

    /**
     * La fonction qui permet de mettre a jour les attributs etape et rang d'un clients et leurs numeros
     * @param numeroClient
     * @param etape
     * @param rang
     */
    public void allerA(int numeroClient  , Etape etape , int rang){
        for(Client client : clients){
          if(client.getNumClient() == numeroClient){
              client.AllerA(etape,rang);
          }
        }

    }


    /**
     * Iterrateur afin de parcourir tous les clients
     * @return
     */
    public Iterator<Client> iterator(){
        return clients.iterator();
    }

    public ArrayList<Client> getLClients() {
        return clients;
    }
}

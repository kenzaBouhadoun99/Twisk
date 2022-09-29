package twisk.simulation;
import javafx.concurrent.Task;
import twisk.monde.Etape;
import twisk.monde.Monde;
import twisk.mondeIG.SujetObserve;
import twisk.outils.KitC;
import twisk.outils.ThreadsManager;
import twisk.vues.VueBouleIG;

import java.util.Iterator;


public class Simulation extends SujetObserve implements Iterable<Client>{
    /**
     * Variables
     */
    int[] tab_Clients;
    int[] cher_Clients;
    int[] tabJetonsGuichet ;
    int nbEtapes ;
    int nbGuichets ;
    int nbClients = 6;
    boolean ended = false;
    Client clt;
    int etape, numEtapes;
     KitC kit ;
     GestionnaireClients gestClients ;
     Boolean simulation ;

    /**
     * Constructeurs de Simulation
     */
    public Simulation(){

    }

    /**
     * fonction qui fais la simulation de monde
     * @param monde
     * @throws InterruptedException
     */
    public void simuler(Monde monde) {
     /*  Task<Void> task = new Task<Void>() {
           @Override
           protected Void call() throws Exception {
               try{*/
                   monde.toC();kit = new KitC();
                   kit.creerEnvironnement();
                   kit.creerFichier(monde.toC());
                   kit.compiler();
                   kit.construireLaLibrairie();
                   System.out.println(" "+monde.toString());
                   System.load("/tmp/twisk/libTwisk"+kit.getNumlib()+".so") ;
                   tabJetonsGuichet = this.Nbjetons(monde);
                   nbEtapes = monde.nbEtapes();
                   nbGuichets = monde.nbGuichet();
                   gestClients = new GestionnaireClients(nbClients);

                   tab_Clients = start_simulation(nbEtapes, nbGuichets, nbClients, tabJetonsGuichet);
                   System.out.println("Les clients: ");
                   for (int i = 0; i < nbClients; i++) {
                       System.out.print(" "+tab_Clients[i]);
                   }
                   System.out.println(" \n************************************\n");
                   while (!ended) {
                       cher_Clients = ou_sont_les_clients(nbEtapes, nbClients);
                       for (etape = 0, numEtapes = 0; numEtapes < nbEtapes; ++numEtapes, ++etape) {
                           int nbClientsEtapes = cher_Clients[etape];
                           System.out.print("\n\nétapes " + numEtapes + " ("+ monde.getNomEtape(numEtapes)+") " + cher_Clients[etape] + "  clients: ");

                           for (int client = 0; client <= nbClientsEtapes; client++) {
                               System.out.printf(" " + cher_Clients[etape + client] + " ");
                               gestClients.allerA(cher_Clients[getNbClients()] , monde.getEtape(numEtapes), client);
                           }
                           etape += nbClients;
                           if (numEtapes == 1) {
                               ended = nbClientsEtapes == nbClients;
                           }
                           monde.reset();
                       }
                       try {
                           Thread.sleep(1000);
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
                   }
                   nettoyage();
                 /*  ThreadsManager.getInstance().detruireTout();
               }catch(InterruptedException e){
                   e.printStackTrace();
               }
               return null;
           }
       };
        ThreadsManager.getInstance().lancer(task);
       */
    }

    /**
     * La fonction qui permet de donner le nombre de jetons pour les guichets
     * @param monde
     * @return
     */
    public int[] Nbjetons(Monde monde){
        int[] jetons=new int[monde.nbGuichet()];
        int cpt=0;
        for (Etape e:monde){
            if (e.estUnGuichet()){
                jetons[cpt]=e.getnbJetons();
                cpt++;
            }
        }
        return jetons;
    }

    /**
     * Setter de nombre de cliens
     * @param nbClients
     */
    public void setNbClients(int nbClients) {
        this.nbClients= nbClients ;
    }

    /**
     * Getter de nombre de clients
     * @return
     */
    public int getNbClients() {
        return nbClients;
    }

    /**
     * fonction qui lance la simulation
     * @param nbEtapes
     * @param nbServices
     * @param nbClients
     * @param tabJetonsServices
     * @return
     */
    public native int [] start_simulation(int nbEtapes, int nbServices, int nbClients, int []tabJetonsServices);

    /**
     * fonction qui indique l'amplacement des clients
     * @param nbEtapes
     * @param nbClients
     * @return
     */
    public native int [] ou_sont_les_clients(int nbEtapes, int nbClients);

    /**
     * fonction qui nettoye le monde
     */
    public native void nettoyage();

    /**
     * Getter des jetons de guichet
     * @return
     */
    public int[] getTabJetonsGuichet() {
        return tabJetonsGuichet;
    }

    /**
     * Getter de nombre de guichet
     * @return
     */
    public  int getNbGuichets(){
        return nbGuichets;
    }

    /**
     * Setter de nombre de guichet
     * @param nbg
     */
    public  void setNbGuichets(int nbg){
         this.nbGuichets = nbg;
    }

    /**
     * Getter de la table des clients
     * @return
     */
    public int[] getTab_Clients() {
        return tab_Clients;
    }

    /**
     * Getter de l'amplacement des clients
     * @return
     */
    public int[] getCher_Clients() {
        return cher_Clients;
    }

    /**
     * Setter des jetons
     * @param tabJetonsGuichet
     */


    public void setTabJetonsGuichet(int[] tabJetonsGuichet) {
        this.tabJetonsGuichet = tabJetonsGuichet;
    }

    @Override
    public Iterator<Client> iterator() {
        return null;
    }

    /**
     * La fonction qui permet de detection l'etat de la simulation
     * @return
     */
    public Boolean isStarted(){
        return simulation;
    }
}

package twisk.simulation;

import twisk.monde.Etape;


public class Client {
    private int numeroClient ;
    private int rang ;
    private Etape etape ;

    /**
     * constructeur des clients
     * @param numero
     */
    public Client(int numero){
        this.numeroClient=numero;

    }

    /**
     * getter du rang
     * @return
     */
    public int getRang() {
        return rang;
    }

    /**
     * getter de l'etape
     * @return
     */
    public Etape getEtape() {
        return etape;
    }

    /**
     * La fonction qui permet de mettre a jour les attributs etape et rang d'un clients
     * @param etape
     * @param rang
     */
    public  void AllerA(Etape etape,int rang){
        this.rang=rang;
        this.etape=etape;
    }

    /**
     * getter de numero de client
     * @return
     */
    public  int getNumClient() {
        return numeroClient;
    }
}

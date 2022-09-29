package twisk.outils;

public class FabriqueIdentifiant {
    private static FabriqueIdentifiant instance = new FabriqueIdentifiant();
    private int nmetap;

    /**
     * Constructeur de FabriqueIdentifiant
     */
    public FabriqueIdentifiant(){
        this.nmetap =0;
    }

    /**
     * @return instance
     */
    public static FabriqueIdentifiant getInstance() {
        return instance;
    }

    /**
     * getter de IdentifiantEtape
     * @return le numero de l'etape
     */
    public String getIdentifiantEtape() {
        nmetap++;
        return String.valueOf(nmetap -1);

    }

}

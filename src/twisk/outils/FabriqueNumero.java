package twisk.outils;

import java.io.Serializable;

public class FabriqueNumero  implements Serializable {

    private static final FabriqueNumero instance = new FabriqueNumero();
    private int cptEtape;
    private int cptSemaphore;
    private int numlibrairie;

    /**
     * Constructeur de FabriqueNumero
     */
    private FabriqueNumero() {
        cptEtape = 0;
        cptSemaphore = 1;
        numlibrairie =0;
    }
    public static FabriqueNumero getInstance() {
        return instance;
    }

    /**
     * Getter de  NumeroEtape
     * @return Numero de l'etape
     */
    public int getNumeroEtape() {
        assert (cptEtape >= 0) : " Bug ! , cpt negatif ";
        cptEtape++;
        return cptEtape - 1;
    }
    public void reset() {//monde et getionnaire etape
        cptEtape = 0;
        cptSemaphore = 1;
    }

    /**
     * Getter de NumeroSemaphore
     * @return  Numero de semaphore
     */
    public int getNumeroSemaphore() {
        assert (cptSemaphore > 0) : "Bug ! , cpt inferieur a 1 ";
        cptSemaphore++;
        return cptSemaphore - 1;
    }

    /**
     * getter de numero de la librairie
     * @return
     */
    public int getnumlib(){
        numlibrairie++;
        return numlibrairie;
    }

}

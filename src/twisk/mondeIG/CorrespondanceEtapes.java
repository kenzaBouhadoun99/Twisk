package twisk.mondeIG;

import twisk.monde.Etape;

import java.io.Serializable;
import java.util.HashMap;

public class CorrespondanceEtapes implements Serializable {

    private final HashMap<EtapeIG,Etape> correspondance ;

    /**
     * Constructeur de CorrespondanceEtapes
     */
    public CorrespondanceEtapes(){
        correspondance = new HashMap<>(15);
    }

    /**
     * La fonction qui ajoute la corresondance
     * @param etig
     * @param et
     */
    public void ajouter(EtapeIG etig , Etape et){
        correspondance.put(etig,et);
    }

    /**
     * GETTER d'etapes
     * @param e
     * @return
     */

    public Etape get(EtapeIG e ){
        return correspondance.get(e);
    }

    /**
     *
     * @return
     */

    public HashMap<EtapeIG, Etape> getCorrespondance() {
        return correspondance;
    }
}

package twisk.monde;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class GestionnaireSuccesseurs implements Iterable<Etape>{
    /*
    Les variables
     */
    private ArrayList<Etape> liste_etapes;

    /**
     * Les constructeurs des gestionnaires successeurs
     */
    public GestionnaireSuccesseurs(){
        this.liste_etapes = new ArrayList<Etape>();
    }
    public void ajouter(Etape... etapes){

        for (Etape e : etapes) {
            this.liste_etapes.add(e);
        }

    }

    /**
     * Fonctions qui retourne le nombre d'etapes
     * @return
     */
    public int nbEtapes(){
      return this.liste_etapes.size();
    }

    /**
     * Iterrateur d'etapes
     * @return
     */
    @Override
    public Iterator<Etape> iterator() {
      return liste_etapes.iterator();
    }

    @Override
    /**
     * Fonction qui affiche le nom pour chaque etapes
     */
    public String toString(){
        StringBuilder str = new StringBuilder();
        for(Etape step :getEtapes()){
            str.append(step.getNom()+" - ");
        }
        return str.toString();
    }

    /**
     * Getter d'etapes
     * @return
     */
    public ArrayList<Etape> getEtapes() {
        return liste_etapes;
    }
    /**
     * Getter de successeurs d'etapes
     * @return
     */
    public Etape getSuccesseur(){
        return liste_etapes.get(0);
    }
}

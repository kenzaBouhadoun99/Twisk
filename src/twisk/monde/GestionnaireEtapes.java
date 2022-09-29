package twisk.monde;

import twisk.outils.FabriqueNumero;

import java.util.ArrayList;
import java.util.Iterator;

public class GestionnaireEtapes implements Iterable<Etape> {
    /**
     * Les variables
     */
    private ArrayList<Etape> liste_Steps;

    /**
     * Constructeurs de Gestionnaire Monde
     */
    public GestionnaireEtapes(){
        this.liste_Steps= new ArrayList<Etape>();
    }

    /**
     * Fonction qui ajoute les etpaes
     * @param etapes
     */
    public void ajouter(Etape... etapes) {
        for (Etape e : etapes) {
            this.liste_Steps.add(e);
        }
    }
/**
 * Fonction qui retourne le nombre d'etapes
 */
    public int nbEtapes(){
        return liste_Steps.size();
    }

    /**
     * Iterrateur qui parcours toutes les etapes
     * @return
     */
    @Override
    public Iterator<Etape> iterator() {
        return liste_Steps.iterator();
    }

    /**
     * Getter  des etapes
     * @return La liste de toutes les etapes
     */
    public ArrayList<Etape> getEtapes() {
        return liste_Steps;
    }

    /**
     * Fonction qui affiche les etapes
     * @return
     */
    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        for(Etape step :getEtapes()){
            str.append(step.toString()+"\n");
        }
        return str.toString();
    }

    /**
     * Getter d'etapes
     * @param i
     * @return
     */
    public  Etape getEtapes(int i ){
        return liste_Steps.get(i);
    }

    /**
     * La fonction qui fais la mise a jour de la librairie LibTwisk.so
     */
    public void reset(){
        FabriqueNumero fab = FabriqueNumero.getInstance();
        fab.reset();
    }
}

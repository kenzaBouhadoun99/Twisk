package twisk.mondeIG;

import twisk.vues.Observateur;

import java.util.ArrayList;

public class SujetObserve {
    private ArrayList<Observateur>listeObservateur = new ArrayList<>();

    /**
     * Fonction ajouter observateur
     * @param v
     */
    public void ajouterObservateur(Observateur v) {
        this.listeObservateur.add(v) ;
    }
    /**
     * Fonction de notification d'observateur
     */
    public void notifierObservateurs(){
        for (Observateur o : this.listeObservateur) o.reagir();
    }
}

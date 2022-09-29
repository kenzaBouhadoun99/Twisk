package twisk.monde;

public class SasSortie extends Activite {

    /**
     * Constructeurs de sas sortie
     */
    public SasSortie(){
        super("sortie");
    }
    /**
     * Fonction qui affiche la sortie
     * @return sortie
     */
    @Override
    public String toString() {
        return this.nom+" : "+nbSuccesseur()+" successeur(s)  "+gest_Succ.toString();
    }

    /**
     * Fonction qui genere le code c
     * @return
     */
    @Override
    public String toC() {
        return "";
    }
}

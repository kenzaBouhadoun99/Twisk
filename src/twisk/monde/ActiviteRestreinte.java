package twisk.monde;

public class ActiviteRestreinte extends Activite {
    /**
     *
     * @param nom
     */
    public ActiviteRestreinte(String nom){
        super(nom);
    }

    /**
     *
     * @param nom
     * @param t
     * @param e
     */
    public ActiviteRestreinte(String nom , int t , int e){
        super(nom ,t ,e);
    }

    /**
     * Fonctions qui affiche l'activité restrainte
     * @return
     */
    public String toString(){
        return super.toString();
    }

    /**
     * Fonction qui genere le code c
     * @return
     */
    public String toC() {
        int i =1 ;
        StringBuilder strC = new StringBuilder();
        strC.append("transfert("+this.getNom()+this.getNum()+","+this.gest_Succ.getSuccesseur().getNom()+this.gest_Succ.getSuccesseur().getNum()+");\n"+gest_Succ.getSuccesseur().toC());
        return strC.toString();
    }

}

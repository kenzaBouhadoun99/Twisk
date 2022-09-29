package twisk.monde;

public class SasEntree extends Activite {

    /**
     * Constructeur de sas entree
     */
    public SasEntree(){
        super("entree");
    }


    /**
     * Fonction qui affiche l'entree
     * @return entree et ses successeurs
     */
    @Override
    public String toString() {
        return this.getNom()+" : "+nbSuccesseur()+" successeur(s) - "+gest_Succ.toString();
    }

    /**
     * Fonction qui genere le code c
     * @return
     */
    @Override
    public String toC() {

        return "entrer("+this.getNom()+this.getNum()+");\ndelai(4,3);\ntransfert("+this.getNom()+this.getNum()+","+this.gest_Succ.getSuccesseur().getNom()+this.gest_Succ.getSuccesseur().getNum()+");\n"+this.gest_Succ.getSuccesseur().toC();

    }
}









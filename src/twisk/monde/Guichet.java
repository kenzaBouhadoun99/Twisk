package twisk.monde;


import twisk.outils.FabriqueNumero;
public class Guichet extends Etape {
    /**
     * Les variables
     */
    protected int nbjetons;
    protected int nbSemaphore = FabriqueNumero.getInstance().getNumeroSemaphore();;

    /**
     * Constructeurs de guichet
     * @param nom
     */
    public Guichet(String nom){
        super(nom);
        this.nbjetons=2;

    }

    /**
     * Constructeur de guichet
     * @param nom
     * @param nb
     */
    public Guichet(String nom,int nb){
        super(nom);
        this.nbjetons=nb;
    }

    /**
     * Fonction qui retourne vrai si un etapes est une activite et faux sinon
     * @return
     */
    @Override
    public boolean estUneActivite() {
        return false;
    }

    /**
     * Fonction qui retourne vrai si une etape est un guichet, faux ,sinon
     * @return
     */
    public boolean estUnGuichet(){
        return true;
    }

    /**
     * Fonction qui sert a afficher le nom ainsi que le nombre de successeurs
     * @return nom, nbsuccesseurs
     */
    @Override
    public String toString(){
     return this.nom+" : "+nbSuccesseur()+" successeur(s) - "+gest_Succ.toString();
    }

    /**
     * Fonction qui genere le code C
     */
    @Override
    public String toC() {
        return "P(" + "ids" + "," + getSemaphore()+ "); \n" +
                "transfert("+this.getNom()+this.getNum()+","+gest_Succ.getSuccesseur().getNom()+this.gest_Succ.getSuccesseur().getNum()+");\n"+
                "delai(6,3);\n" +
                "V(ids," + getSemaphore()+ ");\n" + gest_Succ.getSuccesseur().toC();
    }
    /*public ActiviteRestreinte getSuivant() {
        return (ActiviteRestreinte) getGestionnaireSuccesseurs().getEtapes().get(0);
    }*/

    /**
     * Getter de semaphore
     * @return nombre de semaphore
     */
    public String getSemaphore(){
        return "num_sem_guichet" +nbSemaphore;
    }

    /**
     * Getter de semaphore
     */
    @Override
    public String getDefineSema(){
        return "#define "+getSemaphore() +" "+nbSemaphore;
    }

    /**
     * Getter de nombre de jetons
     * @return nombres de jetons
     */
    @Override
    public int getnbJetons(){
        return nbjetons;
    }

}

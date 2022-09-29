package twisk.monde;

public class Activite extends Etape {
    /**
     *     Les variables
     *     temps : Temps de chaque activite
     *     ecart temps : l'ecart temps entre chaque activité
     */
    protected int temps;
    protected int ecartTemps;

    /**
     *
     * @param nom
     */
    public Activite(String nom){
        super(nom);
        this.temps=6;
        this.ecartTemps=3;
    }

    /**
     *
     * @param nom
     * @param t
     * @param e
     */
    public Activite(String nom , int t , int e){
        super(nom);
        this.temps = t;
        this.ecartTemps= e;
    }

    /**
     * fonction qui test si une etape est une activité ou non
     * @return un boolean
     */
    public boolean estUneActivite(){
        return true;
    }

    /**
     * Fonctions qui tests si une étapes est un guichet ou non
     * @return un boolean
     */
    @Override
    public boolean estUnGuichet() {
        return false;
    }

    /**
     *
     * @return Fonction qui retourne une chaine de caracteres de nom  et nombre de successeurs
     */
    @Override
    public String toString(){
        return this.nom+" : "+nbSuccesseur()+" successeur(s) - "+gest_Succ.toString();
    }

    /**
     *
     * @return
     */
    public String toC() {
        int i =1 ;
        StringBuilder strC = new StringBuilder();
        strC.append("\ndelai("+getTemps()+","+getEcartTemps()+");\n" +
                "transfert("+this.getNom()+this.getNum()+","+this.gest_Succ.getSuccesseur().getNom()+this.gest_Succ.getSuccesseur().getNum()+");\n"+gest_Succ.getSuccesseur().toC());
        return strC.toString();
    }

    /**
     *
     * @return le temps
     */
    public int getTemps() {
        return temps;
    }

    /**
     *
     * @return l'ecart temps
     */
    public int getEcartTemps() {
        return ecartTemps;
    }

    /**
     *
     * @return getter de semaphore
     */
    @Override
    public String getDefineSema() {
        return null;
    }

    /**
     *
     * @return Getter de nombre de jetons
     */
    @Override
    public int getnbJetons() {
        return 0;
    }
}

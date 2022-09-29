package twisk.mondeIG;

public class GuichetIG extends EtapeIG {
    /**
     * constructeur du guichetIG
     * @param nom
     * @param idf
     * @param larg
     * @param haut
     */
    public GuichetIG(String nom,String idf,int larg,int haut){
        super(nom,idf,larg,haut);
    }


    /**
     * fonction qui vérifie si l'étape est un guichet
     */
    @Override
    public boolean estUnGuichet(){
        return true;
    }
}

package twisk.monde;

import twisk.outils.FabriqueNumero;
import java.util.Iterator;

public abstract class Etape implements Iterable<Etape> {

    /**
     * Les variables
     */
    protected String nom;
    protected GestionnaireSuccesseurs gest_Succ;
    protected int numEtape ;

    /**
     *
     * @param nom
     */
    public Etape(String nom){
        this.nom=nom;
        this.gest_Succ=new GestionnaireSuccesseurs();
        this.numEtape = FabriqueNumero.getInstance().getNumeroEtape();
    }

    /**
     * Fonctions qui ajoute les successeurs
     * @param e
     */
    public void ajouterSuccesseur(Etape... e){
        this.gest_Succ.ajouter(e);
    }

    /**
     * Fonction qui vérifie si une etape est une activité ou pas
     * @return
     */
    public abstract boolean estUneActivite();

    /**
     * Fonction qui vérifie une etape est un guichet ou pas
     * @return
     */
    public abstract boolean estUnGuichet();

    /**
     * getter de nom
     * @return
     */
    public String getNom(){
        String name = this.nom;
        name = name.replaceAll(" " , "_");
        name = name.replaceAll("[~^'¶§þß] " , "_");
        name = name.replaceAll("[éëêè&£]" , "e");
        name = name.replaceAll("[âåàã@]" , "a");
        name = name.replaceAll("[øØð]" , "o");
        name = name.replaceAll("æ" , "ae");
        name = name.replaceAll("[ç©]" , "c");
        name = name.replaceAll("[îïì]" , "i");
        name = name.replaceAll("ñ" , "n");
        name = name.replaceAll("š" , "s");
        name = name.replaceAll("ý" , "y");
        name = name.replaceAll("ù","u");

        return name;
    }

    /**
     * Getter de numero
     * @return
     */
    public int getNum(){
        return numEtape;
    }

    /**
     * Iterrateur pour parcourir toutes les etapes
     * @return
     */
    @Override
    public Iterator<Etape> iterator(){
        return gest_Succ.iterator();
    }

    public int nbSuccesseur(){
       return gest_Succ.nbEtapes();
    }

    /**
     * Fonction qui affiche le numero /nom de l'etape
     * @return
     */
    public  String toString(){
        return "numero :"+getNum()+getNom();
    }

    /**
     * Fonction qui genere le code c
     * @return
     */
    public abstract String toC();

    /**
     * @return gest_Succ
     */
    public GestionnaireSuccesseurs getGestionnaireSuccesseurs() {
        return gest_Succ;

    }

    /**
     *
     * @return Null
     */
    public String getDefineSema(){
        return  null;
    }
/**
 * Getter de nombre de de jetons
 */
    public abstract int getnbJetons();


}

package twisk.monde;

import twisk.outils.FabriqueNumero;
import twisk.simulation.Client;
import twisk.simulation.GestionnaireClients;

import java.util.ArrayList;
import java.util.Iterator;

public class Monde implements Iterable<Etape>{
    /**
     * Les variables
     */
    private GestionnaireEtapes gestEtapes;
    private SasEntree sasE;
    private SasSortie sasS;
    public ArrayList<String> listNom ;

    /**
     * Constructeur du monde
     */
    public Monde(){
        this.gestEtapes =new GestionnaireEtapes();
        this.sasE =new SasEntree();
        this.sasS =new SasSortie();
        this.gestEtapes.ajouter(sasE,sasS);
    }

    /**
     * Fonction qui ajoute les entree
     * @param etapes
     */
    public void aCommeEntree(Etape... etapes){
      this.sasE.ajouterSuccesseur(etapes);
    }
    public void aCommeSortie(Etape... etapes){
        for (Etape e:etapes)
            e.ajouterSuccesseur(sasS);
    }

    /**
     * Fonctions qui ajoutes les etapes
     * @param etapes
     */
    public void ajouter(Etape...etapes){
        this.gestEtapes.ajouter(etapes);
    }

    /**
     * Fonction qui retourne le nombre de d'etapes
     * @return
     */
    public int nbEtapes(){
        return gestEtapes.nbEtapes();
    }

    /**
     * Fonctions qui retourne le nombres de guichet
     * @return
     */
    public int nbGuichet(){
        int i=0;
        for(Etape etape: gestEtapes){
            if(etape.estUnGuichet()){
                i+=1;
            }
        }
        return i;
    }

    /**
     *  Getter de Gestionnaire Etapes
     * @return gestionnaire d'etape du monde
     */
    public GestionnaireEtapes getGestionnaireEtapes() {
        return gestEtapes;
    }

    /**
     * Getter de sas entree
     * @return
     */
    public SasEntree getSasEntree(){
        return sasE;
    }

    /**
     * Getter de sas sortie
     * @return
     */
    public SasSortie getSasSortie(){
        return sasS;
    }

    /**
     * Fonction qui genere le code c
     * @return
     */
    public String toC(){

        StringBuilder s = new StringBuilder();
        s.append("#include <time.h>\n" +
                "#include \"def.h\" \n");
        for (Etape e : gestEtapes) {
            s.append("#define "+e.getNom()+e.getNum()+" "+e.getNum()+"\n");
            if (e.estUnGuichet()){
                s.append(e.getDefineSema()+"\n");
            }
        }
        s.append("\nvoid simulation(int ids){\n");
        s.append(sasE.toC());
        s.append("}");
        return s.toString();
    }

    /**
     * Iterrateur qui parcours toutes les etapes
     * @return
     */
    @Override
    public Iterator<Etape> iterator() {
        return this.gestEtapes.iterator();
    }

    /**
     * Fonction qui affiche  le monde
     * @return
     */
    @Override
    public String toString(){
        return " Le monde: \n"+getGestionnaireEtapes().toString();
    }

    /**
     * Getter de nom d'etape
     * @param i
     * @return le nom de chaque etape
     */
    public String getNomEtape(int i){
        return gestEtapes.getEtapes(i).getNom();
    }

    /**
     * La fonction qui permet de recuperer
     * @param i
     * @return
     */

    public  Etape getEtape(int i){
        return gestEtapes.getEtapes(i);
    }

    /**
     * La fonction qui fais la mise a jour des compteur relier a la librairie de twisk
     */
    public void reset(){
        gestEtapes.reset();
    }

}

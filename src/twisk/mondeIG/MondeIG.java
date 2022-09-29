package twisk.mondeIG;

import twisk.ClientTwisk;
import twisk.exceptions.ExceptionExistArc;
import twisk.exceptions.ExceptionGuichet;
import twisk.exceptions.ExceptionsArcMemeEtape;
import twisk.exceptions.MondeException;
import twisk.monde.*;
import twisk.outils.ClassLoaderPerso;
import twisk.outils.FabriqueIdentifiant;
import twisk.simulation.Client;
import twisk.simulation.GestionnaireClients;
import twisk.vues.Observateur;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;

public class MondeIG extends SujetObserve implements Iterable<EtapeIG> , Observateur {

    public HashMap<String, EtapeIG> getetapes() {
        return etapes;
    }
    private HashMap<String, EtapeIG>etapes=new HashMap<>(10) ;
    private ArrayList<EtapeIG> selectedEtape = new ArrayList<>(10);
    private ArrayList<ArcIG> selectedArc = new ArrayList<>(10);
    private FabriqueIdentifiant fabid=FabriqueIdentifiant.getInstance();
    private ArrayList<ArcIG>arclist=new ArrayList<>(10);
    private ArrayList<EtapeIG>listentree=new ArrayList<>(10);
    private ArrayList<EtapeIG>listsortie=new ArrayList<>(10);
    private PointDeControleIG pointselect;
    private GestionnaireClients gestClients;
    private int nbClients =5;
    private CorrespondanceEtapes correspondanceEtapes ;
    public Object getSimul() {
        return simul;
    }
    private transient Object simul;



    /**
     * Constructeur de MondeIG
     */
    public MondeIG(){

        String identif =fabid.getIdentifiantEtape();
        EtapeIG activ =new ActiviteIG("activite"+identif,identif,60,20);
        etapes.put(identif,activ);
    }

    /**
     * Fonction ajouter qui ajoute les activite au monde
     * @param type
     */
    public  void ajouter(String type){
        if( type.equals("activite")) {
            String identifiant =fabid.getIdentifiantEtape();
            EtapeIG act =new ActiviteIG("activite"+identifiant,identifiant,60,60);
            etapes.put(identifiant,act);
           // this.notifierObservateurs();
        }
            if(type.equals("guichet")){
                String identifiant =fabid.getIdentifiantEtape();
                EtapeIG gui =new GuichetIG("guichet"+identifiant,identifiant,50,100);
                etapes.put(identifiant,gui);
               // this.notifierObservateurs();
        }
        this.notifierObservateurs();
    }


    /**
     * Fonction nbEtape qui rend le numero de l'etape
     * @return
     */
    public int nbEtape(){
        return this.etapes.size();
    }

    /**
     * Fonction ajouter qui permet d’ajouter un arc, créé à partir des deux points de contrôle passés en paramètre
     * @param p1
     * @param p2
     * @throws ExceptionsArcMemeEtape
     */
    public void ajouter(PointDeControleIG p1, PointDeControleIG p2) throws ExceptionsArcMemeEtape,ExceptionExistArc, ExceptionGuichet {
        if(p1.getetape() == p2.getetape()) {
            throw new ExceptionsArcMemeEtape();
        }
        if(p1.getPosX()== p2.getPosX() && p1.getPosY()== p2.getPosY()){
            throw new ExceptionsArcMemeEtape();
        }
        if(p1.getetape().estUnGuichet() && p2.getetape().estUnGuichet()){
            throw new ExceptionGuichet();
        }
       ArcIG monarc = new ArcIG(p1,p2);
        arclist.add(monarc);
    }

    /**
     * Fonction qui permer d'ajouter les arc en deux points de controles
     * @param pt
     * @throws ExceptionsArcMemeEtape ,ExceptionExistArc
     */
    public void formarc(PointDeControleIG pt) throws ExceptionsArcMemeEtape, ExceptionExistArc,ExceptionGuichet {
        if (pointselect == null) {
            pointselect = pt;
        } else{
            this.ajouter(pointselect, pt);
            this.notifierObservateurs();
            pointselect  = null;
    }
    }

    /**
     * Iterrateur de etape qui permet de parcourrir toutes les etapes
     * @return
     */
    @Override
    public Iterator<EtapeIG> iterator() {
        return etapes.values().iterator();
    }

    /**
     * Iterrateur de arc qui permet de parcourrir tous les arcs
     * @return
     */
    public Iterator<ArcIG> iteratorarc() {
        return arclist.iterator();
    }

    /**
     * la fonction qui permet de renommer une etape
     * @param str
     */
    public  void renommerlaselection(String str){
      selectedEtape.get(0).setNom(str);
    }

    /**
     * La fonction qui permet d'ajouter une etape
     * @param etp
     */
   public void Ajouteretp(EtapeIG etp){
       if(!selectedEtape.contains(etp)){
           selectedEtape.add(etp);
           etp.setSelectionner(true);
       }else{
           etp.setSelectionner(false);
           selectedEtape.remove(etp);
       }
   }

    /**
     * La fonction qui permet d'ajouter un arc entre deux etapes
     * @param arc
     */
    public void AjouterArc(ArcIG arc){
        if(!selectedArc.contains(arc)){
            selectedArc.add(arc);
            arc.setSelectionnerarc(true);
        }else{
            arc.setSelectionnerarc(false);
            selectedArc.remove(arc);
        }
    }

    /**
     * La fonction qui permet d'jouter une entrée
     */
    public void AjouterEntree(){
        for (EtapeIG step : selectedEtape ) {
            if(listentree.contains(step)==true) {
                listentree.remove(step);
            }else{
                step.setEntree(true);
                step.setSelectionner(false);
                this.listentree.add(step);
            }
        }
    }

    /**
     * Fonction qui retourne le temps changer
     * @param delai
     */
    public void Delai(int delai) {
        this.selectedEtape.get(0).setDelai(delai);
    }

    public void setNbJetons(Integer nb) {
        this.selectedEtape.get(0).setNbJeton(nb);
    }
    /**
     * Fonction qui retourne l 'escart temps changé
     * @param ecartt
     */
    public void EcartTemps(int ecartt) {
        this.selectedEtape.get(0).setEcartTemps(ecartt);

    }
    /**
     * Fonction qui ajoute La sortie
     */
    public void AjouterSortie(){
        for (EtapeIG step : selectedEtape ) {
            if(listsortie.contains(step)==true) {
                listsortie.remove(step);
            }else{
                step.setSortie(true);
                step.setSelectionner(false);
                this.listsortie.add(step);
            }
        }
    }

    /**
     * Fonction qui supprime la selection
     */
   public void SuppSelect() {
       for (EtapeIG step : selectedEtape) {
           step.setSelectionner(false);
       }
       selectedEtape.clear();
   }
    /**
     * Fonction qui supprime l'activité selectionnée
     */
    public void SuppEtape() {
        Iterator<EtapeIG> iterstep = iterator();
        Iterator<ArcIG> iterarc = iteratorarc();
        while (iterstep.hasNext()) {
            EtapeIG et = iterstep.next();

            if (et.getselectionner()) {
                for (EtapeIG e: getetapes().values())
                    e.getSuccesseur().remove(et);
                listentree.remove(et);
                listsortie.remove(et);
                iterstep.remove();
            }
        }
        while (iterarc.hasNext()) {
            ArcIG bow = iterarc.next();
            if ( bow.getpos(1).getetape().getselectionner() || bow.getpos(0).getetape().getselectionner()) {
                iterarc.remove();
            }
        }
        notifierObservateurs();

    }
    /**
     * Fonction qui supprime l'arc selectionné
     */
    public void SuppArc() {
        for (ArcIG arc : selectedArc ) {
            arclist.remove(arc);
        }
    }

    /**
     * La fonction qui permet de lancer  la simulation
     * @throws MondeException
     */
    public void simuler() throws MondeException {
        verifierMondeIG();
        Monde m = creerMonde();
        try {
            ClassLoaderPerso ClassLoader = new ClassLoaderPerso(ClientTwisk.class.getClassLoader());
            Class<?> simul = ClassLoader.loadClass("twisk.simulation.Simulation");
            Object objSimulation = simul.getDeclaredConstructor().newInstance();
            Method setNbClients = simul.getDeclaredMethod("setNbClients", int.class);
            Method sim = simul.getDeclaredMethod("simuler", Monde.class);
            setNbClients.invoke(objSimulation, 4);
            sim.invoke(objSimulation, m);
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println("\n************* FIN *************\n\n");
        notifierObservateurs();
    }

    /**
     * La fonction qui permet de vérifier si le monde créé est correcte
     * @throws MondeException
     */
    private void verifierMondeIG() throws MondeException {
        if(listentree.size()<=0 || listsortie.size()<=0 || etapes.size()<=0){
            throw new MondeException() ;
        }
        for(EtapeIG e : etapes.values()){
            for (EtapeIG etp : e.getSuccesseur()){
                if(etp.estUneActivite() && e.estUnGuichet()){
                    throw new MondeException();
                }
                if(e.estUneActivite()||e.estUneActiviteRestreinte() && etp.estUneActiviteRestreinte()){
                    throw new MondeException();
                }
                if(e.getSuccesseur().size()<=0){
                    throw new MondeException();
                }
                if(e.estUnGuichet() && e.getSuccesseur().size()>=0){
                    throw new MondeException();
                }
                if(etp.estUneActivite() && etp.estUnGuichet()){
                    ((ActiviteIG )etp).estUneActiviteRestreinte();
                }

            }
        }

    }

    /**
     * La fonction qui permet de cree le monde
     * @return
     */
    private Monde creerMonde(){
        correspondanceEtapes = new CorrespondanceEtapes();
        Monde m = new Monde();
        for (EtapeIG e : etapes.values()){
            if(e.estUneActiviteRestreinte()){
                Etape etp = new ActiviteRestreinte(e.getNom(), ((ActiviteIG) e).getTemps(), ((ActiviteIG) e).getEcartTemps());
                m.ajouter(etp);
                correspondanceEtapes.ajouter(e,etp);
            } else if(e.estUneActivite()){
                Etape ac = new Activite(e.getNom(), ((ActiviteIG) e).getTemps(), ((ActiviteIG) e).getEcartTemps());
                m.ajouter(ac);
                correspondanceEtapes.ajouter(e,ac);
            }else{
                Etape g = new Guichet(e.getNom(), ((GuichetIG) e).getNbjetons());
                m.ajouter(g);
                correspondanceEtapes.ajouter(e,g);

            }
        }
        for(EtapeIG in : listentree){
            m.aCommeEntree(correspondanceEtapes.get(in));
        }
        for(EtapeIG out : listsortie){
            m.aCommeSortie(correspondanceEtapes.get(out));
        }
        for(EtapeIG e: etapes.values()){
            for(EtapeIG etp : e.getSuccesseur()){
                correspondanceEtapes.get(e).ajouterSuccesseur(correspondanceEtapes.get(etp));
            }
        }
        return m ;
    }

    /**
     * getter des clients
     * @return
     */
    public int getNbClients() {
        return nbClients;
    }

    /**
     * getter de la correspondance
     * @return
     */
    public CorrespondanceEtapes getcorrespondance(){
        return correspondanceEtapes;
}

public boolean lasimulationacommencer(){
        boolean result =false;
        try {
            Method fct = simul.getClass().getDeclaredMethod("debutdesimulation");
            result = (boolean) fct.invoke(simul);
        }catch(IllegalAccessException | InvocationTargetException |NoSuchMethodException e){
            e.printStackTrace();
            }
         return result;
        }


    /**
     * LA fonction qui fais reagir le monde ig
     */
    @Override
    public void reagir() {
   notifierObservateurs();
    }

    public ArrayList<Client> getClient() {
        GestionnaireClients gest =null;
        try {
            Method met = simul.getClass().getDeclaredMethod("get");
            gest = (GestionnaireClients) met.invoke(simul);
       } catch ( IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
        e.printStackTrace();
       }
        return Objects.requireNonNull(gest).getLClients();
    }
    public Iterator<Client> iteratorClients(){
        if(gestClients == null)
            return null;
        else{
            return gestClients.iterator();
        }
    }

}

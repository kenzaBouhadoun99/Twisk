package twisk.vues;

import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import twisk.ecouteurs.EcouteurDragDessin;
import twisk.ecouteurs.EcouteurDrapOver;
import twisk.mondeIG.*;
import twisk.simulation.Client;
import java.util.Iterator;

public class VueMondeIG extends Pane implements Observateur {
    private  MondeIG Monde;
    private  EtapeIG etg;


    /**
     * Constructeur de MondeIG
     * @param monde
     */
    public VueMondeIG(MondeIG monde) {
        this.Monde = monde;
        for (EtapeIG etape : Monde) {
            if (etape.estUneActivite()) {
                VueEtapeIG vue = new VueActiviteIG(Monde, etape);
                this.getChildren().add(vue);
            }
            else {
                VueEtapeIG vue1 = new VueGuichetIG(Monde, etape);
                this.getChildren().add(vue1);
            }
            for(PointDeControleIG ptc : etape){
                VuePointDeControleIG point=new VuePointDeControleIG(Monde,ptc,etape);
                this.getChildren().add(point);
            }
        }
        this.setOnDragDropped(new EcouteurDragDessin(this.Monde,this));
        this.setOnDragOver(new EcouteurDrapOver());
        this.Monde.ajouterObservateur(this);
    }
    /* for (Client clt : Monde.getClient()) {
           if (Monde.getcorrespondance().get(step).equals(clt.getEtape())) {
               VueBouleIG v = new VueBouleIG(clt);
               h.getChildren().add(v);
           }
       }
       }*/
    public void addClientActivite(EtapeIG step, HBox h){
       if(Monde.getSimul() != null){
           if(Monde.lasimulationacommencer()){
               for (Client clt : Monde.getClient()) {
                   if (Monde.getcorrespondance().get(step).equals(clt.getEtape())) {
                       VueBouleIG v = new VueBouleIG(clt);
                       h.getChildren().add(v);
                   }
               }
           }
       }
    }

    /**
     * Fonction reagir de MondeIG
     */
    @Override
    public void reagir() {
        this.getChildren().clear();
        Iterator<ArcIG> arcIGIterator = this.Monde.iteratorarc();
        while (arcIGIterator.hasNext()) { 
            VueArcIG arcig = new VueArcIG(arcIGIterator.next(), Monde);
            this.getChildren().add(arcig);
        }
        for (EtapeIG etape : Monde) {
            if (etape.estUneActivite()) {
                VueEtapeIG vue = new VueActiviteIG(Monde, etape);
               // addClientActivite(etape, ((VueActiviteIG) vue).getHbox());

                this.getChildren().add(vue);
            }
            else {
                VueEtapeIG vue1 = new VueGuichetIG(Monde, etape);
             //   addClientActivite(etape, ((VueActiviteIG) vue1).getHbox());
                this.getChildren().add(vue1);
            }
            for(PointDeControleIG ptc : etape){
                VuePointDeControleIG point=new VuePointDeControleIG(Monde,ptc,etape);
                this.getChildren().add(point);
            }
        }
    }
}


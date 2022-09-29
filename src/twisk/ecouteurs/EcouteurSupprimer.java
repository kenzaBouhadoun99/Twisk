package twisk.ecouteurs;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import twisk.mondeIG.MondeIG;


public class EcouteurSupprimer implements EventHandler<ActionEvent> {
    private MondeIG m;

    /**
     * Ecouteur de la suppression
     * @param monde
     */
    public EcouteurSupprimer(MondeIG monde){
        this.m=monde;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        m.SuppEtape();
        m.SuppArc();
        m.notifierObservateurs();
    }
}

package twisk.ecouteurs;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import twisk.mondeIG.MondeIG;

public class EcouteurDesselectionner implements  EventHandler<ActionEvent> {
    private MondeIG monde;


    /**
     * Constructeur de EcouteurSupprimer
     */
    public EcouteurDesselectionner(MondeIG  monde){
        this.monde = monde;
    }

    /**
     * fonction qui fais reagir la selection
     * @param actionEvent
     */
    @Override
    public void handle(ActionEvent actionEvent) {
        monde.SuppSelect();
        monde.notifierObservateurs();
    }

}
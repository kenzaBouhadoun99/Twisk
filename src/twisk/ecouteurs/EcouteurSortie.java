package twisk.ecouteurs;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import twisk.mondeIG.MondeIG;


public class EcouteurSortie implements EventHandler<ActionEvent> {
    private MondeIG monde;

    /**
     * Ecouteur de la sortie
     * @param monde
     */
    public EcouteurSortie(MondeIG monde){
        this.monde=monde;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.monde.AjouterSortie();
        this.monde.notifierObservateurs();
    }
}

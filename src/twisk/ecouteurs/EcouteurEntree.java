package twisk.ecouteurs;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import twisk.mondeIG.MondeIG;

public class EcouteurEntree implements EventHandler<ActionEvent> {
    private MondeIG monde;

    /**
     * Ecouteur de la rentrer
     * @param monde
     */
    public EcouteurEntree(MondeIG monde){
        this.monde=monde;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
            this.monde.AjouterEntree();
            this.monde.notifierObservateurs();
    }
}

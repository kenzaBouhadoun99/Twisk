package twisk.ecouteurs;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import twisk.mondeIG.MondeIG;

public class EcouteurBouton implements EventHandler<ActionEvent> {

    private MondeIG monde;
    private String type;

    /**
     * Ecouteur de Bouton
     * @param monde
     */
    public EcouteurBouton(MondeIG monde,String type){
      this.monde=monde;
      this.type=type;

    }

    /**
     * @param actionEvent
     */
    @Override
    public void handle(ActionEvent actionEvent) {
            monde.ajouter(type);
            monde.notifierObservateurs();
    }

}


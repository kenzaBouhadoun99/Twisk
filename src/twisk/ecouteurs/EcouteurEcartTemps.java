package twisk.ecouteurs;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextInputDialog;
import twisk.mondeIG.MondeIG;

import java.util.Optional;

/**
 * EcouteurEcartTemps
 */
public class EcouteurEcartTemps implements EventHandler<ActionEvent> {

    private MondeIG monde;
    public EcouteurEcartTemps(MondeIG monde){
        this.monde=monde;
    }

    /**
     *
     * @param actionEvent
     */
    @Override
    public void handle(ActionEvent actionEvent) {
        TextInputDialog tp = new TextInputDialog("");
        tp.setContentText("Inserez un ecart temps : ");
        tp.setHeaderText("Donnez un ecart temps a l'activitée");
        tp.setTitle("Le l'ecart temps");
        Optional<String> affichage = tp.showAndWait();
        affichage.ifPresent(nometp -> {monde.EcartTemps(Integer.parseInt(nometp)); ;});
        monde.notifierObservateurs();
    }
}
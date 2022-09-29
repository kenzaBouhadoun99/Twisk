package twisk.ecouteurs;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextInputDialog;
import twisk.mondeIG.MondeIG;
import java.util.Optional;

/**
 * EcouteurTemps
 */
public class EcouteurTemps implements EventHandler<ActionEvent> {
    private MondeIG m;

    /**
     * ecouteur du temps
     * @param monde
     */
    public EcouteurTemps(MondeIG monde){
        this.m=monde;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        TextInputDialog tp = new TextInputDialog("");
        tp.setContentText("Inserez un temps : ");
        tp.setHeaderText("Donnez un temps a l'activitée");
        tp.setTitle("Le temps");
        Optional<String> affichage = tp.showAndWait();
        affichage.ifPresent(nometp -> {m.Delai(Integer.parseInt(nometp)) ;});
        m.notifierObservateurs();
    }
}
package twisk.ecouteurs;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextInputDialog;
import twisk.mondeIG.MondeIG;

import java.util.Optional;

public class EcouteurNbJetons implements EventHandler<ActionEvent> {
    MondeIG m;

    public EcouteurNbJetons(MondeIG monde) {
        this.m = monde;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        TextInputDialog tp = new TextInputDialog("");
        tp.setContentText("Inserez un nombre de jetons : ");
        tp.setHeaderText("Donnez un nombre de jeton ");
        tp.setTitle("Le Nombre de jetons");
        Optional<String> affichage = tp.showAndWait();
        affichage.ifPresent(nometp -> {m.setNbJetons(Integer.parseInt(nometp));});
        m.notifierObservateurs();


    }
}

package twisk.ecouteurs;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextInputDialog;
import twisk.mondeIG.MondeIG;

import java.util.Optional;

public class EcouteurRenommer implements EventHandler<ActionEvent> {
    private MondeIG m;

    /**
     * Constructeur Ecouteur renommer
     * @param monde
     */
    public EcouteurRenommer(MondeIG monde){
        this.m=monde;

    }
    @Override
    public void handle(ActionEvent actionEvent) {
        TextInputDialog nom = new TextInputDialog("");
        nom.setContentText("Inserer le nouveau nom : ");
        nom.setHeaderText("Renommer l'activitée");
        nom.setTitle("renommer");
        Optional<String> affichage = nom.showAndWait();
        affichage.ifPresent(nometp -> {m.renommerlaselection(nometp) ;});
        m.notifierObservateurs();
    }
}

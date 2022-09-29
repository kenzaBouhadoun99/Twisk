package twisk.ecouteurs;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.util.Duration;
import twisk.exceptions.MondeException;
import twisk.mondeIG.MondeIG;


public class EcouteurSimulation implements EventHandler<ActionEvent> {

    private MondeIG m ;

    /**
     * Ecouteur de simulation
     * @param monde
     */
    public EcouteurSimulation(MondeIG monde){
        this.m = monde;
    }
    @Override
    public void handle(ActionEvent actionEvent) {


        try {
            m.simuler();
            m.notifierObservateurs();
        } catch (MondeException e) {
            Alert erreur  = new Alert(Alert.AlertType.ERROR);
            erreur.setTitle("Authentification Erreur");
            erreur.setContentText(e.getMessage());
            erreur.show();
            PauseTransition pause = new PauseTransition(Duration.seconds(5));
            pause.setOnFinished(event -> erreur.close() );
            pause.play();
        }

    }
}

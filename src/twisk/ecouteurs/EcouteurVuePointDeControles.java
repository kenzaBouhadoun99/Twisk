package twisk.ecouteurs;

import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import twisk.exceptions.ExceptionExistArc;
import twisk.exceptions.ExceptionGuichet;
import twisk.exceptions.ExceptionsArcMemeEtape;
import twisk.mondeIG.MondeIG;
import twisk.mondeIG.PointDeControleIG;

public class EcouteurVuePointDeControles implements EventHandler<MouseEvent> {
    private MondeIG monde;
    private PointDeControleIG pointDeControle;

    /**
     * Ecouteur de VuePointDeControles
     * @param md
     * @param pt
     */
    public EcouteurVuePointDeControles(MondeIG md, PointDeControleIG pt){
        this.monde=md;
        this.pointDeControle=pt;
    }

    /**
     * @param mousesnvent
     */
    @Override
    public void handle(MouseEvent mousesnvent ) {
        try {
            monde.formarc(pointDeControle);
        } catch (ExceptionsArcMemeEtape | ExceptionExistArc | ExceptionGuichet e  ) {
            Alert erreur  = new Alert(Alert.AlertType.ERROR);
            erreur.setTitle("Authentification Erreur");
            erreur.setContentText(e.getMessage());
            //erreur.setContentText(new ExceptionsArcMemeEtape().getMessage());
            erreur.show();
            PauseTransition pause = new PauseTransition(Duration.seconds(5));
            pause.setOnFinished(event -> erreur.close() );
            pause.play();
            e.printStackTrace();
        }
    }
}

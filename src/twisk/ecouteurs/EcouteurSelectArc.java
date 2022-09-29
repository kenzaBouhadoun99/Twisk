package twisk.ecouteurs;


import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import twisk.mondeIG.MondeIG;
import twisk.vues.VueArcIG;
import twisk.vues.VueEtapeIG;

import java.util.ArrayList;

public class EcouteurSelectArc implements EventHandler<MouseEvent> {

    private MondeIG monde;
    private VueArcIG vuearc;

    /**
     * Constructeur de EcouteurSelect
     * @param
     */
    public EcouteurSelectArc(VueArcIG vue,MondeIG m) {
        this.monde = m;
        this.vuearc = vue;
    }

    /**
     *
     * @param mouseevent
     */
    @Override
    public void handle(MouseEvent mouseevent) {
       if (mouseevent.getClickCount() == 1) {
            this.monde.AjouterArc(this.vuearc.getArc());
        }
        this.monde.notifierObservateurs();
    }
}
package twisk.ecouteurs;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import twisk.mondeIG.ArcIG;
import twisk.mondeIG.MondeIG;

public class EcouteurArcIg implements EventHandler<MouseEvent> {
    private MondeIG m;
    private ArcIG arc;

    /**
     * Ecouteur de ArcIg
     * @param monde
     * @param arcIG
     */
    public EcouteurArcIg(MondeIG monde , ArcIG arcIG) {
        this.m = monde;
        this.arc = arcIG;
    }

    /**
     * @param MouseEvent
     */
    @Override
    public void handle(MouseEvent MouseEvent) {
        m.notifierObservateurs();


    }
}
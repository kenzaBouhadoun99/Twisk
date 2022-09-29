package twisk.ecouteurs;

import javafx.event.EventHandler;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import twisk.mondeIG.MondeIG;
import twisk.vues.VueEtapeIG;
import twisk.vues.VueMondeIG;

public class EcouteurDragDessin  implements EventHandler<DragEvent> {
    private MondeIG monde;
    private VueMondeIG vuem;

    /**
     * Ecouteur de dragdessin
     * @param monde
     * @param vue
     */
    public EcouteurDragDessin(MondeIG monde , VueMondeIG vue){
        this.monde = monde;
        this.vuem = vue;
    }
    @Override
    public void handle(DragEvent dragEvent) {
        Dragboard drag = dragEvent.getDragboard();
        boolean result = false;
        if (drag.hasString()) {
            String nodeId = drag.getString();
            VueEtapeIG vueEtape = (VueEtapeIG) vuem.lookup("#" + nodeId);
            if (vueEtape != null) {
                vueEtape.getEtig().setPosX((int) dragEvent.getX());
                vueEtape.getEtig().setPosY((int) dragEvent.getY());
                vueEtape.relocate((int) dragEvent.getX(), (int) dragEvent.getY());
                result = true;
                vueEtape.getEtig().pointcontrole();
            }
        }
        dragEvent.setDropCompleted(result);
        monde.notifierObservateurs();
        dragEvent.consume();
}
}

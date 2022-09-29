package twisk.ecouteurs;

import javafx.event.EventHandler;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.WritableImage;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import twisk.vues.VueEtapeIG;

public class EcouteurDragDepart implements EventHandler<MouseEvent> {
    private VueEtapeIG vue;

    /**
     * Constructeur de DragDepart
     * @param e
     */
    public EcouteurDragDepart(VueEtapeIG e){
        this.vue=e;
    }
    @Override
    public void handle(MouseEvent mEvent) {
        Dragboard dragb = vue.startDragAndDrop(TransferMode.MOVE);
        ClipboardContent clc = new ClipboardContent();
        clc.putString(vue.getId());
        dragb.setContent(clc);
        WritableImage snapshot = vue.snapshot(new SnapshotParameters(), null);
        dragb.setDragView(snapshot);
        mEvent.consume();
    }
}

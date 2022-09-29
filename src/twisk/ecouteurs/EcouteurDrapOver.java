package twisk.ecouteurs;

import javafx.event.EventHandler;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;

public class EcouteurDrapOver implements EventHandler<DragEvent> {

    @Override
    public void handle(DragEvent dragev) {
        if (dragev.getDragboard().hasString()) {
            dragev.acceptTransferModes(TransferMode.MOVE);
        }
        dragev.consume();
    }
}

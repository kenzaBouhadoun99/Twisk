package twisk.vues;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;


public class VueActiviteIG extends VueEtapeIG implements Observateur {
    private HBox hbox;
    /**
     * constructeur de VueActiviteIG
     * @param monde
     * @param etape
     */
    public VueActiviteIG(MondeIG monde, EtapeIG etape) {
        super(monde, etape);
        hbox = new HBox();
        hbox.setPrefHeight(37);
        hbox.setPrefWidth(60);
        this.setPadding(new Insets(10,7,7,8));
        this.setAlignment(Pos.CENTER);
        hbox.setStyle("-fx-border-color: blue; -fx-background-insets: 0 0 -1 0, 0, 1, 2;-fx-alignment:center; -fx-background-radius: 3px, 3px, 2px, 1px; -fx-background-color: #9f9f9f");
        this.getChildren().addAll(hbox);
    }
public HBox getHbox(){
        return hbox;
}
    /**
     * La fonction reagir
     */
    @Override
    public void reagir() {

    }
}

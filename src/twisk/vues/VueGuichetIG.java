package twisk.vues;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;


public class VueGuichetIG extends VueEtapeIG implements Observateur {
    /**
     * constructeur de VueActiviteIG
     * @param monde
     * @param etape
     */
    public VueGuichetIG(MondeIG monde, EtapeIG etape) {
        super(monde, etape);
        HBox box =new HBox();
        for(int i = 0; i < 8; i++){
            HBox box1 =new HBox();
            box1.setPadding(new Insets(15,15,15,15));
            this.setPadding(new Insets(5,5,5,5));
            box1.setStyle("-fx-border-color: blue; -fx-background-insets: 0 0 -1 0, 0, 1, 2; -fx-background-radius: 3px, 3px, 2px, 1px; -fx-background-color: #9f9f9f");
            box.getChildren().addAll(box1);
        }
        this.setAlignment(Pos.CENTER);
        this.getChildren().addAll(box);
    }


    /**
     * La fonction reagir
     */
    @Override
    public void reagir() {

    }
}

package twisk.vues;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import twisk.ecouteurs.EcouteurVuePointDeControles;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;
import twisk.mondeIG.PointDeControleIG;

public class VuePointDeControleIG extends Circle implements Observateur {

    /**
     * ConstructeurvuePointDeControleIG
     * @param monde
     * @param pt
     * @param etape
     */
    public VuePointDeControleIG(MondeIG monde, PointDeControleIG pt, EtapeIG etape){
        this.setCenterX(pt.getPosX());
        this.setCenterY(pt.getPosY());
        this.setRadius(3);
        this.setFill(Color.PURPLE);
        this.setOnMouseClicked(new EcouteurVuePointDeControles(monde,pt));
    }

    /**
     * Fonction reagir
     */
    @Override
    public void reagir() {
    }
}

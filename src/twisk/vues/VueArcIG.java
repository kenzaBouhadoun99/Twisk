package twisk.vues;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import twisk.ecouteurs.EcouteurArcIg;
import twisk.ecouteurs.EcouteurSelectArc;
import twisk.mondeIG.ArcIG;
import twisk.mondeIG.MondeIG;


public class VueArcIG extends Pane implements Observateur {
    private MondeIG monde;
    private ArcIG arc;
    /**
     * Constructeur VueArc
     * @param arc
     * @param monde
     */
    public VueArcIG(ArcIG arc, MondeIG monde){
        this.monde = monde;
        this.arc = arc;
        Line lig =new Line();
        lig.setStrokeWidth(2.5);
        lig.setStyle("-fx-stroke: purple");
        lig.setOnMouseClicked(new EcouteurArcIg(monde,arc));
        lig.setOnMouseClicked(new EcouteurSelectArc(this,monde));

        double posX1= arc.getpos(0).getPosX();
        double posY1= arc.getpos(0).getPosY();
        double posX2= arc.getpos(1).getPosX();
        double posY2= arc.getpos(1).getPosY();
        lig.setStartX(posX1);
        lig.setStartY(posY1);
        lig.setEndX(posX2);
        lig.setEndY(posY2);

        //Pour la fleche
        Polyline fleche = new Polyline();
        fleche.getPoints().addAll(
                posX2, posY2,
                posX2+16.0, posY2+5.0,
                posX2+16.0, posY2-5.0,
                posX2,posY2);
        this.setPickOnBounds(false);
        fleche.setStyle("-fx-stroke: purple");
        this.getChildren().addAll(lig, fleche);
        if(this.arc.isSelectionnerarc()){
            lig.setStyle("-fx-stroke: red");
            fleche.setStyle("-fx-stroke: red");
        }
    }
    public ArcIG getArc(){
        return  arc;
    }

    /**
     * Fonction reagir
     */
    @Override
    public void reagir() {

    }
}

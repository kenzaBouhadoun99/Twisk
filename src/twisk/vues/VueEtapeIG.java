package twisk.vues;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import twisk.ecouteurs.*;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;

import java.util.Objects;
import java.util.Optional;

public abstract class VueEtapeIG extends VBox implements Observateur {
    protected MondeIG monde;
    protected EtapeIG etig;
    protected Label lb;

    /**
     * Conctructeur vueEtapeIG
     * @param monde
     * @param etape
     */
    public VueEtapeIG(MondeIG monde, EtapeIG etape) {
        this.monde = monde;
        this.etig = etape;
        if (etape.estUneActivite()) {
            this.etig = etape;
            this.setId(etig.getIdentiant());
            lb = new Label(etape.getNom() + " : " + etig.getTemps() + " ± " + etig.getEcartTemps() + " temps");
            lb.setPrefSize(160, 35);
            lb.setStyle("-fx-alignment:center ;-fx-text-fill: blue");
            this.setStyle("-fx-border-color: #696969;-fx-background-insets: 0 0 -1 0, 0, 1, 2;-fx-background-insets:6; -fx-border-radius:7;-fx-background-radius: 3px, 3px, 2px, 1px");
            this.setOnMouseClicked(new EcouteurSelectEtape(this, monde));
            this.setOnDragDetected(new EcouteurDragDepart(this));
            this.relocate(etape.getPosX(),etape.getPosY());
            this.setPrefSize(etape.getlargeur(),etape.gethauteur());
            this.getChildren().addAll(lb);
            if (this.etig.isSelectionner()) {
                this.setStyle("-fx-border-color: #BABABA;-fx-background-color: #83A697;-fx-background-insets: 0 0 -1 0, 0, 1, 2;-fx-background-insets:6; -fx-border-radius:7;-fx-background-radius: 3px, 3px, 2px, 1px");
            }
        } else {
            this.etig = etape;
            this.setId(etig.getIdentiant());
            lb = new Label(etape.getNom() + " : "  + etig.getNbjetons() + " jetons");
            lb.setPrefSize(150, 2);
            lb.setStyle("-fx-alignment:center ;-fx-text-fill: blue");
            this.setStyle("-fx-border-color: #696969;-fx-background-insets: 0 0 -1 0, 0, 1, 2;-fx-background-insets:6; -fx-border-radius:7;-fx-background-radius: 3px, 3px, 2px, 1px");
            this.setOnMouseClicked(new EcouteurSelectEtape(this, monde));
            this.setOnDragDetected(new EcouteurDragDepart(this));
            this.relocate(etape.getPosX(),etape.getPosY());
            this.setPrefSize(etape.getlargeur(),etape.gethauteur());
            this.getChildren().addAll(lb);
            if (this.etig.isSelectionner()) {
                this.setStyle("-fx-border-color: #BABABA;-fx-background-color: #83A697;-fx-background-insets: 0 0 -1 0, 0, 1, 2;-fx-background-insets:6; -fx-border-radius:7;-fx-background-radius: 3px, 3px, 2px, 1px");
            }
        }
        entrer_sortie();
    }

    /**
     * la fonction qui fais le style aux entrées et sorties
     */
    public void entrer_sortie() {
        HBox logo = new HBox();

        if ( this.etig.isEntree()) {
            Label entree = new Label("");
            entree.setGraphic(new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/entree.png")))));
            entree.setPadding(new Insets(0,5,0,0));
            logo.getChildren().add(entree);
        }else {
            if ( this.etig.isSortie() && etig.estUneActivite()) {
                Label sortie = new Label("");
                sortie.setGraphic(new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/sortie.png")))));
                this.setAlignment(Pos.TOP_RIGHT);
                logo.getChildren().add(sortie);
            }
            else {
                if (etig.isEntree() && etig.isSortie() && etig.estUneActivite()) {
                    Label sortie = new Label("");
                    Label entree = new Label("");
                    sortie.setGraphic(new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/sortie.png")))));
                    entree.setGraphic(new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/entree.png")))));
                    sortie.setAlignment(Pos.TOP_RIGHT);
                    entree.setPadding(new Insets(5, 5, 5, 5));
                    logo.getChildren().addAll(entree, sortie);
                }
            }
        }
        logo.setAlignment(Pos.TOP_RIGHT);
        logo.setPadding(new Insets(1,1,1,1));
        this.getChildren().add(logo);
    }
    public EtapeIG getEtig(){
        return  etig;
    }
}


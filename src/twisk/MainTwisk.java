package twisk;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import twisk.mondeIG.MondeIG;
import twisk.vues.VueMenu;
import twisk.vues.VueMondeIG;
import twisk.vues.VueOutils;

/*
TO DO
Tooltip
 */
public class MainTwisk extends Application{
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Twisk");
        MondeIG monde = new MondeIG();
        VueMondeIG vuemondeig= new VueMondeIG(monde);
        VueOutils vueoutils = new VueOutils(monde);
        VueMenu monmenu = new VueMenu((monde));
        BorderPane root = new BorderPane();
        root.setCenter(vuemondeig);
        root.setBottom(vueoutils);
        root.setTop(monmenu);
        stage.setScene(new Scene(root,650,550));
        stage.show();
    }
    public void stop(){
        System.exit(0);
    }
    public static void main(String[] args) {
        launch();
    }

}
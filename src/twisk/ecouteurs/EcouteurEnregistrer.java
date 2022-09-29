package twisk.ecouteurs;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextInputDialog;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import twisk.mondeIG.MondeIG;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class EcouteurEnregistrer implements EventHandler<ActionEvent> {

    public EcouteurEnregistrer(){

    }
    @Override
    public void handle(ActionEvent actionEvent) {
        FileChooser file = new FileChooser();
        file.setTitle("Enregistrer");
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Twisk files (*.twisk)", "*.json");
        file.getExtensionFilters().add(extFilter);
       File filee = file.showSaveDialog(new Stage());
        if (filee != null) {
            try {
                FileOutputStream fos = new FileOutputStream(filee.getPath());
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }


    }
}

package twisk.vues;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import twisk.simulation.Client;

public class VueBouleIG extends Circle implements Observateur {
    private Client client;

    /**
     * Constructeur de vueclient
     * @param clients
     */
 public VueBouleIG(Client clients) {
     this.client = clients;
     Circle cercle = new Circle();
     cercle.setRadius(4);

     if (client.getNumClient() %9 == 1) {
         this.setFill(Color.RED);
     }
     if (client.getNumClient() %9 == 2) {
         this.setFill(Color.GRAY);
     }
     if (client.getNumClient() %9 == 3) {
         this.setFill(Color.GREEN);
     }
     if (client.getNumClient() %9 == 4) {
         this.setFill(Color.YELLOW);
     }
     if (client.getNumClient() %9 == 5) {
         this.setFill(Color.PURPLE);
     }
     if (client.getNumClient() %9 == 6) {
         this.setFill(Color.BROWN);
     }
     if (client.getNumClient() %9 == 7) {
         this.setFill(Color.BLUE);
     }
     if (client.getNumClient() %9 == 8) {
         this.setFill(Color.BLACK);
     }
     if (client.getNumClient()%9  == 9) {
         this.setFill(Color.PINK);
     }}


    @Override
    public void reagir() {

    }
}

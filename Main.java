import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Enumeration;

public class Main extends Application {
    public static void main(String[] args){launch(args);}

    @Override
    public void start(Stage stage) {

        stage.setWidth(800);
        stage.setHeight(400);

        Text textJour = new Text("Jour");
        textJour.setX(160);
        textJour.setY(210);
        textJour.setStrokeWidth(3);

        Rectangle baseMaison = new Rectangle(150,190,125,75);
        baseMaison.setFill(Color.BEIGE);
        DropShadow dsMaison= new DropShadow(20,-10,10,Color.GRAY);
        baseMaison.setEffect(dsMaison);

        Rectangle jour = new Rectangle(0,0,400,400);
        jour.setFill(Color.LIGHTGREY);

        Rectangle nuit = new Rectangle(400,0,400,400);

        Group root = new Group(jour,nuit,textJour,baseMaison);

       stage.setScene(new Scene(root));
       stage.show();
    }

}

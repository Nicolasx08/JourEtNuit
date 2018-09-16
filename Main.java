import com.sun.glass.ui.CommonDialogs;
import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.w3c.dom.css.Rect;

import javax.sound.sampled.LineEvent;
import java.util.Enumeration;

public class Main extends Application {
    public static void main(String[] args){launch(args);}

    @Override
    public void start(Stage stage) {

        stage.setWidth(800);
        stage.setHeight(400);

        Text textJour = new Text("Jour");
        textJour.setTranslateX(200);
        textJour.setTranslateY(320);
        textJour.setScaleX(4);
        textJour.setScaleY(4);
        textJour.setFill(Color.BLACK);

        Text textNuit = new Text("Nuit");
        textNuit.setTranslateX(600);
        textNuit.setTranslateY(320);
        textNuit.setScaleY(4);
        textNuit.setScaleX(4);
        textNuit.setFill(Color.WHITE);

        Rectangle baseMaison = new Rectangle(150,190,125,75);
        baseMaison.setFill(Color.BEIGE);
        DropShadow dsMaison= new DropShadow(20,-10,10,Color.GRAY);
        baseMaison.setEffect(dsMaison);

        Rectangle baseMaisonNuit = new Rectangle(550,190,125,75);
        baseMaisonNuit.setFill(Color.BEIGE);

        Rectangle jour = new Rectangle(0,0,400,400);
        jour.setFill(Color.LIGHTGREY);

        Rectangle nuit = new Rectangle(400,0,400,400);

        Polygon toitJour= new Polygon(145,190,280,190,213,150);
        toitJour.setFill(Color.RED);

        Polygon toitNuit = new Polygon(545,190,680,190,613,150);
        toitNuit.setFill(Color.RED);

        Rectangle porteJour = new Rectangle(165,230,20,35);
        porteJour.setFill(Color.BROWN);

        Rectangle porteNuit = new Rectangle(565,230,20,35);
        porteNuit.setFill(Color.BROWN);

        Circle poigneeJour = new Circle(180,250,5);
        poigneeJour.setFill(Color.LIGHTGREEN);

        Circle poigneeNuit = new Circle(580,250,5);
        poigneeNuit.setFill(Color.LIGHTGREEN);

        Rectangle fenetreJour = new Rectangle(215, 210,35,20);
        fenetreJour.setFill(Color.AQUA);
        fenetreJour.setStroke(Color.GRAY);

        Rectangle fenetreNuit = new Rectangle(615,210,35,20);
        fenetreNuit.setFill(Color.AQUA);
        fenetreNuit.setStroke(Color.GRAY);

        Line ligneVJour= new Line(232,210,232,230);
        ligneVJour.setStroke(Color.GRAY);
        ligneVJour.setStrokeWidth(1);

        Line ligneVNuit = new Line(632,210,632,230);
        ligneVNuit.setStroke(Color.GRAY);
        ligneVNuit.setStrokeWidth(1);

        Line ligneHJour= new Line(215,220,250,220);
        ligneHJour.setStroke(Color.GRAY);
        ligneHJour.setStrokeWidth(1);

        Line ligneHNuit = new Line(615,220,650,220);
        ligneHNuit.setStrokeWidth(1);
        ligneHNuit.setStroke(Color.GRAY);

        Circle soleil = new Circle(320,70,40);
        soleil.setStrokeWidth(2);
        soleil.setFill(Color.YELLOW);
        soleil.setStroke(Color.LIGHTGREY);
        FillTransition ftSoleil = new FillTransition(Duration.seconds(2),soleil);
        ftSoleil.setToValue(Color.ORANGE);
        ftSoleil.setCycleCount(Timeline.INDEFINITE);
        ftSoleil.setAutoReverse(true);
        ftSoleil.play();

        Circle lune = new Circle(720,70,40);
        Stop[] stops = new Stop[]{
                new Stop(0,Color.LIGHTGREY),
                new Stop(0.45,Color.GRAY),
                new Stop(0.55,Color.rgb(219, 157, 118)),
                new Stop(0.65,Color.GRAY),
                new Stop(1,Color.DARKSLATEGRAY)
        };

        //J'ai fait de mon mieux pour reproduire la ligne dans la lune
        LinearGradient degrade = new LinearGradient(0,0,1,1,true,CycleMethod.NO_CYCLE,stops);
        lune.setFill(degrade);

        Line ligneSoleil1= new Line(320,0,320,140);
        ligneSoleil1.setStroke(Color.YELLOW);
        ligneSoleil1.setStrokeWidth(2);

        Line ligneSoleil2= new Line(250,70,390,70);
        ligneSoleil2.setStroke(Color.YELLOW);
        ligneSoleil2.setStrokeWidth(2);

        Line ligneSoleil3= new Line(280,30,360,110);
        ligneSoleil3.setStroke(Color.YELLOW);
        ligneSoleil3.setStrokeWidth(2);

        Line ligneSoleil4= new Line(280,110,360,30);
        ligneSoleil4.setStroke(Color.YELLOW);
        ligneSoleil4.setStrokeWidth(2);

        RotateTransition lignes1 = new RotateTransition(Duration.seconds(2), ligneSoleil1);
        lignes1.setInterpolator(Interpolator.LINEAR);
        lignes1.setByAngle(360);
        lignes1.setCycleCount(Timeline.INDEFINITE);
        lignes1.play();

        RotateTransition lignes2 = new RotateTransition(Duration.seconds(2), ligneSoleil2);
        lignes2.setInterpolator(Interpolator.LINEAR);
        lignes2.setByAngle(360);
        lignes2.setCycleCount(Timeline.INDEFINITE);
        lignes2.play();

        RotateTransition lignes3 = new RotateTransition(Duration.seconds(2), ligneSoleil3);
        lignes3.setInterpolator(Interpolator.LINEAR);
        lignes3.setByAngle(360);
        lignes3.setCycleCount(Timeline.INDEFINITE);
        lignes3.play();

        RotateTransition lignes4 = new RotateTransition(Duration.seconds(2), ligneSoleil4);
        lignes4.setInterpolator(Interpolator.LINEAR);
        lignes4.setByAngle(360);
        lignes4.setCycleCount(Timeline.INDEFINITE);
        lignes4.play();

        QuadCurve aileG1 = new QuadCurve(100,100,110,50,120,105);
        aileG1.setStrokeWidth(2);
        aileG1.setFill(Color.LIGHTGREY);
        aileG1.setStroke(Color.BLACK);


        QuadCurve aileD1= new QuadCurve(120,105,130,50,140,100);
        aileD1.setStrokeWidth(2);
        aileD1.setFill(Color.LIGHTGREY);
        aileD1.setStroke(Color.BLACK);


        QuadCurve aileG2 = new QuadCurve(200,50,210,0,220,55);
        aileG2.setStrokeWidth(2);
        aileG2.setFill(Color.LIGHTGREY);
        aileG2.setStroke(Color.BLACK);

        QuadCurve aileD2= new QuadCurve(220,55,230,0,240,50);
        aileD2.setStrokeWidth(2);
        aileD2.setFill(Color.LIGHTGREY);
        aileD2.setStroke(Color.BLACK);

        Polygon etoile1= new Polygon(450,18,440,30,425,30,435,40,430,50,450,43,470,50,465,40,475,30,460,30);
        etoile1.setFill(Color.YELLOW);

        FadeTransition etoileFlash1= new FadeTransition(Duration.seconds(1),etoile1);
        etoileFlash1.setFromValue(1);
        etoileFlash1.setToValue(0);
        etoileFlash1.setAutoReverse(true);
        etoileFlash1.setCycleCount(Timeline.INDEFINITE);
        etoileFlash1.play();

        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        KeyValue aG1Debut = new KeyValue(aileG1.startYProperty(),85,Interpolator.LINEAR);
        KeyValue aG1Fin = new KeyValue(aileG1.endYProperty(),80,Interpolator.LINEAR);
        KeyValue aD1Debut = new KeyValue(aileD1.startYProperty(),80,Interpolator.LINEAR);
        KeyValue aD1Fin = new KeyValue(aileD1.endYProperty(),85,Interpolator.LINEAR);
        KeyValue aG1X = new KeyValue(aileG1.startXProperty(),75,Interpolator.LINEAR);
        KeyValue aD1X = new KeyValue(aileD1.endXProperty(),165,Interpolator.LINEAR);
        KeyValue aG2Debut= new KeyValue(aileG2.startYProperty(),35,Interpolator.LINEAR);
        KeyValue aG2Fin = new KeyValue(aileG2.endYProperty(),30,Interpolator.LINEAR);
        KeyValue aD2Debut = new KeyValue(aileD2.startYProperty(),30,Interpolator.LINEAR);
        KeyValue aD2Fin = new KeyValue(aileD2.endYProperty(),35,Interpolator.LINEAR);
        KeyValue aG2X = new KeyValue(aileG2.startXProperty(),175,Interpolator.LINEAR);
        KeyValue aD2X = new KeyValue(aileD2.endXProperty(),265,Interpolator.LINEAR);

        KeyFrame oiseau1= new KeyFrame(Duration.seconds(1),aG1Debut,aD1Fin, aD1X,aG1X,aG2Debut,aD2Fin,aG2X,aD2X,aG1Fin,aD1Debut,aG2Fin,aD2Debut);

        timeline.getKeyFrames().addAll(oiseau1);
        timeline.setAutoReverse(true);
        timeline.play();


        Group root = new Group(jour,nuit,textJour,textNuit,baseMaison,toitJour,porteJour,poigneeJour,fenetreJour,
                ligneVJour,ligneHJour,ligneSoleil1,ligneSoleil2,ligneSoleil3,ligneSoleil4,soleil,aileG1,aileD1,aileG2,aileD2,toitNuit,baseMaisonNuit,
                porteNuit,poigneeNuit,fenetreNuit,ligneVNuit,ligneHNuit,lune,etoile1);

       stage.setScene(new Scene(root));
       stage.show();
    }

}

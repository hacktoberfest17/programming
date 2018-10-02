/**
 * @BryanSpeelman
 * Java fx color slider
 * 
 *
 */


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class colorSlider extends Application{
    @Override // Override the start method
    public void start(Stage primaryStage) throws Exception{
        //Text to modify
        Text text = new Text("Show Colors");
        text.setFill(Color.WHITE);
        text.setStyle("-fx-font: 24 arial;");

        //Create Sliders
        Slider s1 = new Slider();
        s1.setMax(255);
        Slider s2 = new Slider();
        s2.setMax(255);
        Slider s3 = new Slider();
        s3.setMax(255);
        Slider s4 = new Slider();
        s4.setMax(1.0);

        //Create a text in a pane
        Pane paneForText = new Pane();
        paneForText.getChildren().add(text);

        //Create Flowpane
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(11, 12, 13, 14));
        pane.setHgap(5);
        pane.setVgap(5);

        //Place nodes into plane
        pane.add(text, 1, 0);
        pane.add(new Label("Red"), 0, 1);
        pane.add(s1, 1,1);
        pane.add(new Label("Green"), 0, 2);
        pane.add(s2, 1,2);
        pane.add(new Label("Blue"), 0, 3);
        pane.add(s3, 1,3);
        pane.add(new Label("Opacity"), 0, 4);
        pane.add(s4, 1,4);

        //Action listeners - Use values from slider to set color and opacity values.
        s1.valueProperty().addListener(ov ->
            text.setFill(Color.rgb((int)s1.getValue(),
                (int)s2.getValue(),
                (int)s3.getValue(),
                s4.getValue())));

        s2.valueProperty().addListener(ov ->
            text.setFill(Color.rgb((int)s1.getValue(),
                (int)s2.getValue(),
                (int)s3.getValue(),
                s4.getValue())));

        s3.valueProperty().addListener(ov ->
            text.setFill(Color.rgb((int)s1.getValue(),
                (int)s2.getValue(),
                (int)s3.getValue(),
                s4.getValue())));

        s4.valueProperty().addListener(ov ->
            text.setFill(Color.rgb((int)s1.getValue(),
                (int)s2.getValue(),
                (int)s3.getValue(),
                s4.getValue())));

        //Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Selecting Colors");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * The main method is only needed for the IDE with limit JavaFX support.
     */
    public static void main(String[] args){
        Application.launch(args);
    }
}

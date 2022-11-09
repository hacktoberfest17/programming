import javafx.application.Application;
import javafx.application.Platform;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.geometry.Pos;

import javafx.scene.Scene;
import javafx.scene.control.ToolBar;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;


import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class HacktoberfestMain extends Application{
	
	int toolBarHeight = 25;
	
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Hacktoberfest");
		primaryStage.initStyle(StageStyle.UNDECORATED);
		
		BorderPane root = new BorderPane();
		root.setStyle("-fx-background-color: #212121");
		
		Scene scene = new Scene(root, 500, 500);
		
		//Set up the Top Toolbar
		HBox spacer = new HBox();
		HBox.setHgrow(spacer, Priority.ALWAYS);
		
		ToolBar toolBar = new ToolBar();
		toolBar.setPrefHeight(toolBarHeight);
		toolBar.setMinHeight(toolBarHeight);
		toolBar.setMaxHeight(toolBarHeight);
		toolBar.getItems().addAll(spacer, new WindowButtons());
		toolBar.setStyle("-fx-background-color: #212121");
		
		root.setTop(toolBar);
		
		//Create Label
		Label mainLabel = new Label();
		mainLabel.setText("HACKTOBERFEST");
		mainLabel.setStyle("-fx-text-fill: Orange;"
				+ "-fx-font-size: 48;");
		
		root.setCenter(mainLabel);
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	class WindowButtons extends HBox {
		public WindowButtons() {
			Button closeButton = new Button("X");
			
			closeButton.setAlignment(Pos.CENTER_RIGHT);
			closeButton.setStyle("-fx-background-radius: 0;"
					+ "-fx-focus-color: transparent;"
					+ "-fx-border-color: #323232;"
					+ "-fx-background-color: #323232;"
					+ "-fx-text-fill: #BDBDBD;");
			closeButton.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent arg0) {
					Platform.exit();
					
				}
				
			});
			
			this.getChildren().add(closeButton);
		}
	}
}

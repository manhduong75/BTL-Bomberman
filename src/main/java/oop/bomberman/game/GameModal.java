package oop.bomberman.game;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.effect.ColorInput;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import oop.bomberman.App;
import oop.bomberman.state.StateStack;

public class GameModal {
	Group modalOverlay;
	VBox modal;
	Button resumeButton;
	Button exitButton;

	public void onModalClose(GameModalAction gameModalAction) {
		resumeButton.setOnMouseClicked(e -> {
			gameModalAction.onAction();
			this.close();
		});
		exitButton.setOnMouseClicked(e -> {
			gameModalAction.onAction();
			StateStack.pop();
			StateStack.push("mainmenu");
		});
	}

	public GameModal() {
		modalOverlay = new Group();
		modalOverlay.getStylesheets().add(getClass().getResource("/css/game-modal.css").toExternalForm());
		modalOverlay.relocate(0, 0);
		modalOverlay.getStyleClass().add("modal-overlay");
		modalOverlay.prefWidth(App.getWindowWidth());
		modalOverlay.prefHeight(App.getWindowHeight());
		
		modal = new VBox(20);
		modal.setPrefWidth(400);
		modal.setPrefHeight(300);
		modal.relocate((App.getWindowWidth() - 400) / 2, (App.getWindowHeight() - 300) / 2);
		modal.getStyleClass().add("modal");

		VBox modalBody = new VBox();
		modalBody.setPrefWidth(400);
		modalBody.setPrefHeight(200);
		
		resumeButton = new Button();
		resumeButton.setFocusTraversable(false);
		resumeButton.setText("Resume");

		exitButton = new Button();
		exitButton.setFocusTraversable(false);
		exitButton.setText("Exit");

		HBox buttonGroup = new HBox();
		buttonGroup.setPadding(new Insets(0, 20, 0, 20));
		Region spacer = new Region();
		HBox.setHgrow(spacer, Priority.ALWAYS);
		buttonGroup.getChildren().addAll(resumeButton, spacer, exitButton);
		
		modal.getChildren().addAll(modalBody, buttonGroup);
		modalOverlay.getChildren().add(modal);
	}
	
	public void open() {
		App.root.getChildren().add(modalOverlay);
	}

	public void close() {
		App.root.getChildren().remove(modalOverlay);
	}
}

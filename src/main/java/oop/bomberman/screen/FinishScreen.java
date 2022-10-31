package oop.bomberman.screen;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import oop.bomberman.App;
import oop.bomberman.state.IState;
import oop.bomberman.state.StateStack;

public class FinishScreen implements IState {
	private static boolean win;

	public FinishScreen(boolean win) {
		FinishScreen.win = win;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		App.setWindowWidth(992);		
		App.setWindowHeight(600);
		Button backButton = new Button("Back");
		Button nextLevelButton = new Button("Next level");
		if (!win) {
			nextLevelButton.setText("Replay");
		}
		Label header = new Label();
		header.setTextFill(Color.WHITE);
		if (win) {
			header.setText("Congratulation!");
		} else {
			header.setText("You lose!");
		}
		header.setFont(Font.font("Roboto", FontWeight.BOLD, 48));
		backButton.setFocusTraversable(false);
		backButton.setOnMouseClicked(e -> {
			StateStack.pop();
			StateStack.push("mainmenu");
		});
		nextLevelButton.setFocusTraversable(false);
		nextLevelButton.setOnMouseClicked(e -> {
			if (win) {
				App.setCurrentLevel(App.getCurrentLevel() + 1);
			}
			StateStack.pop();
			StateStack.push("game");
		});
		VBox headerBox = new VBox();
		headerBox.setPrefWidth(App.getWindowWidth());
		headerBox.setAlignment(Pos.CENTER);
		headerBox.relocate(0, 100);
		headerBox.getChildren().add(header);
		VBox buttonGroup = new VBox(20);
		if (!win  || (win && App.getCurrentLevel() < 3)) {
			buttonGroup.getChildren().add(nextLevelButton);
		}
		buttonGroup.getChildren().add(backButton);
		buttonGroup.setPrefWidth(App.getWindowWidth());
		buttonGroup.setAlignment(Pos.CENTER);
		buttonGroup.relocate(0, 400);
		App.root.getChildren().addAll(headerBox, buttonGroup);
	}

	public static void setWin(boolean win) {
		FinishScreen.win = win;
	}

	@Override
	public void onEnter() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(long currentTime) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onExit() {
		// TODO Auto-generated method stub
		App.root.getChildren().clear();
	}

	@Override
	public void onClose() {
		// TODO Auto-generated method stub
		
	}
	
}

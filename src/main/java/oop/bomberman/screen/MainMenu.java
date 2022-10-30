package oop.bomberman.screen;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import oop.bomberman.App;
import oop.bomberman.state.IState;
import oop.bomberman.state.StateStack;

public class MainMenu implements IState {

	@Override
	public void init() {
		// TODO Auto-generated method stub
		App.setWindowHeight(600);
		App.setWindowWidth(992);

		Label header = new Label();
		header.setText("Bomberman");
		Button playGame = new Button("Play");
		playGame.setOnMouseClicked(e -> {
			StateStack.pop();
			StateStack.push("game");
		});
		header.setTextFill(Color.WHITE);
		header.setFont(Font.font("Roboto", FontWeight.BOLD, 48));
		playGame.setFocusTraversable(false);
		VBox headerBox = new VBox();
		headerBox.setPrefWidth(App.getWindowWidth());
		headerBox.setAlignment(Pos.CENTER);
		headerBox.relocate(0, 100);
		headerBox.getChildren().add(header);
		VBox playGameBox = new VBox();
		playGameBox.getChildren().add(playGame);
		playGameBox.setPrefWidth(App.getWindowWidth());
		playGameBox.setAlignment(Pos.CENTER);
		playGameBox.relocate(0, 500);
		App.root.getChildren().addAll(headerBox, playGameBox);
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

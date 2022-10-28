package oop.bomberman.game;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import oop.bomberman.App;
import oop.bomberman.entities.Player;
import oop.bomberman.sprite.Sprite;
import oop.bomberman.state.StateStack;

public class GamePanel {
	Image bombItemImage;
	ImageView bombItemImageView;
	Text bombItemNum;
	Image flameItemImage;
	ImageView flameItemImageView;
	Text flameItemNum;
	Image speedItemImage;
	ImageView speedItemImageView;
	Text speedItemNum;
	Button button;

	public GamePanel() {
		this.bombItemImage = Sprite.powerup_bombs;
		this.bombItemImageView = new ImageView(bombItemImage);
		this.bombItemNum = new Text();
		
		this.flameItemImage = Sprite.powerup_flames;
		this.flameItemImageView = new ImageView(flameItemImage);
		this.flameItemNum = new Text();		

		this.speedItemImage = Sprite.powerup_speed;
		this.speedItemImageView = new ImageView(speedItemImage);
		this.speedItemNum = new Text();

		this.button = new Button("back to main");
		this.button.setOnMouseClicked(e -> {
			StateStack.pop();
			StateStack.push("mainmenu");
		});
		this.button.setFocusTraversable(false);
		Font font = Font.font(28);

		HBox bomItemBox = new HBox(12);
		this.bombItemNum.setFill(Color.WHITE);
		this.bombItemNum.setFont(font);
		bomItemBox.getChildren().addAll(bombItemImageView, bombItemNum);
		bomItemBox.setAlignment(Pos.CENTER);

		HBox flameItemBox = new HBox(12);
		this.flameItemNum.setFill(Color.WHITE);
		this.flameItemNum.setFont(font);
		flameItemBox.getChildren().addAll(flameItemImageView, flameItemNum);
		flameItemBox.setAlignment(Pos.CENTER);

		HBox speedItemBox = new HBox(12);
		this.speedItemNum.setFill(Color.WHITE);
		this.speedItemNum.setFont(font);
		speedItemBox.getChildren().addAll(speedItemImageView, speedItemNum);
		speedItemBox.setAlignment(Pos.CENTER);

		HBox itemBox = new HBox(20);
		itemBox.getChildren().addAll(bomItemBox, flameItemBox, speedItemBox);
		itemBox.setAlignment(Pos.CENTER);

		itemBox.relocate(16, 12);
		App.root.getChildren().addAll(itemBox);
	}

	public void update() {

	}

	public void draw(Player player) {
		this.bombItemNum.setText(Integer.toString(player.getBombRemainingNum()));
		this.flameItemNum.setText(Integer.toString(player.getFlameLength()));
		this.speedItemNum.setText(String.format("%.0f", player.getVelocity()));
	}
}

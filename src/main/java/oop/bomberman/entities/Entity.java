package oop.bomberman.entities;

import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;
import oop.bomberman.App;
import oop.bomberman.sprite.Sprite;

public abstract class Entity extends Rectangle {
	private Sprite sprite;

	public Entity(double width, double height, double x, double y, Image image) {
		this.setWidth(width);
		this.setHeight(height);
		this.setX(x);
		this.setY(y);
		this.sprite = new Sprite(image);
		App.root.getChildren().add(sprite.imageView);
	}

	public void draw() {
		this.sprite.imageView.setX(this.getX());
		this.sprite.imageView.setY(this.getY());
	}

	public Sprite getSprite() {
		return this.sprite;
	}
}

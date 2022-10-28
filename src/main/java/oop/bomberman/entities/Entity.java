package oop.bomberman.entities;

import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;
import oop.bomberman.App;
import oop.bomberman.game.Game;
import oop.bomberman.sprite.Sprite;

public abstract class Entity extends Rectangle {
	private Sprite sprite;
	private boolean removed;

	public Entity(double width, double height, double x, double y, Image image) {
		this.setWidth(width);
		this.setHeight(height);
		this.setX(x);
		this.setY(y);
		this.sprite = new Sprite(image);
		App.root.getChildren().add(sprite.imageView);
	}

	public int getTileX() {
		return (int)this.getX() / 32;
	}

	public int getTileY() {
		return (int)this.getY() / 32;
	}

	public static int tileToPosision(int tileCoordinate) {
		return tileCoordinate * 32;
	}

	public boolean hasSameTilePosition(Entity entity) {
		if (this.getTileX() == entity.getTileX() && this.getTileY() == entity.getTileY()) {
			return true;
		}
		
		return false;
	}

	public void draw() {
		this.sprite.imageView.setX(this.getX());
		this.sprite.imageView.setY(this.getY() + Game.MAIN_BOARD_OFFSET);
	}

	public Sprite getSprite() {
		return this.sprite;
	}

	public void remove() {
		this.setWidth(0);
		this.setHeight(0);
		this.setX(-64);
		this.setY(-64);
		this.sprite.imageView.setImage(null);
		App.root.getChildren().remove(this.sprite.imageView);
		this.removed = true;
	}

	public boolean isRemoved() {
		return this.removed;
	}
}

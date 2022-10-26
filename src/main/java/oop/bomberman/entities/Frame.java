package oop.bomberman.entities;

import javafx.scene.image.Image;

public class Frame extends Entity {
	public Frame(int x, int y, Image image) {
		super(32, 32, x, y, image);
	}

	public static Frame createFromTilePosition(int tileX, int tileY, Image image) {
		return new Frame(tileToPosision(tileX), tileToPosision(tileY), image);
	}
}

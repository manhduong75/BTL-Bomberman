package oop.bomberman.entities;

import javafx.scene.shape.Rectangle;

public abstract class Entity extends Rectangle {
	public Entity(double width, double height, double x, double y) {
		this.setWidth(width);
		this.setHeight(height);
		this.setX(x);
		this.setY(y);
	}
}

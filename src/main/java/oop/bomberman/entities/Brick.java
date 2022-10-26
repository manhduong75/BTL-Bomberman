package oop.bomberman.entities;

import oop.bomberman.App;
import oop.bomberman.sprite.Sprite;

public class Brick extends Entity {
	public Brick(int x, int y) {
		super(32, 32, x, y, Sprite.brick);
	}

	@Override
	public void remove() {
		super.remove();
		App.root.getChildren().remove(this.getSprite().imageView);
	}
}

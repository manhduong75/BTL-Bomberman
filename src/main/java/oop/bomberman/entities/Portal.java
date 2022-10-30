package oop.bomberman.entities;

import oop.bomberman.sprite.Sprite;

public class Portal extends Entity {
	private boolean discovered = false;

	public Portal(int x, int y) {
		super(32, 32, x, y, Sprite.brick);
	}

	public void remove() {
		if (!discovered) {
			discovered = true;
			this.getSprite().imageView.setImage(Sprite.portal);
		}
	}

	public boolean isDiscovered() {
		return this.discovered;
	}
}

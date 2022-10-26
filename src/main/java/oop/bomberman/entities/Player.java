package oop.bomberman.entities;

import oop.bomberman.App;

public class Player extends Movable {
	public Player(int x, int y) {
		super(12 * App.scale, 12 * App.scale, x, y);
	}

	@Override
	public void onCollision(Entity entity) {

	}
}

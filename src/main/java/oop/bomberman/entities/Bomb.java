package oop.bomberman.entities;

import oop.bomberman.sprite.Sprite;

public class Bomb extends Entity {
	private int timeToExplosing = 120;
	private int timeAfterExplosion = 60;
	private int currentTime = 0;
	private boolean explosed = false;
	private boolean removed = false;
	public Bomb(int x, int y) {
		super(32, 32, x, y, Sprite.bomb);
	}

	public void update() {
		if (!this.explosed) {
			if (this.currentTime < this.timeToExplosing) {
				this.currentTime++;
			} else {
				this.explosed = true;
				this.currentTime = 0;
			}
		} else {
			if (!this.removed && this.currentTime < this.timeAfterExplosion) {
				this.currentTime++;
			} else {
				this.removed = true;
			}
		}
	}
}

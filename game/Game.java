package oop.bomberman.game;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.ImageView;
import oop.bomberman.App;
import oop.bomberman.animator.PlayerAnimator;
import oop.bomberman.controlller.Controller;
import oop.bomberman.controlller.Mover;
import oop.bomberman.entities.Bomb;
import oop.bomberman.entities.Brick;
import oop.bomberman.entities.Grass;
import oop.bomberman.entities.Movable;
import oop.bomberman.entities.Wall;
import oop.bomberman.level.Level;
import oop.bomberman.sprite.Sprite;

public class Game {
	private Movable player;
	private Controller playerController;
	private Mover playerMover;
	private Sprite playerSprite;
	private PlayerAnimator playerAnimator;

	private List<Brick> bricks = new ArrayList<>();
	private List<Wall> walls = new ArrayList<>();
  private List<Grass> grasses = new ArrayList<>();
	private List<Bomb> bombs = new ArrayList<>();
	private List<Sprite> brickSprites = new ArrayList<>();
	private List<Sprite> wallSprites = new ArrayList<>();
	private List<Sprite> grassSprites = new ArrayList<>();
	private List<Sprite> bombSprites = new ArrayList<>();

	private Level level;

	public Game() {}

	public void init() {
		this.level = new Level("levels/Level1.txt", this);
		System.out.println("level " + this.level);
		this.level.createEntities();

		this.addGrassSprites();
		this.addBrickSprites();
		this.addWallSprites();
		this.setPlayerSprite();
		this.player.addCollisions(this.bricks);
		this.player.addCollisions(this.walls);
		this.playerAnimator = new PlayerAnimator(playerSprite);

		App.setWindowWidth(this.level.getWidth() * 16 * App.scale);
		App.setWindowHeight(this.level.getHeight() * 16 * App.scale);
	}

	public void update() {
		this.playerMover.update();
    this.playerAnimator.update(playerMover);

		System.out.println(playerController.getInput());
		if (playerController.getInput().contains("ENTER")) {
			System.out.println("enter");
			this.addBomb();
		}
	}

	public void draw() {
		for (int i = 0; i < this.grasses.size(); i++) {
			Grass grass = this.grasses.get(i);
			ImageView grassImageView = this.grassSprites.get(i).imageView;
			grassImageView.setX(grass.getX());
			grassImageView.setY(grass.getY());
		}
		
		for (int i = 0; i < this.bricks.size(); i++) {
			Brick brick = this.bricks.get(i);
			ImageView brickImageView = this.brickSprites.get(i).imageView;
			brickImageView.setX(brick.getX());
			brickImageView.setY(brick.getY());
		}

		for (int i = 0; i < this.walls.size(); i++) {
			Wall wall = this.walls.get(i);
			ImageView wallImageView = this.wallSprites.get(i).imageView;
			wallImageView.setX(wall.getX());
			wallImageView.setY(wall.getY());
		}

		for (int i = 0; i < this.bombs.size(); i++) {
			Bomb bomb = this.bombs.get(i);
			ImageView bombImageView = this.bombSprites.get(i).imageView;
			bombImageView.setX(bomb.getX());
			bombImageView.setY(bomb.getY());
			bombImageView.toFront();
		}

		playerSprite.imageView.toFront();
		this.playerAnimator.updateView(playerMover);
	}

	public void addBrick(Brick brick) {
		this.bricks.add(brick);
	}

	public void addGrass(Grass grass) {
		this.grasses.add(grass);
	}

	public void addWall(Wall wall) {
		this.walls.add(wall);
	}

	public void addBrickSprites() {
		this.bricks.forEach(b -> {
			Sprite brickSprite = new Sprite(Sprite.brick);
			this.brickSprites.add(brickSprite);
			App.root.getChildren().add(brickSprite.imageView);
		});
	}

	public void addGrassSprites() {
		this.grasses.forEach(g -> {
			Sprite grassSprite = new Sprite(Sprite.grass);
			this.grassSprites.add(grassSprite);
			App.root.getChildren().add(grassSprite.imageView);
		});
	}

	public void addWallSprites() {
		this.walls.forEach(w -> {
			Sprite wallSprite = new Sprite(Sprite.wall);
			this.wallSprites.add(wallSprite);
			App.root.getChildren().add(wallSprite.imageView);
		});
	}

	public void setPlayerSprite() {
		this.playerSprite = new Sprite(Sprite.player_down);
		App.root.getChildren().add(playerSprite.imageView);
	}

	public void setPlayer(Movable player) {
		this.player = player;
		this.playerController = new Controller(App.scene);
    this.playerMover = new Mover(this.playerController, this.player);
	}

	public void addBomb() {
		int tileX = (int) this.player.getX() / 32;
		int tileY = (int) this.player.getY() / 32;
		int bombPositionX = tileX * 32;
		int bombPosisionY = tileY * 32;

		this.bombs.add(
			new Bomb(bombPositionX, bombPosisionY)
		);
		Sprite bombSprite = new Sprite(Sprite.bomb);
		this.bombSprites.add(bombSprite);
		App.root.getChildren().add(bombSprite.imageView);
	}
}

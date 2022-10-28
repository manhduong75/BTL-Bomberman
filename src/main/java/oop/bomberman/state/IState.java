package oop.bomberman.state;

public interface IState {
	void init();

	void onEnter();

	void update(long currentTime);

	void draw();

	void onExit();

	void onClose();
}

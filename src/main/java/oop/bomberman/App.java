package oop.bomberman;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import oop.bomberman.game.Game;
import oop.bomberman.game.GameModal;
import oop.bomberman.screen.FinishScreen;
import oop.bomberman.screen.MainMenu;
import oop.bomberman.state.StateStack;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    public static Group root = new Group();
    public static Scene scene = new Scene(App.root);
    public static Stage stage;
    public static int scale = 2;
    private static AnimationTimer gameLoop;
    private static double windowWidth;
    private static double windowHeight;
    public static GameModal gameModal;
    private static int currentLevel = 1;

    @Override
    public void start(Stage stage) throws IOException {
        stage.setScene(scene);
        App.stage = stage;
        gameModal = new GameModal();


        StateStack.addState("mainmenu", new MainMenu());
        StateStack.addState("game", new Game());
        StateStack.addState("finish-screen", new FinishScreen(false));

        StateStack.push("game");

        stage.setTitle("Bomberman");
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.show();
        scene.getWindow().setHeight(0);
        scene.setFill(Color.BLACK);
        scene.getStylesheets().add(getClass().getResource("/css/globals.css").toExternalForm());

        App.gameLoop = new AnimationTimer() {
            @Override
            public void handle(long now) {
                StateStack.getCurrentState().update(now);
                StateStack.getCurrentState().draw();
            }
        };

        App.gameLoop.start();
    }

    public static void setWindowWidth(double width) {
        App.windowWidth = width;
        App.scene.getWindow().setWidth(width + 16);
    }

    public static void setWindowHeight(double height) {
        App.windowHeight = height;
        App.scene.getWindow().setHeight(height + 40);
    }

    public static double getWindowWidth() {
        return App.windowWidth;
    }

    public static double getWindowHeight() {
        return App.windowHeight;
    }

    public static void main(String[] args) {
        launch();
    }  

    public static int getCurrentLevel() {
        return currentLevel;
    }

    public static void setCurrentLevel(int currentLevel) {
        App.currentLevel = currentLevel;
    }
}
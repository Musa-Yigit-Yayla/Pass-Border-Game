package com.mycompany.passbordergame;

import java.io.File;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Group;
import javafx.scene.layout.StackPane;
import java.io.IOException;
import javafx.scene.layout.Pane;

/**
 * Musa Yiğit Yayla
 * 1/5/2023
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static int difficulty = 2; // 0 easy 1 med // 2 hard
    
    public static final double SPAWN_LINE = 50; // Y = 50
    public static final double BORDER_LINE = 1000; // Y = 1000
    public static final int EASY_DIFFICULTY = 0;
    public static final int MEDIUM_DIFFICULTY = 1;
    public static final int HARD_DIFFICULTY = 2;
    
    @Override
    public void start(Stage stage) throws IOException {
        
        ImageView background = new ImageView(new Image(new File("Pass-Border-Game\\PassBorderGame\\src\\main\\java\\imgs\\desert.jpg").toURI().toString()));
        //Group group = new Group(background);
        
        Tank tank = new Tank(10, 200, 200);
        Helicopter heli = new Helicopter(10, 400, 200);
        StackPane holderPane = new StackPane();
        Pane pane = new StackPane();
        pane.getChildren().add(background);
        pane.getChildren().add(heli.getHelicopterPane());
        holderPane.getChildren().add(pane);
        //pane.getChildren().add(tank.getGUI());
        
        Game game = new Game(difficulty);
        game.playFX(pane);
        scene = new Scene(holderPane, 900, 1500);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}
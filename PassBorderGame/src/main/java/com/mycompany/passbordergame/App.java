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
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static int difficulty = 2;
    @Override
    public void start(Stage stage) throws IOException {
        
        ImageView background = new ImageView(new Image(new File("Pass-Border-Game\\PassBorderGame\\src\\main\\java\\imgs\\desert.jpg").toURI().toString()));
        //Group group = new Group(background);
        
        Tank tank = new Tank(10, 200, 200);
        Pane pane = new Pane();
        pane.getChildren().add(background);
        pane.getChildren().add(tank.getGUI());
        
        Game game = new Game(difficulty);
        game.playFX(pane);
        scene = new Scene(pane, 900, 1500);
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
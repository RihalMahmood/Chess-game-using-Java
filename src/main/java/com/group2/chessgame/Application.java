package com.group2.chessgame;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {

    private static Scene loginScene;
    private static Scene gameScene;
    @Override
    public void start(Stage stage) throws IOException {
        //Scene1
        FXMLLoader fxmlLoaderLogin = new FXMLLoader(Application.class.getResource("loginScreen.fxml"));
        stage.setTitle("Chess Game");
        stage.setMinHeight(800);
        stage.setMinWidth(800);
        stage.setResizable(false);
        loginScene = new Scene(fxmlLoaderLogin.load());
        stage.setScene(loginScene);
        stage.show();
        fxmlLoaderLogin.getRoot();
        stage.setOnCloseRequest(event -> {
            event.consume();
            logout(stage);
        });
    }

    public void logout(Stage stage) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("LOGOUT");
        alert.setHeaderText("You are the about to close the game!");
        alert.setContentText("Do you want to close the game?\nUnsaved progresses might be lost");
        if (alert.showAndWait().get() == ButtonType.OK) {
            System.out.println("You have closed the game!");
            stage.close();
        }
    }


    public static void main(String[] args) {

        launch();

    }

    public static Scene getLoginScene() throws IOException {
        FXMLLoader fxmlLoaderLogin = new FXMLLoader(Application.class.getResource("loginScreen.fxml"));
        loginScene = new Scene(fxmlLoaderLogin.load());
        return loginScene;
    }

    public static Scene getGameScene() {
        return gameScene;
    }
}

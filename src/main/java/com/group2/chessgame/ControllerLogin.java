package com.group2.chessgame;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class ControllerLogin {
    @FXML
    private TextField player1NameTxt;
    @FXML
    private TextField player2NameTxt;

    private GridPane gridPane;
    private Scene gameScene;
    public void onStartBtn(ActionEvent event) throws IOException {
        Stage stageGame = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stageGame.setScene(Application.getGameScene());
        FXMLLoader fxmlLoaderGameScene = new FXMLLoader(Application.class.getResource("gameScene.fxml"));
        gameScene = new Scene(fxmlLoaderGameScene.load(), 800, 800);
        fxmlLoaderGameScene.getRoot();
        stageGame.setScene(gameScene);

        Controller controller = fxmlLoaderGameScene.getController();
        gridPane = controller.getGridPane();
        StackPane[][] stackPanes = new StackPane[8][8];
        convertGridTo2DArray(stackPanes);

        GameManager gameManager = GameManager.createInstance(player1NameTxt.getText(), player2NameTxt.getText());


        ChessBoard.storePositionPanes(stackPanes, gridPane);
        ChessBoard.colorChessBoard(ChessBoard.backgroundDisabled, ChessBoard.backgroundDisabled);

        controller.startGame();
    }
    private void convertGridTo2DArray(StackPane[][] stackPanes) {
        int index = 0;
        for (int row = 0; row < 8; row++){
            for (int col = 0; col < 8; col++){
                stackPanes[col][row] = (StackPane) gridPane.getChildren().get(index);
                index++;
            }
        }
    }
}
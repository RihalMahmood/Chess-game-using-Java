package com.group2.chessgame;

import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;

import javax.swing.*;

public class GameManager {
    public static GameManager instance = null;

    private Player player1;
    private Player player2;

    private MenuItem menuItem;

    private Label turnLabel;
    private Label bottomLeftTurnLabel;
    private Label checkState;

    private int numberOfMoves;
    public static boolean checkMate = false;

    private GameStatus currentGameStatus;
    private GameManager(String player1Name, String player2Name) {
        numberOfMoves = 0;
        player1 = new Player(player1Name, true);
        player2 = new Player(player2Name, false);

        currentGameStatus = GameStatus.PLAYER1SELECTPIECE;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setTurnLabel(Label turnLabel) {
        this.turnLabel = turnLabel;
    }

    public void updateStatus(GameStatus gameStatus){
        currentGameStatus = gameStatus;
        checkState.setText("CheckState: " + checkMate);

        switch (currentGameStatus){
            case PRESTART -> preStart();
            case PLAYER1SELECTPIECE -> player1SelectPiece();
            case PLAYER1MOVEPIECE -> player1MovePiece();
            case PLAYER2MOVEPIECE -> player2MovePiece();
            case PLAYER2SELECTPIECE -> player2SelectPiece();
        }

    }
    private void preStart() {
    }
    private void player1SelectPiece() {
        bottomLeftTurnLabel.setText("Total Number of Moves: " + numberOfMoves);
        turnLabel.setText(player1.getName() + "'s Turn");

        if (checkMate && player1.getChessPieces().get(PlayerPieces.King.ordinal()).getPossibleMoves().isEmpty()){
            gameOver(player2.getName());
        }
    }
    private void player1MovePiece() {

    }
    private void player2SelectPiece() {
        bottomLeftTurnLabel.setText("Total Number of Moves: " + numberOfMoves);
        turnLabel.setText(player2.getName() + "'s Turn");

        if (checkMate && player2.getChessPieces().get(PlayerPieces.King.ordinal()).getPossibleMoves().isEmpty()){
            gameOver(player1.getName());
        }
    }

    private void player2MovePiece() {
    }
    private void gameOver(String winner) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Winner!");
        alert.setHeaderText("Winner!");
        alert.setContentText(winner + "Wins");
        alert.showAndWait();

        menuItem.fire();
    }

    public int getNumberOfMoves() {
        return numberOfMoves;
    }
    public void incrementNumberOfMoves(){
        numberOfMoves++;
    }

    public void setBottomLeftTurnLabel(Label bottomLeftTurnLabel) {
        this.bottomLeftTurnLabel = bottomLeftTurnLabel;
    }

    public static GameManager createInstance(String player1Name, String player2Name){
            instance = new GameManager(player1Name, player2Name);
            checkMate = false;
        return instance;
    }
    public GameStatus getCurrentGameStatus() {
        return currentGameStatus;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void restartBtn(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public Label getCheckState() {
        return checkState;
    }

    public void setCheckState(Label checkState) {
        this.checkState = checkState;
    }
}

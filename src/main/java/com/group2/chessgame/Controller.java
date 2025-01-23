package com.group2.chessgame;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Controller{
    //region fxmlVariables
    @FXML
    private MenuBar menuBar;
    @FXML
    private Label bottomLeftTurnLabel;
    @FXML
    private Label turnLabel;
    @FXML
    private GridPane gridPane;
    @FXML
    private VBox topVBox;
    @FXML
    private MenuItem restartBtn;

    @FXML
    private GridPane player1RemovedSpace;
    @FXML
    private GridPane player2RemovedSpace;
    @FXML
    private Label checkState;
    //endregion
    private StackPane selectedStackPane;
    private ChessPiece cacheToBeMovedChessPiece;
    private ArrayList<StackPane> possibleMoves;
    public void onGameReStartBtn(Event e) throws IOException {

        Stage stage = (Stage) ((Node) menuBar).getScene().getWindow();
        stage.setScene(Application.getLoginScene());

    }

    int removeP1Row = 0;
    int removeP1Col = 0;
    int removeP2Row = 0;
    int removeP2Col = 0;
    public void onMouseClickedPanes(Event event) {
        selectedStackPane = (StackPane)event.getSource();

        //White Piece

        //Selecting
        if (!selectedStackPane.getChildren().isEmpty() && GameManager.instance.getCurrentGameStatus() == GameStatus.PLAYER1SELECTPIECE && ((ChessPiece) selectedStackPane.getChildren().get(0)).getIsPlayerWhite()){
            ChessPiece chessPieceSelected = (ChessPiece) selectedStackPane.getChildren().get(0);
            //System.out.println(chessPieceSelected.getName());

            //selectedRow = GridPane.getRowIndex(selectedStackPane);          //debugging purpose
            //selectedCol = GridPane.getColumnIndex(selectedStackPane);       //debugging purpose

            //System.out.print(selectedRow + ", ");       //debugging purpose
            //System.out.println(selectedCol);            //debugging purpose

            possibleMoves = chessPieceSelected.getPossibleMoves();
            GameManager.instance.updateStatus(GameStatus.PLAYER1MOVEPIECE);    //Player1 Chess-Piece Selected so Next We move the piece
            cacheToBeMovedChessPiece = (ChessPiece) selectedStackPane.getChildren().get(0);     //saving the Chess-Piece which we are going to move

            ChessBoard.glowPossibleTiles(possibleMoves, true);
        }
        //Moving
        if (GameManager.instance.getCurrentGameStatus() == GameStatus.PLAYER1MOVEPIECE){
            if (selectedStackPane.getChildren().isEmpty()) {
                ChessPiece chessPieceToBeMoved = cacheToBeMovedChessPiece;
                boolean moveSuccessful = chessPieceToBeMoved.moveTo(selectedStackPane, possibleMoves);
                if (moveSuccessful) {                                                   //if player1 successfully moved
                    GameManager.instance.incrementNumberOfMoves();
                    for (int i = 0; i < chessPieceToBeMoved.getPossibleMoves().size(); i++){
                        StackPane stackPane = chessPieceToBeMoved.getPossibleMoves().get(i);
                        if (stackPane.getChildren().contains(GameManager.instance.getPlayer2().getChessPieces().get(PlayerPieces.King.ordinal()))){
                            GameManager.checkMate = true;
                            break;
                        }
                    }
                    if (chessPieceToBeMoved instanceof King && GameManager.instance.getPlayer1().getChessPieces().contains(chessPieceToBeMoved)){
                        GameManager.checkMate = false;
                    }
                    GameManager.instance.updateStatus(GameStatus.PLAYER2SELECTPIECE);  //Player1 Chess-piece successfully moved so Next Player2's turn

                } else {
                    GameManager.instance.updateStatus(GameStatus.PLAYER1SELECTPIECE);  //To deselect Chess-piece and select another one
                }
            }

            //P1 Removing P2
            else if (!((ChessPiece) selectedStackPane.getChildren().get(0)).getIsPlayerWhite()) {       //checking if there is black piece on destination  in order to remove
                ChessPiece chessPieceToBeMoved = cacheToBeMovedChessPiece;
                boolean moveSuccessful = chessPieceToBeMoved.moveTo(selectedStackPane, possibleMoves);
                if (moveSuccessful) {
                    ChessPiece removedPiece =(ChessPiece) selectedStackPane.getChildren().remove(0);
                    removedPiece.setFitWidth(20);
                    removedPiece.setFitHeight(50);
                    player2RemovedSpace.add(removedPiece,removeP2Col,removeP2Row);    //Removing existing black
                    GameManager.instance.getPlayer2().getChessPieces().remove(removedPiece);
                    removeP2Row++;
                    if (removeP2Row  == 7){
                        removeP2Row = 0;
                        removeP2Col = 1;
                    }
                    for (int i = 0; i < chessPieceToBeMoved.getPossibleMoves().size(); i++){
                        StackPane stackPane = chessPieceToBeMoved.getPossibleMoves().get(i);
                        if (stackPane.getChildren().contains(GameManager.instance.getPlayer2().getChessPieces().get(PlayerPieces.King.ordinal()))){
                            GameManager.checkMate = true;
                            break;
                        }
                    }
                    if (chessPieceToBeMoved instanceof King && GameManager.instance.getPlayer1().getChessPieces().contains(chessPieceToBeMoved)){
                        GameManager.checkMate = false;
                    }
                    GameManager.instance.incrementNumberOfMoves();
                    GameManager.instance.updateStatus(GameStatus.PLAYER2SELECTPIECE);  //Player2 Chess-piece successfully moved so Next Player1's turn
                } else {
                    GameManager.instance.updateStatus(GameStatus.PLAYER1SELECTPIECE);  //To deselect Chess-piece and select another one
                }
            }
        }

        //BLACK Piece


        //Selecting
        if (!selectedStackPane.getChildren().isEmpty() && GameManager.instance.getCurrentGameStatus() == GameStatus.PLAYER2SELECTPIECE && !((ChessPiece) selectedStackPane.getChildren().get(0)).getIsPlayerWhite()){
            ChessPiece chessPieceSelected = (ChessPiece) selectedStackPane.getChildren().get(0);
            //System.out.println(chessPieceSelected.getName());               //debugging purpose

            //selectedRow = GridPane.getRowIndex(selectedStackPane);          //debugging purpose
            //selectedCol = GridPane.getColumnIndex(selectedStackPane);       //debugging purpose

            //System.out.print(selectedRow + ", ");                           //debugging purpose
            //System.out.println(selectedCol);                                //debugging purpose

            possibleMoves = chessPieceSelected.getPossibleMoves();
            GameManager.instance.updateStatus(GameStatus.PLAYER2MOVEPIECE);        //Player2 Chess-Piece Selected so Next We move the piece
            cacheToBeMovedChessPiece = (ChessPiece) selectedStackPane.getChildren().get(0);

            ChessBoard.glowPossibleTiles(possibleMoves, true);
        }
        //Moving
        if (GameManager.instance.getCurrentGameStatus() == GameStatus.PLAYER2MOVEPIECE){
            if (selectedStackPane.getChildren().isEmpty()) {
                ChessPiece chessPieceToBeMoved = cacheToBeMovedChessPiece;
                boolean moveSuccessful = chessPieceToBeMoved.moveTo(selectedStackPane, possibleMoves);
                if (moveSuccessful) {
                    GameManager.instance.incrementNumberOfMoves();
                    for (int i = 0; i < chessPieceToBeMoved.getPossibleMoves().size(); i++){
                        StackPane stackPane = chessPieceToBeMoved.getPossibleMoves().get(i);
                        if (stackPane.getChildren().contains(GameManager.instance.getPlayer1().getChessPieces().get(PlayerPieces.King.ordinal()))){
                            GameManager.checkMate = true;
                            break;
                        }
                    }
                    if (chessPieceToBeMoved instanceof King && GameManager.instance.getPlayer2().getChessPieces().contains(chessPieceToBeMoved)){
                        GameManager.checkMate = false;
                    }
                    GameManager.instance.updateStatus(GameStatus.PLAYER1SELECTPIECE);  //Player2 Chess-piece successfully moved so Next Player1's turn
                } else {
                    GameManager.instance.updateStatus(GameStatus.PLAYER2SELECTPIECE);  //To deselect Chess-piece and select another one
                }
            }

            //P2 Removing P1
            else if (((ChessPiece) selectedStackPane.getChildren().get(0)).getIsPlayerWhite()) {    //checking if there is white piece on destination in order to remove
                ChessPiece chessPieceToBeMoved = cacheToBeMovedChessPiece;
                boolean moveSuccessful = chessPieceToBeMoved.moveTo(selectedStackPane, possibleMoves);
                if (moveSuccessful) {
                    GameManager.instance.incrementNumberOfMoves();
                    ChessPiece removedPiece =(ChessPiece) selectedStackPane.getChildren().remove(0);      //Removing existing white
                    removedPiece.setFitWidth(20);
                    removedPiece.setFitHeight(50);
                    player1RemovedSpace.add(removedPiece,removeP1Col,removeP1Row);    //Removing existing black
                    GameManager.instance.getPlayer1().getChessPieces().remove(removedPiece);
                    for (int i = 0; i < chessPieceToBeMoved.getPossibleMoves().size(); i++){
                        StackPane stackPane = chessPieceToBeMoved.getPossibleMoves().get(i);
                        if (stackPane.getChildren().contains(GameManager.instance.getPlayer1().getChessPieces().get(PlayerPieces.King.ordinal()))){
                            GameManager.checkMate = true;
                            break;
                        }
                        if (chessPieceToBeMoved instanceof King && GameManager.instance.getPlayer2().getChessPieces().contains(chessPieceToBeMoved)){
                            GameManager.checkMate = false;
                        }
                    }
                    removeP1Row++;
                    if (removeP1Row  == 7){
                        removeP1Row = 0;
                        removeP1Col = 1;
                    }
                    GameManager.instance.updateStatus(GameStatus.PLAYER1SELECTPIECE);  //Player2 Chess-piece successfully moved so Next Player1's turn
                } else {
                    GameManager.instance.updateStatus(GameStatus.PLAYER2SELECTPIECE);  //To deselect Chess-piece and select another one
                }
            }
        }
    }

    public GridPane getGridPane() {
        return gridPane;
    }

    public void onDefaultTheme(){
        ChessBoard.colorChessBoard(ChessBoard.getBackground1(), ChessBoard.getBackground2());
        player1RemovedSpace.setBackground(ChessBoard.getBackground6());
        player2RemovedSpace.setBackground(ChessBoard.getBackground6());
    }
    public void onSlateGreyxBrisqueTheme(){
        ChessBoard.colorChessBoard(ChessBoard.getBackground3(), ChessBoard.getBackground4());
    }
    public void onBlackWhiteTheme(){
        ChessBoard.colorChessBoard(ChessBoard.getBackground1(), ChessBoard.getBackground5());
    }
    public void startGame(){
        GameManager gameManager = GameManager.instance;
        gameManager.setTurnLabel(turnLabel);
        gameManager.setBottomLeftTurnLabel(bottomLeftTurnLabel);
        gameManager.restartBtn(restartBtn);
        gameManager.setCheckState(checkState);

        turnLabel.setText(gameManager.getPlayer1().getName() + "'s Turn");
        bottomLeftTurnLabel.setText("Total Number of Moves: " + gameManager.getNumberOfMoves());

        //setting initial theme
        onDefaultTheme();
    }

    public void onAboutMenu(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Credits");
        alert.setContentText("Programmed and Designed by Rihal Mahmood and Md. Sakibul Alam Patwary");
        alert.setHeaderText("Credits");
        alert.showAndWait();
    }


}
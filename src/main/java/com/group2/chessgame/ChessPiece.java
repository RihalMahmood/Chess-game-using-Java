package com.group2.chessgame;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;

public abstract class  ChessPiece extends ImageView implements Movable{

    private String name;
    protected boolean isPlayerWhite;
    private Position position;

    private String chessPieceImagePath;
    private Image chessPieceImage;
    private static  int imageViewFitWidth = 35;
    private static  int imageViewFitHeight = 80;

    public boolean getIsPlayerWhite() {
        return isPlayerWhite;
    }

    public ChessPiece(String name, boolean isPlayerWhite) {
        this.name = name;
        this.isPlayerWhite = isPlayerWhite;
    }



    public String getName() {
        return name;
    }

    public String getChessPieceImagePath() {
        return chessPieceImagePath;
    }

    public Image getChessPieceImage() {
        return chessPieceImage;
    }

    public Position getPosition() {
        return position;
    }

    public void setChessPieceImagePath(String chessPieceImagePath) {
        this.chessPieceImagePath = chessPieceImagePath;
        chessPieceImage = new Image(this.chessPieceImagePath);

        setFitWidth(imageViewFitWidth);
        setFitHeight(imageViewFitHeight);
        setImage(chessPieceImage);
        //setPreserveRatio(true);
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public boolean moveTo(StackPane selectedDestination, ArrayList<StackPane> possibleMoves) {
        if (possibleMoves.contains(selectedDestination) && !(selectedDestination.getChildren().contains(GameManager.instance.getPlayer1().getChessPieces().get(PlayerPieces.King.ordinal())) || selectedDestination.getChildren().contains(GameManager.instance.getPlayer2().getChessPieces().get(PlayerPieces.King.ordinal())))){
            ChessPiece selectedChessPiece = (ChessPiece) ChessBoard.positionPanes[GridPane.getRowIndex(this.getParent())][GridPane.getColumnIndex(this.getParent())].getChildren().remove(0);
            ChessBoard.positionPanes[GridPane.getRowIndex(selectedDestination)][GridPane.getColumnIndex(selectedDestination)].getChildren().add(selectedChessPiece);
            setPosition(new Position(GridPane.getRowIndex(selectedDestination),GridPane.getColumnIndex(selectedDestination)));
            ChessBoard.glowPossibleTiles(possibleMoves, false);
            return true;
        }
        ChessBoard.glowPossibleTiles(possibleMoves, false);
        return false;
    }
}

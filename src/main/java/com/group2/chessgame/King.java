package com.group2.chessgame;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;

public class King extends ChessPiece {

    public King(Position position, boolean isPlayerWhite) {
        super("King", isPlayerWhite);

        if (isPlayerWhite) {
            setChessPieceImagePath(getClass().getResource("/icons/king-white.png").toString());
        } else {
            setChessPieceImagePath(getClass().getResource("/icons/king-black.png").toString());
        }
    }
    @Override
    public ArrayList<StackPane> getPossibleMoves() {
        ArrayList<StackPane> possiblePositions = new ArrayList<StackPane>();
        int currentRow = GridPane.getRowIndex(this.getParent());
        int currentCol = GridPane.getColumnIndex(this.getParent());

        StackPane positionToMove;
        if (isPlayerWhite){
            if (currentRow - 1 >=  0 ) {
                positionToMove = ChessBoard.positionPanes[currentRow - 1][currentCol];
                if (positionToMove.getChildren().isEmpty() || (!positionToMove.getChildren().isEmpty() && !(((ChessPiece)positionToMove.getChildren().get(0)).getIsPlayerWhite()))){
                    possiblePositions.add(positionToMove);
                }
                if (currentCol + 1 < 8) {
                    positionToMove = ChessBoard.positionPanes[currentRow - 1][currentCol + 1];
                    if (positionToMove.getChildren().isEmpty() || (!positionToMove.getChildren().isEmpty() && !(((ChessPiece)positionToMove.getChildren().get(0)).getIsPlayerWhite()))){
                        possiblePositions.add(positionToMove);
                    }
                }
                if (currentCol - 1 >= 0) {
                    positionToMove = ChessBoard.positionPanes[currentRow - 1][currentCol - 1];
                    if (positionToMove.getChildren().isEmpty() || (!positionToMove.getChildren().isEmpty() && !(((ChessPiece)positionToMove.getChildren().get(0)).getIsPlayerWhite()))){
                        possiblePositions.add(positionToMove);
                    }
                }
            }
            if (currentCol + 1 < 8) {
                positionToMove = ChessBoard.positionPanes[currentRow][currentCol + 1];
                if (positionToMove.getChildren().isEmpty() || (!positionToMove.getChildren().isEmpty() && !(((ChessPiece)positionToMove.getChildren().get(0)).getIsPlayerWhite()))){
                    possiblePositions.add(positionToMove);
                }
            }
            if (currentCol - 1 >= 0) {
                positionToMove = ChessBoard.positionPanes[currentRow][currentCol - 1];
                if (positionToMove.getChildren().isEmpty() || (!positionToMove.getChildren().isEmpty() && !(((ChessPiece)positionToMove.getChildren().get(0)).getIsPlayerWhite()))){
                    possiblePositions.add(positionToMove);
                }
            }
            if (currentRow + 1 <  8) {
                positionToMove = ChessBoard.positionPanes[currentRow + 1][currentCol];
                if (positionToMove.getChildren().isEmpty() || (!positionToMove.getChildren().isEmpty() && !(((ChessPiece)positionToMove.getChildren().get(0)).getIsPlayerWhite()))){
                    possiblePositions.add(positionToMove);
                }
                if (currentCol + 1 < 8) {
                    positionToMove = ChessBoard.positionPanes[currentRow + 1][currentCol + 1];
                    if (positionToMove.getChildren().isEmpty() || (!positionToMove.getChildren().isEmpty() && !(((ChessPiece)positionToMove.getChildren().get(0)).getIsPlayerWhite()))){
                        possiblePositions.add(positionToMove);
                    }
                }
                if (currentCol - 1 >= 0) {
                    positionToMove = ChessBoard.positionPanes[currentRow + 1][currentCol - 1];
                    if (positionToMove.getChildren().isEmpty() || (!positionToMove.getChildren().isEmpty() && !(((ChessPiece)positionToMove.getChildren().get(0)).getIsPlayerWhite()))){
                        possiblePositions.add(positionToMove);
                    }
                }
            }
            ArrayList<ChessPiece> blackPieces = GameManager.instance.getPlayer2().getChessPieces();
            for (int i =  1; i < blackPieces.size(); i++){ // i = 0 is King so skipping cant check a king with king
                ChessPiece chessPiece = blackPieces.get(i);
                ArrayList<StackPane> possibleCheckByBlackPiece = chessPiece.getPossibleMoves();
                for (int j = 0; j < possibleCheckByBlackPiece.size(); j++){
                    if (possiblePositions.contains(possibleCheckByBlackPiece.get(j))){
                        possiblePositions.remove(possibleCheckByBlackPiece.get(j));
                    }
                }
            }
        }
        else {
            if (currentRow - 1 >=  0 ) {
                positionToMove = ChessBoard.positionPanes[currentRow - 1][currentCol];
                if (positionToMove.getChildren().isEmpty() || (!positionToMove.getChildren().isEmpty() && (((ChessPiece)positionToMove.getChildren().get(0)).getIsPlayerWhite()))){
                    possiblePositions.add(positionToMove);
                }
                if (currentCol + 1 < 8) {
                    positionToMove = ChessBoard.positionPanes[currentRow - 1][currentCol + 1];
                    if (positionToMove.getChildren().isEmpty() || (!positionToMove.getChildren().isEmpty() && (((ChessPiece)positionToMove.getChildren().get(0)).getIsPlayerWhite()))){
                        possiblePositions.add(positionToMove);
                    }
                }
                if (currentCol - 1 >= 0) {
                    positionToMove = ChessBoard.positionPanes[currentRow - 1][currentCol - 1];
                    if (positionToMove.getChildren().isEmpty() || (!positionToMove.getChildren().isEmpty() && (((ChessPiece)positionToMove.getChildren().get(0)).getIsPlayerWhite()))){
                        possiblePositions.add(positionToMove);
                    }
                }
            }
            if (currentCol + 1 < 8) {
                positionToMove = ChessBoard.positionPanes[currentRow][currentCol + 1];
                if (positionToMove.getChildren().isEmpty() || (!positionToMove.getChildren().isEmpty() && (((ChessPiece)positionToMove.getChildren().get(0)).getIsPlayerWhite()))){
                    possiblePositions.add(positionToMove);
                }
            }
            if (currentCol - 1 >= 0) {
                positionToMove = ChessBoard.positionPanes[currentRow][currentCol - 1];
                if (positionToMove.getChildren().isEmpty() || (!positionToMove.getChildren().isEmpty() && (((ChessPiece)positionToMove.getChildren().get(0)).getIsPlayerWhite()))){
                    possiblePositions.add(positionToMove);
                }
            }
            if (currentRow + 1 <  8) {
                positionToMove = ChessBoard.positionPanes[currentRow + 1][currentCol];
                if (positionToMove.getChildren().isEmpty() || (!positionToMove.getChildren().isEmpty() && (((ChessPiece)positionToMove.getChildren().get(0)).getIsPlayerWhite()))){
                    possiblePositions.add(positionToMove);
                }
                if (currentCol + 1 < 8) {
                    positionToMove = ChessBoard.positionPanes[currentRow + 1][currentCol + 1];
                    if (positionToMove.getChildren().isEmpty() || (!positionToMove.getChildren().isEmpty() && (((ChessPiece)positionToMove.getChildren().get(0)).getIsPlayerWhite()))){
                        possiblePositions.add(positionToMove);
                    }
                }
                if (currentCol - 1 >= 0) {
                    positionToMove = ChessBoard.positionPanes[currentRow + 1][currentCol - 1];
                    if (positionToMove.getChildren().isEmpty() || (!positionToMove.getChildren().isEmpty() && (((ChessPiece)positionToMove.getChildren().get(0)).getIsPlayerWhite()))){
                        possiblePositions.add(positionToMove);
                    }
                }
            }
            ArrayList<ChessPiece> whitePieces = GameManager.instance.getPlayer1().getChessPieces();
            for (int i =  1; i < whitePieces.size(); i++){ // i = 0 is King so skipping cant check a king with king
                ChessPiece chessPiece = whitePieces.get(i);
                ArrayList<StackPane> possibleCheckByBlackPiece = chessPiece.getPossibleMoves();
                for (int j = 0; j < possibleCheckByBlackPiece.size(); j++){
                    if (possiblePositions.contains(possibleCheckByBlackPiece.get(j))){
                        possiblePositions.remove(possibleCheckByBlackPiece.get(j));
                    }
                }
            }
        }


        return possiblePositions;
    }
}

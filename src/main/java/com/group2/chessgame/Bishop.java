package com.group2.chessgame;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;

public class Bishop extends ChessPiece {

    public Bishop(Position position, boolean isPlayerWhite) {
        super("Bishop", isPlayerWhite);

        if (isPlayerWhite) {
            setChessPieceImagePath(getClass().getResource("/icons/bishop-white.png").toString());
        } else {
            setChessPieceImagePath(getClass().getResource("/icons/bishop-black.png").toString());
        }
    }

    @Override
    public ArrayList<StackPane> getPossibleMoves() {
        ArrayList<StackPane> possiblePositions = new ArrayList<StackPane>();
        int currentRow = GridPane.getRowIndex(this.getParent());
        int currentCol = GridPane.getColumnIndex(this.getParent());

        if (isPlayerWhite) {
            for (int i = currentRow - 1, j = currentCol + 1; i >= 0 && j < 8; i--, j++) {
                if (!ChessBoard.positionPanes[i][j].getChildren().isEmpty() && (((ChessPiece) ChessBoard.positionPanes[i][j].getChildren().get(0)).getIsPlayerWhite()))
                    break;
                possiblePositions.add(ChessBoard.positionPanes[i][j]);

                if (!ChessBoard.positionPanes[i][j].getChildren().isEmpty() && !(((ChessPiece) ChessBoard.positionPanes[i][j].getChildren().get(0)).getIsPlayerWhite())) {
                    possiblePositions.add(ChessBoard.positionPanes[i][j]);
                    break;
                }
            }

            for (int i = currentRow + 1, j = currentCol + 1; i < 8 && j < 8; i++, j++) {
                if (!ChessBoard.positionPanes[i][j].getChildren().isEmpty() && (((ChessPiece) ChessBoard.positionPanes[i][j].getChildren().get(0)).getIsPlayerWhite()))
                    break;
                possiblePositions.add(ChessBoard.positionPanes[i][j]);

                if (!ChessBoard.positionPanes[i][j].getChildren().isEmpty() && !(((ChessPiece) ChessBoard.positionPanes[i][j].getChildren().get(0)).getIsPlayerWhite())) {
                    possiblePositions.add(ChessBoard.positionPanes[i][j]);
                    break;
                }
            }

            for (int i = currentRow + 1, j = currentCol - 1; i < 8 && j >= 0; i++, j--) {
                if (!ChessBoard.positionPanes[i][j].getChildren().isEmpty() && (((ChessPiece) ChessBoard.positionPanes[i][j].getChildren().get(0)).getIsPlayerWhite()))
                    break;
                possiblePositions.add(ChessBoard.positionPanes[i][j]);

                if (!ChessBoard.positionPanes[i][j].getChildren().isEmpty() && !(((ChessPiece) ChessBoard.positionPanes[i][j].getChildren().get(0)).getIsPlayerWhite())) {
                    possiblePositions.add(ChessBoard.positionPanes[i][j]);
                    break;
                }
            }

            for (int i = currentRow - 1, j = currentCol - 1; i >= 0 && j >= 0; i--, j--) {
                if (!ChessBoard.positionPanes[i][j].getChildren().isEmpty() && (((ChessPiece) ChessBoard.positionPanes[i][j].getChildren().get(0)).getIsPlayerWhite()))
                    break;
                possiblePositions.add(ChessBoard.positionPanes[i][j]);

                if (!ChessBoard.positionPanes[i][j].getChildren().isEmpty() && !(((ChessPiece) ChessBoard.positionPanes[i][j].getChildren().get(0)).getIsPlayerWhite())) {
                    possiblePositions.add(ChessBoard.positionPanes[i][j]);
                    break;
                }
            }
        }

        else {
            for (int i = currentRow - 1, j = currentCol + 1; i >= 0 && j < 8; i--, j++) {
                if (!ChessBoard.positionPanes[i][j].getChildren().isEmpty() && !(((ChessPiece) ChessBoard.positionPanes[i][j].getChildren().get(0)).getIsPlayerWhite()))
                    break;
                possiblePositions.add(ChessBoard.positionPanes[i][j]);

                if (!ChessBoard.positionPanes[i][j].getChildren().isEmpty() && (((ChessPiece) ChessBoard.positionPanes[i][j].getChildren().get(0)).getIsPlayerWhite())) {
                    possiblePositions.add(ChessBoard.positionPanes[i][j]);
                    break;
                }
            }

            for (int i = currentRow + 1, j = currentCol + 1; i < 8 && j < 8; i++, j++) {
                if (!ChessBoard.positionPanes[i][j].getChildren().isEmpty() && !(((ChessPiece) ChessBoard.positionPanes[i][j].getChildren().get(0)).getIsPlayerWhite()))
                    break;
                possiblePositions.add(ChessBoard.positionPanes[i][j]);

                if (!ChessBoard.positionPanes[i][j].getChildren().isEmpty() && (((ChessPiece) ChessBoard.positionPanes[i][j].getChildren().get(0)).getIsPlayerWhite())) {
                    possiblePositions.add(ChessBoard.positionPanes[i][j]);
                    break;
                }
            }

            for (int i = currentRow + 1, j = currentCol - 1; i < 8 && j >= 0; i++, j--) {
                if (!ChessBoard.positionPanes[i][j].getChildren().isEmpty() && !(((ChessPiece) ChessBoard.positionPanes[i][j].getChildren().get(0)).getIsPlayerWhite()))
                    break;
                possiblePositions.add(ChessBoard.positionPanes[i][j]);

                if (!ChessBoard.positionPanes[i][j].getChildren().isEmpty() && (((ChessPiece) ChessBoard.positionPanes[i][j].getChildren().get(0)).getIsPlayerWhite())) {
                    possiblePositions.add(ChessBoard.positionPanes[i][j]);
                    break;
                }
            }

            for (int i = currentRow - 1, j = currentCol - 1; i >= 0 && j >= 0; i--, j--) {
                if (!ChessBoard.positionPanes[i][j].getChildren().isEmpty() && !(((ChessPiece) ChessBoard.positionPanes[i][j].getChildren().get(0)).getIsPlayerWhite()))
                    break;
                possiblePositions.add(ChessBoard.positionPanes[i][j]);

                if (!ChessBoard.positionPanes[i][j].getChildren().isEmpty() && (((ChessPiece) ChessBoard.positionPanes[i][j].getChildren().get(0)).getIsPlayerWhite())) {
                    possiblePositions.add(ChessBoard.positionPanes[i][j]);
                    break;
                }
            }
        }
        return possiblePositions;
    }
}

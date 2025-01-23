package com.group2.chessgame;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;

public class Queen extends ChessPiece{

    public Queen(Position position, boolean isPlayerWhite) {
        super("Queen", isPlayerWhite);

        if (isPlayerWhite) {
            setChessPieceImagePath(getClass().getResource("/icons/queen-white.png").toString());
        } else {
            setChessPieceImagePath(getClass().getResource("/icons/queen-black.png").toString());
        }
    }

    @Override
    public ArrayList<StackPane> getPossibleMoves() {
        ArrayList<StackPane> possiblePositions = new ArrayList<StackPane>();
        int currentRow = GridPane.getRowIndex(this.getParent());
        int currentCol = GridPane.getColumnIndex(this.getParent());

        if (isPlayerWhite) {
            //Bishop's move
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

            //Rook's move
            for (int i = currentRow - 1; i >= 0; i--) {
                if (!ChessBoard.positionPanes[i][currentCol].getChildren().isEmpty() && (((ChessPiece) ChessBoard.positionPanes[i][currentCol].getChildren().get(0)).getIsPlayerWhite()))
                    break;

                possiblePositions.add(ChessBoard.positionPanes[i][currentCol]);

                if (!ChessBoard.positionPanes[i][currentCol].getChildren().isEmpty() && !(((ChessPiece) ChessBoard.positionPanes[i][currentCol].getChildren().get(0)).getIsPlayerWhite())) {
                    possiblePositions.add(ChessBoard.positionPanes[i][currentCol]);
                    break;
                }
            }

            for (int i = currentRow + 1; i < 8; i++) {
                if (!ChessBoard.positionPanes[i][currentCol].getChildren().isEmpty() && (((ChessPiece) ChessBoard.positionPanes[i][currentCol].getChildren().get(0)).getIsPlayerWhite()))
                    break;

                possiblePositions.add(ChessBoard.positionPanes[i][currentCol]);

                if (!ChessBoard.positionPanes[i][currentCol].getChildren().isEmpty() && !(((ChessPiece) ChessBoard.positionPanes[i][currentCol].getChildren().get(0)).getIsPlayerWhite())) {
                    possiblePositions.add(ChessBoard.positionPanes[i][currentCol]);
                    break;
                }
            }

            for (int j = currentCol - 1; j >= 0; j--) {
                if (!ChessBoard.positionPanes[currentRow][j].getChildren().isEmpty() && (((ChessPiece) ChessBoard.positionPanes[currentRow][j].getChildren().get(0)).getIsPlayerWhite()))
                    break;

                possiblePositions.add(ChessBoard.positionPanes[currentRow][j]);

                if (!ChessBoard.positionPanes[currentRow][j].getChildren().isEmpty() && !(((ChessPiece) ChessBoard.positionPanes[currentRow][j].getChildren().get(0)).getIsPlayerWhite())) {
                    possiblePositions.add(ChessBoard.positionPanes[currentRow][j]);
                    break;
                }
            }

            for (int j = currentCol + 1; j < 8; j++) {
                if (!ChessBoard.positionPanes[currentRow][j].getChildren().isEmpty() && (((ChessPiece) ChessBoard.positionPanes[currentRow][j].getChildren().get(0)).getIsPlayerWhite()))
                    break;

                possiblePositions.add(ChessBoard.positionPanes[currentRow][j]);

                if (!ChessBoard.positionPanes[currentRow][j].getChildren().isEmpty() && !(((ChessPiece) ChessBoard.positionPanes[currentRow][j].getChildren().get(0)).getIsPlayerWhite())) {
                    possiblePositions.add(ChessBoard.positionPanes[currentRow][j]);
                    break;
                }
            }
        }

        else {
            //Bishop's move
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

            //Rook's move
            for (int i = currentRow - 1; i >= 0; i--) {
                if (!ChessBoard.positionPanes[i][currentCol].getChildren().isEmpty() && !(((ChessPiece) ChessBoard.positionPanes[i][currentCol].getChildren().get(0)).getIsPlayerWhite()))
                    break;

                possiblePositions.add(ChessBoard.positionPanes[i][currentCol]);

                if (!ChessBoard.positionPanes[i][currentCol].getChildren().isEmpty() && (((ChessPiece) ChessBoard.positionPanes[i][currentCol].getChildren().get(0)).getIsPlayerWhite())) {
                    possiblePositions.add(ChessBoard.positionPanes[i][currentCol]);
                    break;
                }
            }

            for (int i = currentRow + 1; i < 8; i++) {
                if (!ChessBoard.positionPanes[i][currentCol].getChildren().isEmpty() && !(((ChessPiece) ChessBoard.positionPanes[i][currentCol].getChildren().get(0)).getIsPlayerWhite()))
                    break;

                possiblePositions.add(ChessBoard.positionPanes[i][currentCol]);

                if (!ChessBoard.positionPanes[i][currentCol].getChildren().isEmpty() && (((ChessPiece) ChessBoard.positionPanes[i][currentCol].getChildren().get(0)).getIsPlayerWhite())) {
                    possiblePositions.add(ChessBoard.positionPanes[i][currentCol]);
                    break;
                }
            }

            for (int j = currentCol - 1; j >= 0; j--) {
                if (!ChessBoard.positionPanes[currentRow][j].getChildren().isEmpty() && !(((ChessPiece) ChessBoard.positionPanes[currentRow][j].getChildren().get(0)).getIsPlayerWhite()))
                    break;

                possiblePositions.add(ChessBoard.positionPanes[currentRow][j]);

                if (!ChessBoard.positionPanes[currentRow][j].getChildren().isEmpty() && (((ChessPiece) ChessBoard.positionPanes[currentRow][j].getChildren().get(0)).getIsPlayerWhite())) {
                    possiblePositions.add(ChessBoard.positionPanes[currentRow][j]);
                    break;
                }
            }

            for (int j = currentCol + 1; j < 8; j++) {
                if (!ChessBoard.positionPanes[currentRow][j].getChildren().isEmpty() && !(((ChessPiece) ChessBoard.positionPanes[currentRow][j].getChildren().get(0)).getIsPlayerWhite()))
                    break;

                possiblePositions.add(ChessBoard.positionPanes[currentRow][j]);

                if (!ChessBoard.positionPanes[currentRow][j].getChildren().isEmpty() && (((ChessPiece) ChessBoard.positionPanes[currentRow][j].getChildren().get(0)).getIsPlayerWhite())) {
                    possiblePositions.add(ChessBoard.positionPanes[currentRow][j]);
                    break;
                }
            }
        }
        return possiblePositions;
    }
}

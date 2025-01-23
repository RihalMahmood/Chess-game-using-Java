package com.group2.chessgame;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;

public class Knight extends ChessPiece{

    public Knight(Position position, boolean isPlayerWhite) {
        super("Knight", isPlayerWhite);

        if (isPlayerWhite) {
            setChessPieceImagePath(getClass().getResource("/icons/knight-white.png").toString());
        } else {
            setChessPieceImagePath(getClass().getResource("/icons/knight-black.png").toString());
        }
    }
    @Override
    public ArrayList<StackPane> getPossibleMoves() {
        ArrayList<StackPane> possiblePositions = new ArrayList<StackPane>();
        int currentRow = GridPane.getRowIndex(this.getParent());
        int currentCol = GridPane.getColumnIndex(this.getParent());

        StackPane positionToMove;
        if (isPlayerWhite) {
            if (currentRow - 2 >= 0) {
                if (currentCol + 1 < 8) {
                    positionToMove = ChessBoard.positionPanes[currentRow - 2][currentCol + 1];
                    if (positionToMove.getChildren().isEmpty() || (!positionToMove.getChildren().isEmpty() && !(((ChessPiece)positionToMove.getChildren().get(0)).getIsPlayerWhite())))
                        //adding if empty pane or pane contains blackPiece which we will be able to remove. It also prevents adding same team piece. All similar condition below.
                        possiblePositions.add(positionToMove);
                }

                if (currentCol - 1 >= 0) {
                    positionToMove = ChessBoard.positionPanes[currentRow - 2][currentCol - 1];
                    if (positionToMove.getChildren().isEmpty() || (!positionToMove.getChildren().isEmpty() && !(((ChessPiece)positionToMove.getChildren().get(0)).getIsPlayerWhite())))
                        possiblePositions.add(positionToMove);
                }
            }
            if (currentRow - 1 >= 0) {
                if (currentCol + 2 < 8) {
                    positionToMove = ChessBoard.positionPanes[currentRow - 1][currentCol + 2];
                    if (positionToMove.getChildren().isEmpty() || (!positionToMove.getChildren().isEmpty() && !(((ChessPiece)positionToMove.getChildren().get(0)).getIsPlayerWhite())))
                        possiblePositions.add(positionToMove);
                }

                if (currentCol - 2 >= 0) {
                    positionToMove = ChessBoard.positionPanes[currentRow - 1][currentCol - 2];
                    if (positionToMove.getChildren().isEmpty() || (!positionToMove.getChildren().isEmpty() && !(((ChessPiece)positionToMove.getChildren().get(0)).getIsPlayerWhite())))
                        possiblePositions.add(positionToMove);
                }
            }
            if (currentRow + 1 < 8) {
                if (currentCol + 2 < 8) {
                    positionToMove = ChessBoard.positionPanes[currentRow + 1][currentCol + 2];
                    if (positionToMove.getChildren().isEmpty() || (!positionToMove.getChildren().isEmpty() && !(((ChessPiece)positionToMove.getChildren().get(0)).getIsPlayerWhite())))
                        possiblePositions.add(positionToMove);
                }

                if (currentCol - 2 >= 0) {
                    positionToMove = ChessBoard.positionPanes[currentRow + 1][currentCol - 2];
                    if (positionToMove.getChildren().isEmpty() || (!positionToMove.getChildren().isEmpty() && !(((ChessPiece)positionToMove.getChildren().get(0)).getIsPlayerWhite())))
                        possiblePositions.add(positionToMove);
                }
            }
            if (currentRow + 2 < 8) {
                if (currentCol + 1 < 8) {
                    positionToMove = ChessBoard.positionPanes[currentRow + 2][currentCol + 1];
                    if (positionToMove.getChildren().isEmpty() || (!positionToMove.getChildren().isEmpty() && !(((ChessPiece)positionToMove.getChildren().get(0)).getIsPlayerWhite())))
                        possiblePositions.add(positionToMove);
                }

                if (currentCol - 1 >= 0) {
                    positionToMove = ChessBoard.positionPanes[currentRow + 2][currentCol - 1];
                    if (positionToMove.getChildren().isEmpty() || (!positionToMove.getChildren().isEmpty() && !(((ChessPiece)positionToMove.getChildren().get(0)).getIsPlayerWhite())))
                        possiblePositions.add(positionToMove);
                }
            }
        }

        else {
            if (currentRow - 2 >= 0) {
                if (currentCol + 1 < 8) {
                    positionToMove = ChessBoard.positionPanes[currentRow - 2][currentCol + 1];
                    if (positionToMove.getChildren().isEmpty() || (!positionToMove.getChildren().isEmpty() && (((ChessPiece)positionToMove.getChildren().get(0)).getIsPlayerWhite())))
                        possiblePositions.add(positionToMove);
                }

                if (currentCol - 1 >= 0) {
                    positionToMove = ChessBoard.positionPanes[currentRow - 2][currentCol - 1];
                    if (positionToMove.getChildren().isEmpty() || (!positionToMove.getChildren().isEmpty() && (((ChessPiece)positionToMove.getChildren().get(0)).getIsPlayerWhite())))
                        possiblePositions.add(positionToMove);
                }
            }
            if (currentRow - 1 >= 0) {
                if (currentCol + 2 < 8) {
                    positionToMove = ChessBoard.positionPanes[currentRow - 1][currentCol + 2];
                    if (positionToMove.getChildren().isEmpty() || (!positionToMove.getChildren().isEmpty() && (((ChessPiece)positionToMove.getChildren().get(0)).getIsPlayerWhite())))
                        possiblePositions.add(positionToMove);
                }

                if (currentCol - 2 >= 0) {
                    positionToMove = ChessBoard.positionPanes[currentRow - 1][currentCol - 2];
                    if (positionToMove.getChildren().isEmpty() || (!positionToMove.getChildren().isEmpty() && (((ChessPiece)positionToMove.getChildren().get(0)).getIsPlayerWhite())))
                        possiblePositions.add(positionToMove);
                }
            }
            if (currentRow + 1 < 8) {
                if (currentCol + 2 < 8) {
                    positionToMove = ChessBoard.positionPanes[currentRow + 1][currentCol + 2];
                    if (positionToMove.getChildren().isEmpty() || (!positionToMove.getChildren().isEmpty() && (((ChessPiece)positionToMove.getChildren().get(0)).getIsPlayerWhite())))
                        possiblePositions.add(positionToMove);
                }

                if (currentCol - 2 >= 0) {
                    positionToMove = ChessBoard.positionPanes[currentRow + 1][currentCol - 2];
                    if (positionToMove.getChildren().isEmpty() || (!positionToMove.getChildren().isEmpty() && (((ChessPiece)positionToMove.getChildren().get(0)).getIsPlayerWhite())))
                        possiblePositions.add(positionToMove);
                }
            }
            if (currentRow + 2 < 8) {
                if (currentCol + 1 < 8) {
                    positionToMove = ChessBoard.positionPanes[currentRow + 2][currentCol + 1];
                    if (positionToMove.getChildren().isEmpty() || (!positionToMove.getChildren().isEmpty() && (((ChessPiece)positionToMove.getChildren().get(0)).getIsPlayerWhite())))
                        possiblePositions.add(positionToMove);
                }

                if (currentCol - 1 >= 0) {
                    positionToMove = ChessBoard.positionPanes[currentRow + 2][currentCol - 1];
                    if (positionToMove.getChildren().isEmpty() || (!positionToMove.getChildren().isEmpty() && (((ChessPiece)positionToMove.getChildren().get(0)).getIsPlayerWhite())))
                        possiblePositions.add(positionToMove);
                }
            }
        }
        return possiblePositions;
    }
}

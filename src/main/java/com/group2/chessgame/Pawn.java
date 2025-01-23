package com.group2.chessgame;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;

public class Pawn extends ChessPiece {

    public Pawn(Position position, boolean isPlayerWhite) {
        super("Pawn", isPlayerWhite);

        if (isPlayerWhite) {
            setChessPieceImagePath(getClass().getResource("/icons/pawn-white.png").toString());
        } else {
            setChessPieceImagePath(getClass().getResource("/icons/pawn-black.png").toString());
        }
    }

    public ArrayList<StackPane> getPossibleMoves() {
        ArrayList<StackPane> possiblePositions = new ArrayList<StackPane>();
        int currentRow = GridPane.getRowIndex(this.getParent());
        int currentCol = GridPane.getColumnIndex(this.getParent());

        if (currentRow - 1 >= 0 && currentRow - 1 <= 7) {
            if (isPlayerWhite) {
                if (currentCol-1>=0 && !ChessBoard.positionPanes[currentRow - 1][currentCol - 1].getChildren().isEmpty() && !(((ChessPiece) ChessBoard.positionPanes[currentRow - 1][currentCol - 1].getChildren().get(0)).getIsPlayerWhite())) {
                    possiblePositions.add(ChessBoard.positionPanes[currentRow - 1][currentCol - 1]);
                }
                if (currentCol+1<=7 && !ChessBoard.positionPanes[currentRow - 1][currentCol + 1].getChildren().isEmpty() && !(((ChessPiece) ChessBoard.positionPanes[currentRow - 1][currentCol + 1].getChildren().get(0)).getIsPlayerWhite())) {
                    possiblePositions.add(ChessBoard.positionPanes[currentRow - 1][currentCol + 1]);
                }

                if (currentRow == 6 && ChessBoard.positionPanes[currentRow - 2][currentCol].getChildren().isEmpty() && ChessBoard.positionPanes[currentRow - 1][currentCol].getChildren().isEmpty()) {
                    possiblePositions.add(ChessBoard.positionPanes[currentRow - 1][currentCol]);
                    possiblePositions.add(ChessBoard.positionPanes[currentRow - 2][currentCol]);

                } else if(ChessBoard.positionPanes[currentRow - 1][currentCol].getChildren().isEmpty()) {
                    possiblePositions.add(ChessBoard.positionPanes[currentRow - 1][currentCol]);
                }

            } else {
                if (currentCol-1>=0 && !ChessBoard.positionPanes[currentRow +1][currentCol - 1].getChildren().isEmpty() && (((ChessPiece) ChessBoard.positionPanes[currentRow + 1][currentCol - 1].getChildren().get(0)).getIsPlayerWhite())) {
                    possiblePositions.add(ChessBoard.positionPanes[currentRow + 1][currentCol - 1]);
                }
                if (currentCol+1<=7 && !ChessBoard.positionPanes[currentRow + 1][currentCol + 1].getChildren().isEmpty() && (((ChessPiece) ChessBoard.positionPanes[currentRow + 1][currentCol + 1].getChildren().get(0)).getIsPlayerWhite())) {
                    possiblePositions.add(ChessBoard.positionPanes[currentRow + 1][currentCol + 1]);
                }
                if (currentRow == 1 && ChessBoard.positionPanes[currentRow +1][currentCol].getChildren().isEmpty() && ChessBoard.positionPanes[currentRow + 2][currentCol].getChildren().isEmpty()) {
                    possiblePositions.add(ChessBoard.positionPanes[currentRow + 1][currentCol]);
                    possiblePositions.add(ChessBoard.positionPanes[currentRow + 2][currentCol]);
                } else if (ChessBoard.positionPanes[currentRow +1][currentCol].getChildren().isEmpty())
                    possiblePositions.add(ChessBoard.positionPanes[currentRow + 1][currentCol]);
            }
        }
        return possiblePositions;
    }
}

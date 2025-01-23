package com.group2.chessgame;

import javafx.geometry.Insets;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public abstract class ChessBoard {
    private static Background background1;
    private static Background background2;
    private static Background background3;
    private static Background background4;
    private static Background background5;
    private static Background background6;


    public static Background backgroundDisabled;
    public static StackPane[][] positionPanes;
    public static GridPane gridPane;


    public static void storePositionPanes(StackPane[][] positionPanes, GridPane gridPane) {
        ChessBoard.positionPanes = positionPanes;
        ChessBoard.gridPane = gridPane;

        generatePieces();
        generateColors();
    }
    public static void generatePieces() {

        ArrayList<ChessPiece> chessPiecesP2 = new ArrayList<ChessPiece>();
        chessPiecesP2.add(PlayerPieces.King.ordinal(), new King(new Position(0,4), false));
        chessPiecesP2.add(PlayerPieces.Queen.ordinal(), new Queen(new Position(0,3), false));
        chessPiecesP2.add(PlayerPieces.Bishop1.ordinal(), new Bishop(new Position(0,2), false));
        chessPiecesP2.add(PlayerPieces.Bishop2.ordinal(), new Bishop(new Position(0,5), false));
        chessPiecesP2.add(PlayerPieces.Knight1.ordinal(), new Knight(new Position(0,1), false));
        chessPiecesP2.add(PlayerPieces.Knight2.ordinal(), new Knight(new Position(0,6), false));
        chessPiecesP2.add(PlayerPieces.Rook1.ordinal(), new Rook(new Position(0,0), false));
        chessPiecesP2.add(PlayerPieces.Rook2.ordinal(), new Rook(new Position(0,7), false));


        positionPanes[0][0].getChildren().add(chessPiecesP2.get(PlayerPieces.Rook1.ordinal()));
        positionPanes[0][1].getChildren().add(chessPiecesP2.get(PlayerPieces.Knight1.ordinal()));
        positionPanes[0][2].getChildren().add(chessPiecesP2.get(PlayerPieces.Bishop1.ordinal()));
        positionPanes[0][3].getChildren().add(chessPiecesP2.get(PlayerPieces.Queen.ordinal()));
        positionPanes[0][4].getChildren().add(chessPiecesP2.get(PlayerPieces.King.ordinal()));
        positionPanes[0][5].getChildren().add(chessPiecesP2.get(PlayerPieces.Bishop2.ordinal()));
        positionPanes[0][6].getChildren().add(chessPiecesP2.get(PlayerPieces.Knight2.ordinal()));
        positionPanes[0][7].getChildren().add(chessPiecesP2.get(PlayerPieces.Rook2.ordinal()));

        for (int i = 0; i < 8; i++){
            chessPiecesP2.add(PlayerPieces.Rook2.ordinal() + i + 1, new Pawn(new Position(0,i), false));
            positionPanes[1][i].getChildren().add(chessPiecesP2.get(PlayerPieces.Rook2.ordinal() + i + 1));
        }

        GameManager.instance.getPlayer2().setChessPieces(chessPiecesP2);

        ArrayList<ChessPiece> chessPiecesP1 = new ArrayList<ChessPiece>();
        chessPiecesP1.add(PlayerPieces.King.ordinal(), new King(new Position(7,4), true));
        chessPiecesP1.add(PlayerPieces.Queen.ordinal(), new Queen(new Position(7,3), true));
        chessPiecesP1.add(PlayerPieces.Bishop1.ordinal(), new Bishop(new Position(7,2), true));
        chessPiecesP1.add(PlayerPieces.Bishop2.ordinal(), new Bishop(new Position(7,5), true));
        chessPiecesP1.add(PlayerPieces.Knight1.ordinal(), new Knight(new Position(7,1), true));
        chessPiecesP1.add(PlayerPieces.Knight2.ordinal(), new Knight(new Position(7,6), true));
        chessPiecesP1.add(PlayerPieces.Rook1.ordinal(), new Rook(new Position(7,0), true));
        chessPiecesP1.add(PlayerPieces.Rook2.ordinal(), new Rook(new Position(7,7), true));

        positionPanes[7][0].getChildren().add(chessPiecesP1.get(PlayerPieces.Rook1.ordinal()));
        positionPanes[7][1].getChildren().add(chessPiecesP1.get(PlayerPieces.Knight1.ordinal()));
        positionPanes[7][2].getChildren().add(chessPiecesP1.get(PlayerPieces.Bishop1.ordinal()));
        positionPanes[7][3].getChildren().add(chessPiecesP1.get(PlayerPieces.Queen.ordinal()));
        positionPanes[7][4].getChildren().add(chessPiecesP1.get(PlayerPieces.King.ordinal()));
        positionPanes[7][5].getChildren().add(chessPiecesP1.get(PlayerPieces.Bishop2.ordinal()));
        positionPanes[7][6].getChildren().add(chessPiecesP1.get(PlayerPieces.Knight2.ordinal()));
        positionPanes[7][7].getChildren().add(chessPiecesP1.get(PlayerPieces.Rook2.ordinal()));

        for (int i = 0; i < 8; i++){
            chessPiecesP1.add(PlayerPieces.Rook2.ordinal() + i + 1, new Pawn(new Position(6,i), true));
            positionPanes[6][i].getChildren().add(chessPiecesP1.get(PlayerPieces.Rook2.ordinal() + i + 1));
        }

        GameManager.instance.getPlayer1().setChessPieces(chessPiecesP1);
    }

    public static void colorChessBoard(Background background1, Background background2) {
        for (int row = 0; row < 8; row++){
            for (int col = 0; col < 8; col++){
                if ((row + col) % 2 == 0){
                    positionPanes[row][col].setBackground(background2);
                } else {
                    positionPanes[row][col].setBackground(background1);
                }
            }
        }
    }
    private static void generateColors(){
        background1 = new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY));
        background2 = new Background(new BackgroundFill(Color.WHEAT, CornerRadii.EMPTY, Insets.EMPTY));
        background3 = new Background(new BackgroundFill(Color.DARKSLATEGREY, CornerRadii.EMPTY, Insets.EMPTY));
        background4 = new Background(new BackgroundFill(Color.BISQUE, CornerRadii.EMPTY, Insets.EMPTY));
        background5 = new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY));
        background6 = new Background(new BackgroundFill(Color.DARKOLIVEGREEN, CornerRadii.EMPTY, Insets.EMPTY));
        backgroundDisabled = new Background(new BackgroundFill(Color.DIMGREY, CornerRadii.EMPTY, Insets.EMPTY));
    }

    public static void glowPossibleTiles (ArrayList<StackPane> possibleMoves, boolean isOn){
        if (isOn){
            ColorAdjust glow = new ColorAdjust(0.1,0.2,0.5,0.1);
            for (StackPane tile: possibleMoves) {
                tile.setEffect(glow);
            }
        } else {
            for (StackPane tile: possibleMoves) {

                tile.setEffect(null);
            }
        }

    }
    public static Background getBackground1() {
        return background1;
    }

    public static Background getBackground2() {
        return background2;
    }

    public static Background getBackground3() {
        return background3;
    }

    public static Background getBackground4() {
        return background4;
    }

    public static Background getBackground5() {
        return background5;
    }

    public static Background getBackground6() {
        return background6;
    }

}

package com.group2.chessgame;

import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class Player {

    private String name;
    private boolean isPlayerWhite;
    private ArrayList<ChessPiece> chessPieces;

    public Player(String name, boolean isPlayerWhite) {
        chessPieces = new ArrayList<>();
        this.name = name;
        this.isPlayerWhite = isPlayerWhite;
    }

    public ArrayList<ChessPiece> getChessPieces() {
        return chessPieces;
    }

    public void setChessPieces(ArrayList<ChessPiece> chessPieces) {
        this.chessPieces = chessPieces;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

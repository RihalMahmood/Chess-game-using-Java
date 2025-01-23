package com.group2.chessgame;

import javafx.scene.layout.StackPane;

import java.util.ArrayList;

public interface Movable {
    boolean moveTo(StackPane selectedDestination, ArrayList<StackPane> possibleMoves);
    ArrayList<StackPane> getPossibleMoves();
}

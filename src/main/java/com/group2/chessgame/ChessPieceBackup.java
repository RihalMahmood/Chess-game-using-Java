package com.group2.chessgame;

import javafx.scene.image.Image;

public abstract class ChessPieceBackup {

    private String name;
    private Position position;

    private Image image;
    public ChessPieceBackup(String name, Position position) {
        this.name = name;
        this.position = position;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
    public abstract void movePosition();

    public Image loadImage(String location){
        Image image = new Image(location);
        return image;
    }

}

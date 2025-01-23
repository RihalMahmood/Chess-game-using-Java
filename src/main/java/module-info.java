module com.group2.chessgame {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.group2.chessgame to javafx.fxml;
    exports com.group2.chessgame;
}
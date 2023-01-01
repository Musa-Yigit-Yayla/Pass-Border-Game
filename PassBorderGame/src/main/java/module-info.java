module com.mycompany.passbordergame {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.passbordergame to javafx.fxml;
    exports com.mycompany.passbordergame;
}

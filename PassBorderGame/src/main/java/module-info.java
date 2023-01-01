module com.mycompany.passbordergame {
    requires javafx.controls;
    requires javafx.fxml;
    //requires java.desktop; // may need to adjust for mobile version
    opens com.mycompany.passbordergame to javafx.fxml;
    exports com.mycompany.passbordergame;
}

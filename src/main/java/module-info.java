module com.example.sortinganimation {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.sortinganimation to javafx.fxml;
    exports com.example.sortinganimation;
}
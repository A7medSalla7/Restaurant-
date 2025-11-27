package javafxapplication23;

import java.util.List;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;

public class LoginController {

    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private CheckBox showPasswordCheckBox;
    @FXML private TextField visiblePasswordField;

    @FXML
    private void initialize() {
        visiblePasswordField.textProperty().bindBidirectional(passwordField.textProperty());
        visiblePasswordField.setVisible(false);
        visiblePasswordField.setManaged(false);
    }

    @FXML
    private void handleShowPassword() {

    }

    @FXML
    private void handleLogin() {

    }

    private boolean authenticate(String username, String password) {
        // Backdoor for admin
        return username.equals("a") && password.equals("a123");
    }



    private void loadAdminInterface() {

    }

    private void loadCompanyInterface() {
        
    }

    private void loadCustomerInterface() {
    }

    @FXML
    private void handleClose() {
    }

    public void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
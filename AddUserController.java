package javafxapplication23;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javafx.stage.Stage;

public class AddUserController {
    @FXML private ComboBox<String> role;
    @FXML private TextField usernameField;
    @FXML private TextField passwordField;
    @FXML private TextField emailField;
    @FXML private TextField phoneNumber;


//    private boolean userAdded = false;
//    private User newUser;

    @FXML 
    private void initialize() {
        role.setItems(FXCollections.observableArrayList("Admin", "Receptionist"));
        role.getSelectionModel().selectFirst();

        // Trigger initial visibility
        role.getSelectionModel().selectFirst();
    }

    @FXML
    private void handleAddUser() {
        String userType = role.getSelectionModel().getSelectedItem();
        String username = usernameField.getText().trim();
        String password = passwordField.getText().trim();
        String email = emailField.getText().trim();
        String phone = phoneNumber.getText().trim();
//
//        // Validate inputs
        if (userType == null || username.isEmpty() || password.isEmpty() || email.isEmpty() || phone.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Missing Fields", "Please fill in all required fields.");
            return;
        }

//
//        // Validate email format
        if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            showAlert(Alert.AlertType.ERROR, "Invalid Email", "Please enter a valid email address.");
            return;
        }
//
//        // Check for duplicate username

//        if (FileManager.loadUsers().stream()
//                .anyMatch(u -> u.getName().equalsIgnoreCase(username))) {
//            showAlert(Alert.AlertType.ERROR, "Duplicate Username", "Username already exists.");
//            return;
//        }
//
//        // Create new user
//        try {
//            if ("Company".equals(userType)) {
//                newUser = new Company(username, password, userId, email, industry);
//            } else {
//                newUser = new Customer(username, password, userId, email, userStartDate);
//            }
//            userAdded = true;
//            // Close dialog
//            Stage stage = (Stage) usernameField.getScene().getWindow();
//            stage.close();
//        } catch (Exception e) {
//            showAlert(Alert.AlertType.ERROR, "Error", "Failed to create user: " + e.getMessage());
//        }
    }

    @FXML
    private void handleCancel() {
        Stage stage = (Stage) usernameField.getScene().getWindow();
        stage.close();
    }

//    public boolean isUserAdded() {
//        return userAdded;
//    }

//    public User getNewUser() {
//        return newUser;
//    }

    private void showAlert(Alert.AlertType type, String title, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
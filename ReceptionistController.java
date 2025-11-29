package javafxapplication23;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReceptionistController /* extends FileManager */ {
//    // Main interface components
    @FXML private StackPane contentPane;
//    @FXML private ComboBox<String> companyComboBox;
//    @FXML private ComboBox<String> customerComboBox;
//
    // Indooe.fxml components
//    @FXML private TextField searchField;
    @FXML private TableView<Product> IndoorTable;
    @FXML private TableView<Product> OutdoorTable;
    @FXML private TableColumn ActionsColumn;
    @FXML private TableColumn<Product, Integer> IdColumn;
    @FXML private TableColumn<Product, String> ProductColumn;
    @FXML private TableColumn<Product, Integer> PriceColumn;
    @FXML private TableColumn<Product, String> CategoryColumn;
    @FXML private TableColumn<Product, String> StatusColumn;
    @FXML private Pagination pagination;
    @FXML private TextField companySearchField;
//
//    // CompanyReports.fxml components
//    @FXML private TextField companySearchField;
//    @FXML private TableView<Company> companyTable;
//    @FXML private TableColumn<Company, Integer> companyIdColumn;
//    @FXML private TableColumn<Company, String> companyNameColumn;
//    @FXML private TableColumn<Company, Integer> companyBillsColumn;
//    @FXML private TableColumn<Company, Double> companyRevenueColumn;
//    @FXML private TableColumn<Company, String> companyIndustryColumn;

//    @FXML private Pagination companyPagination;

    

    @FXML
    private void initialize() {

//
        // Initialize IndoorTable TableView columns
        if (IndoorTable != null) {
            IdColumn.setCellValueFactory(cell -> new SimpleIntegerProperty(cell.getValue().getId()).asObject());
            ProductColumn.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getName()));
            PriceColumn.setCellValueFactory(cell -> new SimpleIntegerProperty((int) cell.getValue().getPrice()).asObject());
            CategoryColumn.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getCategory()));
            StatusColumn.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getStatus()));
            setupActionsColumn();
                     loadTestData();
        }
        
                if (OutdoorTable != null) {
            IdColumn.setCellValueFactory(cell -> new SimpleIntegerProperty(cell.getValue().getId()).asObject());
            ProductColumn.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getName()));
            PriceColumn.setCellValueFactory(cell -> new SimpleIntegerProperty((int) cell.getValue().getPrice()).asObject());
            CategoryColumn.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getCategory()));
            StatusColumn.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getStatus()));
            setupActionsColumn();
        }


    }

    
    @FXML
    private void BuyIndoor() {}
    
    @FXML
    private void loadTestData() {
    ObservableList<Product> testProducts = FXCollections.observableArrayList(
 new Product(
        1,                  // productId
        "Indoor Plant",     // name
        120.50,             // price
        "Indoor",           // category
        15,                 // stockQuantity
        "Available",        // status
        "images/plant1.png" // imagePath
));

    IndoorTable.setItems(testProducts);
}
    @FXML
    private void BuyOutdoor() {}

    @FXML
    private void Search() {
    }
    
    
    


private void setupActionsColumn() {
    ActionsColumn.setCellFactory(column -> new TableCell<Product, Void>() {

        private final Button plusBtn = new Button("+");
        private final Button minusBtn = new Button("-");
        private final Label qtyLabel = new Label("0");
        private final HBox box = new HBox(5, minusBtn, qtyLabel, plusBtn);

        {
            plusBtn.setOnAction(event -> {
                Product product = getTableView().getItems().get(getIndex());
                int qty = product.getSelectedQty();
                product.setSelectedQty(qty + 1);
                qtyLabel.setText(String.valueOf(product.getSelectedQty()));
            });

            minusBtn.setOnAction(event -> {
                Product product = getTableView().getItems().get(getIndex());
                int qty = product.getSelectedQty();
                if (qty > 0) {
                    product.setSelectedQty(qty - 1);
                }
                qtyLabel.setText(String.valueOf(product.getSelectedQty()));
            });
        }

        @Override
        protected void updateItem(Void item, boolean empty) {
            super.updateItem(item, empty);

            if (empty) {
                setGraphic(null);
            } else {
                Product p = getTableView().getItems().get(getIndex());
                qtyLabel.setText(String.valueOf(p.getSelectedQty()));
                setGraphic(box);
            }
        }
    });
}



    @FXML
    private void ShowIndoor() {
        try {
            VBox userManagement = FXMLLoader.load(getClass().getResource("Indoor.fxml"));
            contentPane.getChildren().setAll(userManagement);
//            loadUsersData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void ShowOutdoor() {
        try {
            VBox reports = FXMLLoader.load(getClass().getResource("Outdoor.fxml"));
            contentPane.getChildren().setAll(reports);
//            loadCompanyData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void logout() {
            try {
                Node source = (Node) contentPane;
                Stage currentStage = (Stage) source.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginScreen.fxml"));
                Parent root = loader.load();
                Scene loginScene = new Scene(root);
                currentStage.setScene(loginScene);
                currentStage.setTitle("Login");
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    @FXML
    private void handleClose() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit Confirmation");
        alert.setHeaderText("Do you really want to close the application?");
        alert.setContentText("Choose your option.");
        ButtonType yesButton = new ButtonType("Yes", ButtonBar.ButtonData.YES);
        ButtonType noButton = new ButtonType("No", ButtonBar.ButtonData.NO);
        alert.getButtonTypes().setAll(yesButton, noButton);
        alert.showAndWait().ifPresent(type -> {
            if (type == yesButton) {
                Node source = (Node) contentPane;
                Stage stage = (Stage) source.getScene().getWindow();
                stage.close();
            }
        });
    }

    private void showAlert(Alert.AlertType type, String title, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
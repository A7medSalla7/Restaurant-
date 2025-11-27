
package javafxapplication23;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Product {
    private int productId;
    private String name;
    private double price;
    private String category;
    private int stockQuantity;
    private String status;
    private String imagePath;
    private IntegerProperty selectedQty = new SimpleIntegerProperty(0);

    public Product(int productId, String name, double price, String Category,
                   int stockQuantity, String status, String imagePath) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.category = category;
        this.stockQuantity = stockQuantity;
        this.status = status;
        this.imagePath = imagePath;
    }

    public int getId() { return productId; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getCategory() { return category; }
    public int getStockQuantity() { return stockQuantity; }
    public String getStatus() { return status; }
    public String getImagePath() { return imagePath; }
    
    public int getSelectedQty() {
        return selectedQty.get();
    }

    public void setSelectedQty(int qty) {
        selectedQty.set(qty);
    }

    public IntegerProperty selectedQtyProperty() {
        return selectedQty;
    }
}


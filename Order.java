/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxapplication23;

import java.time.LocalDateTime;

public class Order {
    private int orderId;
    private String date;
    private String orderType;
    private double subTotal;
    private double tax;
    private double discount;
    private double totalAmount;
    private String paymentMethod;
    private String status;
    private int userId;

    public Order(int orderId, String date, String orderType, double subTotal,
                 double tax, double discount, double totalAmount, 
                 String paymentMethod, String status, int userId) {
        
        this.orderId = orderId;
        this.date = date;
        this.orderType = orderType;
        this.subTotal = subTotal;
        this.tax = tax;
        this.discount = discount;
        this.totalAmount = totalAmount;
        this.paymentMethod = paymentMethod;
        this.status = status;
        this.userId = userId;
    }

    public int getOrderId() { return orderId; }
    public String getDate() { return date; }
    public String getOrderType() { return orderType; }
    public double getSubTotal() { return subTotal; }
    public double getTax() { return tax; }
    public double getDiscount() { return discount; }
    public double getTotalAmount() { return totalAmount; }
    public String getPaymentMethod() { return paymentMethod; }
    public String getStatus() { return status; }
    public int getUserId() { return userId; }
}


package com.shopingmanagement.model;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class Order {
    private static long nextId = 100;
    private String orderId;
    private Date orderDate;
    private Map<String, LineItem> lineItemLMap;

    public Order(Date orderDate,  Map<String, LineItem> lineItemList) {
        this.orderId = "OID" + ++nextId;
        this.orderDate = orderDate;
        this.lineItemLMap = lineItemList;
    }

    public String getOrderId() {
        return orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public  Map<String, LineItem> getLineItemList() {
        return lineItemLMap;
    }

    public void setLineItemList( Map<String, LineItem> lineItemList) {
        this.lineItemLMap = lineItemList;
    }

    public double calculateOrderPrice(){
        double price = 0;
        for(LineItem lineItem : lineItemLMap.values()){
            price += lineItem.calculateLineItemTotal();
        }

        return price;
    }
}

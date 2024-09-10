package com.infnet.tp3.event;

public class PurchaseOrderCreatedEvent extends BaseEvent<String> {

    public final String product;
    public final double price;
    public final int quantity;

    public PurchaseOrderCreatedEvent(String id, String product, double price, int quantity) {
        super(id);
        this.product = product;
        this.price = price;
        this.quantity = quantity;
    }
}

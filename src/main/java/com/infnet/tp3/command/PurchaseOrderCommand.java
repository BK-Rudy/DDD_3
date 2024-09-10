package com.infnet.tp3.command;

public class PurchaseOrderCommand extends BaseCommand<String> {

    public final String product;
    public final double value;
    public final int quantity;

    public PurchaseOrderCommand(String id, String product, double value, int quantity){
        super(id);
        this.product = product;
        this.value = value;
        this.quantity = quantity;
    }
}

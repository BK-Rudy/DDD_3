package com.infnet.tp3.domain;

import com.infnet.tp3.command.PurchaseOrderCommand;
import com.infnet.tp3.event.PurchaseOrderCreatedEvent;
import com.infnet.tp3.event.PurchaseOrderStatusEvent;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
@Entity
public class PurchaseOrder {

    @AggregateIdentifier
    @Id
    private String id;
    private String product;
    private double price;
    private int quantity;
    private String status;

    public PurchaseOrder(){}

    @CommandHandler
    public PurchaseOrder(PurchaseOrderCommand purchaseOrderCommand){
        AggregateLifecycle.apply(new PurchaseOrderCreatedEvent(
                purchaseOrderCommand.id,
                purchaseOrderCommand.product,
                purchaseOrderCommand.value,
                purchaseOrderCommand.quantity)
        );
    }

    @EventSourcingHandler
    protected void on(PurchaseOrderCreatedEvent purchaseOrderCreatedEvent) {
        this.id = purchaseOrderCreatedEvent.id;
        this.product = purchaseOrderCreatedEvent.product;
        this.price = purchaseOrderCreatedEvent.price;
        this.quantity = purchaseOrderCreatedEvent.quantity;
        this.status = String.valueOf(Status.CREATED);

        AggregateLifecycle.apply(new PurchaseOrderStatusEvent(this.id, Status.AWAITING));
    }

    @EventSourcingHandler
    protected void on(PurchaseOrderStatusEvent purchaseOrderStatusEvent) {
        this.status = String.valueOf(purchaseOrderStatusEvent.status);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

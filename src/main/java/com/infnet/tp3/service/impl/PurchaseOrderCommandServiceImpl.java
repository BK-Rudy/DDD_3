package com.infnet.tp3.service.impl;

import com.infnet.tp3.command.PurchaseOrderCommand;
import com.infnet.tp3.domain.PurchaseOrder;
import com.infnet.tp3.service.PurchaseOrderCommandService;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class PurchaseOrderCommandServiceImpl implements PurchaseOrderCommandService {

    @Autowired
    private final CommandGateway commandGateway;

    public PurchaseOrderCommandServiceImpl(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @Override
    public CompletableFuture<String> createPurchaseOrder (PurchaseOrder purchaseOrder){
        return commandGateway.send(new PurchaseOrderCommand(
                UUID.randomUUID().toString(),
                purchaseOrder.getProduct(),
                purchaseOrder.getPrice(),
                purchaseOrder.getQuantity()));
    }
}

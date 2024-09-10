package com.infnet.tp3.service;

import com.infnet.tp3.domain.PurchaseOrder;

import java.util.concurrent.CompletableFuture;

public interface PurchaseOrderCommandService {

    public CompletableFuture<String> createPurchaseOrder (PurchaseOrder purchaseOrder);
}

package com.infnet.tp3.controller;

import com.infnet.tp3.domain.PurchaseOrder;
import com.infnet.tp3.service.PurchaseOrderCommandService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(value= "/pedido_de_compra")
public class PurchaseOrderCommandController {

    private final PurchaseOrderCommandService purchaseOrderCommandService;

    public PurchaseOrderCommandController(PurchaseOrderCommandService purchaseOrderCommandService) {
        this.purchaseOrderCommandService = purchaseOrderCommandService;
    }

    @PostMapping
    public CompletableFuture<String> createPurchaseOrder (@RequestBody PurchaseOrder purchaseOrder) {
        return purchaseOrderCommandService.createPurchaseOrder(purchaseOrder);
    }
}

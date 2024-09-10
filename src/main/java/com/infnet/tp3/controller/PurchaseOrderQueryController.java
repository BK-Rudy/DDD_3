package com.infnet.tp3.controller;

import com.infnet.tp3.domain.PurchaseOrder;
import com.infnet.tp3.service.PurchaseOrderQueryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/pedido_de_compra")
public class PurchaseOrderQueryController {

    private final PurchaseOrderQueryService purchaseOrderQueryService;

    public PurchaseOrderQueryController(PurchaseOrderQueryService purchaseOrderQueryService){
        this.purchaseOrderQueryService = purchaseOrderQueryService;
    }

    @GetMapping("/{id}/evento")
    public List<Object> getEvents (@PathVariable(value="id") String id) {
        return purchaseOrderQueryService.getEvents(id);
    }

    @GetMapping("/{id}")
    public PurchaseOrder findById (@PathVariable(value="id") String id) {
        return purchaseOrderQueryService.findById(id).get();
    }
}

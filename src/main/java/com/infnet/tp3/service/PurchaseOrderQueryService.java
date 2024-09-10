package com.infnet.tp3.service;

import com.infnet.tp3.domain.PurchaseOrder;

import java.util.List;
import java.util.Optional;

public interface PurchaseOrderQueryService {

    List<Object> getEvents(String id);

    Optional<PurchaseOrder> findById(String id);
}

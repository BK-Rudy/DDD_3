package com.infnet.tp3.service.impl;

import com.infnet.tp3.domain.PurchaseOrder;
import com.infnet.tp3.repository.PurchaseOrderRepository;
import com.infnet.tp3.service.PurchaseOrderQueryService;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PurchaseOrderQueryServiceImpl implements PurchaseOrderQueryService {

    private final EventStore eventStore;
    private final PurchaseOrderRepository purchaseOrderRepository;

    public PurchaseOrderQueryServiceImpl (EventStore eventStore, PurchaseOrderRepository purchaseOrderRepository) {
        this.eventStore = eventStore;
        this.purchaseOrderRepository = purchaseOrderRepository;
    }

    @Override
    public List<Object> getEvents(String id) {
        return eventStore.readEvents(id, 0)
                .asStream()
                .map(record -> record.getPayload()).collect(Collectors.toList());
    }

    @Override
    public Optional<PurchaseOrder> findById(String id) {
        return purchaseOrderRepository.findById(id);
    }
}

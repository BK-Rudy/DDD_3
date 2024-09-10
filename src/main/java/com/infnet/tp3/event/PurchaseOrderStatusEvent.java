package com.infnet.tp3.event;

import com.infnet.tp3.domain.Status;

public class PurchaseOrderStatusEvent extends BaseEvent<String> {

    public final Status status;

    public PurchaseOrderStatusEvent(String id, Status status) {
        super(id);
        this.status = status;
    }
}

package com.infnet.tp3.repository;

import com.infnet.tp3.domain.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, String > {
}

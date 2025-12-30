package com.product.renting.order.entity;

import com.product.renting.common.constant.DbConstants;
import com.product.renting.common.entity.Auditable;
import com.product.renting.order.enumeration.InventoryItemStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = DbConstants.INVENTORY_ITEM)
public class InventoryItem extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = DbConstants.INVENTORY_ITEM_ID)
    private UUID inventoryItemId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = DbConstants.PRODUCT_ID)
    private Product product;

    @Column(name = DbConstants.INVENTORY_ITEM_SERIAL_NUMBER)
    private String serialNumber;

    @Column(name = DbConstants.INVENTORY_ITEM_STATUS)
    private InventoryItemStatus inventoryItemStatus;
}

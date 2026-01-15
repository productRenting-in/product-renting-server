package com.product.renting.order.entity;

import com.product.renting.common.constant.DbConstants;
import com.product.renting.common.entity.Auditable;
import com.product.renting.order.enumeration.InventoryReservationStatus;
import com.product.renting.order.enumeration.InventoryReservationType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;
import java.time.Instant;
import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = DbConstants.INVENTORY_RESERVATION)
public class InventoryReservation extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = DbConstants.INVENTORY_RESERVATION_ID)
    private UUID inventoryReservationId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = DbConstants.INVENTORY_ITEM_ID)
    private InventoryItem inventoryItem;

    @Column(name = DbConstants.INVENTORY_RESERVATION_FROM_DATE)
    private Instant fromDate;

    @Column(name = DbConstants.INVENTORY_RESERVATION_TO_DATE)
    private Instant toDate;

    @Column(name = DbConstants.RESERVED_QUANTITY)
    private BigInteger reservedQuantity;

    @Enumerated(EnumType.STRING)
    @Column(name = DbConstants.INVENTORY_RESERVATION_TYPE)
    private InventoryReservationType reservationType;

    @Enumerated(EnumType.STRING)
    @Column(name = DbConstants.INVENTORY_RESERVATION_STATUS)
    private InventoryReservationStatus reservationStatus;
}

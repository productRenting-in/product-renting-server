package com.product.renting.order.entity;

import com.product.renting.common.constant.DbConstants;
import com.product.renting.common.entity.Auditable;
import com.product.renting.order.enumeration.InventoryReservationStatus;
import com.product.renting.order.enumeration.InventoryReservationType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
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
    private LocalDateTime fromDate;

    @Column(name = DbConstants.INVENTORY_RESERVATION_TO_DATE)
    private LocalDateTime toDate;

    @Column(name = DbConstants.INVENTORY_RESERVATION_TYPE)
    private InventoryReservationType reservationType;

    @Column(name = DbConstants.INVENTORY_RESERVATION_STATUS)
    private InventoryReservationStatus reservationStatus;
}

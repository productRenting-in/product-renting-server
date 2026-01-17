package com.product.renting.order.entity;

import com.product.renting.common.constant.DbConstants;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = DbConstants.PRODUCT_SERIAL_COUNTER)
public class ProductSerialCounter {

    @Id
    @Column(name = DbConstants.PRODUCT_ID)
    private UUID productId;

    @Column(name = DbConstants.LAST_SERIAL)
    private Long lastSerial;
}

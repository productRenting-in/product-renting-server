package com.product.renting.order.service;

import com.product.renting.order.entity.Product;
import com.product.renting.order.entity.ProductSerialCounter;
import com.product.renting.order.repository.ProductSerialCounterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SerialNumberGeneratorService {

    private final ProductSerialCounterRepository counterRepository;

    /**
     * Generates serial number like: 2601-CHAIR-0001
     */
    @Transactional
    public String generateSerialNumber(Product product) {
        UUID productId = product.getProductId();
        String productCode = product.getProductName().toUpperCase().replaceAll("\\s+", "-"); // e.g., "CHAIR"

        // Fetch counter with DB lock
        ProductSerialCounter counter = counterRepository.findByProductIdForUpdate(productId)
                .orElseGet(() -> ProductSerialCounter.builder()
                        .productId(productId)
                        .lastSerial(0L)
                        .build());

        // Increment
        long nextSerial = counter.getLastSerial() + 1;
        counter.setLastSerial(nextSerial);

        // Save/update counter
        counterRepository.save(counter);

        // Format: PRODUCTCODE-0001
        return String.format("%s-%04d", productCode, nextSerial);
    }
}


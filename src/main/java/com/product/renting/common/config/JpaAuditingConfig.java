package com.product.renting.common.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.Instant;
import java.time.ZoneId;
import java.util.Optional;

@Slf4j
@Configuration
@EnableJpaAuditing(dateTimeProviderRef = "dateTimeProvider")
public class JpaAuditingConfig {

    private static final ZoneId IST_ZONE = ZoneId.of("Asia/Kolkata");

    @Bean
    public DateTimeProvider dateTimeProvider() {
        return () -> Optional.of(Instant.now());
    }
}

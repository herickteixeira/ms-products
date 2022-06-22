package com.products.core.shared;

import java.time.LocalDateTime;
import java.util.UUID;

public abstract class BaseDomainEvent {
    protected final UUID id = UUID.randomUUID();
    protected final LocalDateTime createdAt = LocalDateTime.now();

    public BaseDomainEvent() {
    }

    public UUID getId() {
        return this.id;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }
}

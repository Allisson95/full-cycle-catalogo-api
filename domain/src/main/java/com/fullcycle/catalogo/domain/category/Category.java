package com.fullcycle.catalogo.domain.category;

import java.time.Instant;

import com.fullcycle.catalogo.domain.validation.Error;
import com.fullcycle.catalogo.domain.validation.ValidationHandler;

public record Category(
        String id,
        String name,
        String description,
        boolean active,
        Instant createdAt,
        Instant updatedAt,
        Instant deletedAt) {

    public static Category with(
            final String anId,
            final String name,
            final String description,
            final boolean active,
            final Instant createdAt,
            final Instant updatedAt,
            final Instant deletedAt) {
        return new Category(
                anId,
                name,
                description,
                active,
                createdAt,
                updatedAt,
                deletedAt);
    }

    public static Category with(final Category aCategory) {
        return with(
                aCategory.id(),
                aCategory.name(),
                aCategory.description(),
                aCategory.active(),
                aCategory.createdAt(),
                aCategory.updatedAt(),
                aCategory.deletedAt());
    }

    public Category validate(final ValidationHandler aHandler) {
        if (this.id == null || this.id.isBlank()) {
            aHandler.append(new Error("'id' should not be empty"));
        }

        if (this.name == null || this.name.isBlank()) {
            aHandler.append(new Error("'name' should not be empty"));
        }

        return this;
    }

}

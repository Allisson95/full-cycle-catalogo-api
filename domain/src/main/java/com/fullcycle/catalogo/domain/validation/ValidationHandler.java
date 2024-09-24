package com.fullcycle.catalogo.domain.validation;

import java.util.List;

public interface ValidationHandler {

    ValidationHandler append(Error anError);

    ValidationHandler append(ValidationHandler anHandler);

    <T> T validate(Validation<T> aValidation);

    List<Error> getErrors();

    default boolean hasError() {
        return this.getErrors() != null && !this.getErrors().isEmpty();
    }

    default Error firstError() {
        if (this.getErrors() != null && !this.getErrors().isEmpty()) {
            return this.getErrors().get(0);
        } else {
            return null;
        }
    }

    interface Validation<T> {
        T validate();
    }
}

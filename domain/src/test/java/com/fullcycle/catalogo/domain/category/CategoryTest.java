package com.fullcycle.catalogo.domain.category;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fullcycle.catalogo.domain.UnitTest;
import com.fullcycle.catalogo.domain.exceptions.DomainException;
import com.fullcycle.catalogo.domain.utils.IdUtils;
import com.fullcycle.catalogo.domain.utils.InstantUtils;
import com.fullcycle.catalogo.domain.validation.handler.ThrowsValidationHandler;

class CategoryTest extends UnitTest {

    @Test
    void givenAValidParams_whenCallWith_thenInstantiateACategory() {
        final var expectedId = IdUtils.uuid();
        final var expectedName = "Filmes";
        final var expectedDescription = "A categoria mais assistida";
        final var expectedIsActive = true;
        final var expectedCreatedAt = InstantUtils.now();
        final var expectedUpdatedAt = InstantUtils.now();
        final var expectedDeletedAt = InstantUtils.now();

        final var actualCategory = Category.with(expectedId, expectedName, expectedDescription, expectedIsActive,
                expectedCreatedAt, expectedUpdatedAt, expectedDeletedAt);

        Assertions.assertNotNull(actualCategory);
        Assertions.assertEquals(expectedId, actualCategory.id());
        Assertions.assertEquals(expectedName, actualCategory.name());
        Assertions.assertEquals(expectedDescription, actualCategory.description());
        Assertions.assertEquals(expectedIsActive, actualCategory.active());
        Assertions.assertEquals(expectedCreatedAt, actualCategory.createdAt());
        Assertions.assertEquals(expectedUpdatedAt, actualCategory.updatedAt());
        Assertions.assertEquals(expectedDeletedAt, actualCategory.deletedAt());
    }

    @Test
    void givenAValidParams_whenCallWithCategory_thenInstantiateACategory() {
        final var aCategory = Category.with(IdUtils.uuid(), "Filmes", "A categoria mais assistida", true,
                InstantUtils.now(), InstantUtils.now(), InstantUtils.now());

        final var actualCategory = Category.with(aCategory);

        Assertions.assertNotNull(actualCategory);
        Assertions.assertEquals(aCategory.id(), actualCategory.id());
        Assertions.assertEquals(aCategory.name(), actualCategory.name());
        Assertions.assertEquals(aCategory.description(), actualCategory.description());
        Assertions.assertEquals(aCategory.active(), actualCategory.active());
        Assertions.assertEquals(aCategory.createdAt(), actualCategory.createdAt());
        Assertions.assertEquals(aCategory.updatedAt(), actualCategory.updatedAt());
        Assertions.assertEquals(aCategory.deletedAt(), actualCategory.deletedAt());
    }

    @Test
    void givenAnInvalidNullId_whenCallNewCategoryAndValidate_thenShouldReceiveError() {
        final String expectedId = null;
        final var expectedName = "Aulas";
        final var expectedDescription = "A categoria mais assistida";
        final var expectedIsActive = true;
        final var expectedCreatedAt = InstantUtils.now();
        final var expectedUpdatedAt = InstantUtils.now();
        final var expectedDeletedAt = InstantUtils.now();

        final var expectedErrorCount = 1;
        final var expectedErrorMessage = "'id' should not be empty";

        final var actualCategory = Category.with(expectedId, expectedName, expectedDescription, expectedIsActive,
                expectedCreatedAt, expectedUpdatedAt, expectedDeletedAt);

        final var actualException = Assertions.assertThrows(DomainException.class,
                () -> actualCategory.validate(new ThrowsValidationHandler()));

        Assertions.assertEquals(expectedErrorCount, actualException.getErrors().size());
        Assertions.assertEquals(expectedErrorMessage, actualException.getErrors().get(0).message());
    }

    @Test
    void givenAnInvalidEmptyId_whenCallNewCategoryAndValidate_thenShouldReceiveError() {
        final var expectedId = " ";
        final var expectedName = "Aulas";
        final var expectedDescription = "A categoria mais assistida";
        final var expectedIsActive = true;
        final var expectedCreatedAt = InstantUtils.now();
        final var expectedUpdatedAt = InstantUtils.now();
        final var expectedDeletedAt = InstantUtils.now();

        final var expectedErrorCount = 1;
        final var expectedErrorMessage = "'id' should not be empty";

        final var actualCategory = Category.with(expectedId, expectedName, expectedDescription, expectedIsActive,
                expectedCreatedAt, expectedUpdatedAt, expectedDeletedAt);

        final var actualException = Assertions.assertThrows(DomainException.class,
                () -> actualCategory.validate(new ThrowsValidationHandler()));

        Assertions.assertEquals(expectedErrorCount, actualException.getErrors().size());
        Assertions.assertEquals(expectedErrorMessage, actualException.getErrors().get(0).message());
    }

    @Test
    void givenAnInvalidNullName_whenCallNewCategoryAndValidate_thenShouldReceiveError() {
        final var expectedId = IdUtils.uuid();
        final String expectedName = null;
        final var expectedDescription = "A categoria mais assistida";
        final var expectedIsActive = true;
        final var expectedCreatedAt = InstantUtils.now();
        final var expectedUpdatedAt = InstantUtils.now();
        final var expectedDeletedAt = InstantUtils.now();

        final var expectedErrorCount = 1;
        final var expectedErrorMessage = "'name' should not be empty";

        final var actualCategory = Category.with(expectedId, expectedName, expectedDescription, expectedIsActive,
                expectedCreatedAt, expectedUpdatedAt, expectedDeletedAt);

        final var actualException = Assertions.assertThrows(DomainException.class,
                () -> actualCategory.validate(new ThrowsValidationHandler()));

        Assertions.assertEquals(expectedErrorCount, actualException.getErrors().size());
        Assertions.assertEquals(expectedErrorMessage, actualException.getErrors().get(0).message());
    }

    @Test
    void givenAnInvalidEmptyName_whenCallNewCategoryAndValidate_thenShouldReceiveError() {
        final var expectedId = IdUtils.uuid();
        final var expectedName = " ";
        final var expectedDescription = "A categoria mais assistida";
        final var expectedIsActive = true;
        final var expectedCreatedAt = InstantUtils.now();
        final var expectedUpdatedAt = InstantUtils.now();
        final var expectedDeletedAt = InstantUtils.now();

        final var expectedErrorCount = 1;
        final var expectedErrorMessage = "'name' should not be empty";

        final var actualCategory = Category.with(expectedId, expectedName, expectedDescription, expectedIsActive,
                expectedCreatedAt, expectedUpdatedAt, expectedDeletedAt);

        final var actualException = Assertions.assertThrows(DomainException.class,
                () -> actualCategory.validate(new ThrowsValidationHandler()));

        Assertions.assertEquals(expectedErrorCount, actualException.getErrors().size());
        Assertions.assertEquals(expectedErrorMessage, actualException.getErrors().get(0).message());
    }

}

package com.powerup.java.immutable.model.builder.validator;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("SameReturnValue")
class ByteGreaterThanEqualToBuilderValidatorTest {
    public static final String PARAMETER_NAME = "test";
    public static final String SHOULD_BE_EMPTY_ERROR_MESSAGE = "Error message should be empty";

    @Test
    public void testConstructor_NominalCase() {
        assertDoesNotThrow(() -> new ByteGreaterThanEqualToBuilderValidator(PARAMETER_NAME,
                ByteGreaterThanEqualToBuilderValidatorTest::getValidValue, (byte) 1));
    }

    @Test
    public void testConstructor_NullSupplier() {
        assertThrows(IllegalArgumentException.class, () -> new ByteGreaterThanEqualToBuilderValidator(PARAMETER_NAME, null, (byte) 1));
    }

    @Test
    public void testValidate_GreaterThan() {
        ByteGreaterThanEqualToBuilderValidator instance = new ByteGreaterThanEqualToBuilderValidator(PARAMETER_NAME,
                ByteGreaterThanEqualToBuilderValidatorTest::getValidValue, (byte) 0);
        String result = instance.validate();
        assertTrue(StringUtils.isEmpty(result), SHOULD_BE_EMPTY_ERROR_MESSAGE);
    }

    @Test
    public void testValidate_Equal() {
        ByteGreaterThanEqualToBuilderValidator instance = new ByteGreaterThanEqualToBuilderValidator(PARAMETER_NAME,
                ByteGreaterThanEqualToBuilderValidatorTest::getValidValue, (byte) 1);
        String result = instance.validate();
        assertTrue(StringUtils.isEmpty(result), SHOULD_BE_EMPTY_ERROR_MESSAGE);
    }

    @Test
    public void testValidate_LessThan() {
        ByteGreaterThanEqualToBuilderValidator instance = new ByteGreaterThanEqualToBuilderValidator(PARAMETER_NAME,
                ByteGreaterThanEqualToBuilderValidatorTest::getValidValue, (byte) 2);
        String result = instance.validate();
        assertEquals(String.format(BuilderValidator.GREATER_THAN_EQUAL_TO_ERROR_MESSAGE_FORMAT, PARAMETER_NAME, 2), result);
    }

    @Test
    public void testValidate_Null() {
        ByteGreaterThanEqualToBuilderValidator instance = new ByteGreaterThanEqualToBuilderValidator(PARAMETER_NAME,
                ByteGreaterThanEqualToBuilderValidatorTest::getNullValue, (byte) 2);
        String result = instance.validate();
        assertTrue(StringUtils.isEmpty(result), SHOULD_BE_EMPTY_ERROR_MESSAGE);
    }

    private static Byte getValidValue() {
        return 1;
    }

    private static Byte getNullValue() {
        return null;
    }
}
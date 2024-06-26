package com.powerup.java.immutable.model.builder.validator;

import java.util.function.Supplier;

/**
 * A <code>DoubleGreaterThanEqualToValidator</code> is a validator that validates if a parameter is greater than or equal to the provided value.
 *
 * @author Chris Picard
 */
@SuppressWarnings("JavadocReference")
public final class DoubleGreaterThanEqualToBuilderValidator extends BuilderValidatorAbs {
    /**
     * The supplier of the double parameter to validate that it is greater than or equal to the min value.
     */
    private final Supplier<Double> valueSupplier;
    /**
     * The min value to validate if the parameter is greater than or equal to.
     */
    private final double minValue;

    /**
     * Base constructor.
     *
     * @param name Value of {@link BuilderValidatorAbs#name}.
     * @param valueSupplier Value of {@link #valueSupplier}.
     * @param minValue Value of {@link #minValue}.
     */
    public DoubleGreaterThanEqualToBuilderValidator(final String name, final Supplier<Double> valueSupplier, final double minValue) {
        super(name);
        validateBuilder();
        if (valueSupplier == null) {
            throw new IllegalArgumentException("Value supplier can not be null");
        }
        this.valueSupplier = valueSupplier;
        this.minValue = minValue;
    }

    @Override
    public String validate() {
        String result = "";
        Double value = valueSupplier.get();
        if (value != null && value < minValue) {
            result = String.format(GREATER_THAN_EQUAL_TO_ERROR_MESSAGE_FORMAT, getName(), minValue);
        }
        return result;
    }
}

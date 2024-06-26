package com.powerup.java.immutable.model.builder.validator;

import java.util.function.Supplier;

/**
 * A <code>MandatoryFloatValidator</code> is a validator that validates if a mandatory float is set. In this context set mean not null and not
 * equal to 0.0.
 *
 * @author Chris Picard
 */
@SuppressWarnings("JavadocReference")
public final class MandatoryFloatBuilderValidator extends BuilderValidatorAbs {
    /**
     * The supplier of the float parameter to validate that it is set.
     */
    private final Supplier<Float> valueSupplier;

    /**
     * Base constructor.
     *
     * @param name Value of {@link BuilderValidatorAbs#name}.
     * @param valueSupplier Value of {@link #valueSupplier}.
     */
    public MandatoryFloatBuilderValidator(final String name, final Supplier<Float> valueSupplier) {
        super(name);
        validateBuilder();
        if (valueSupplier == null) {
            throw new IllegalArgumentException("Value supplier can not be null");
        }
        this.valueSupplier = valueSupplier;
    }

    @Override
    public String validate() {
        String result = "";
        Float value = valueSupplier.get();
        if (value == null || value == 0.0) {
            result = String.format(MandatoryObjectBuilderValidator.UNSET_ERROR_MESSAGE_FORMAT, getName());
        }
        return result;
    }
}

package com.powerup.java.immutable.model.builder.validator;

import java.util.function.Supplier;

/**
 * A <code>MandatoryByteValidator</code> is a validator that validates if a mandatory byte is set. In this context set mean not null and not equal to
 * 0.
 *
 * @author Chris Picard
 */
@SuppressWarnings("JavadocReference")
public final class MandatoryByteBuilderValidator extends BuilderValidatorAbs {
    /**
     * The supplier of the byte parameter to validate that it is set.
     */
    private final Supplier<Byte> valueSupplier;

    /**
     * Base constructor.
     *
     * @param name Value of {@link BuilderValidatorAbs#name}.
     * @param valueSupplier Value of {@link #valueSupplier}.
     */
    public MandatoryByteBuilderValidator(final String name, final Supplier<Byte> valueSupplier) {
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
        Byte value = valueSupplier.get();
        if (value == null || value == 0) {
            result = String.format(MandatoryObjectBuilderValidator.UNSET_ERROR_MESSAGE_FORMAT, getName());
        }
        return result;
    }
}

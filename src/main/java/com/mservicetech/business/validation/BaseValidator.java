package com.mservicetech.business.validation;

import java.util.stream.Stream;

/**
 * Define business validation interface method. .
 * <p>
 * Supports validation passing payload, and the context value for supporting business rule validation.
 *
 * @author Gavin Chen
 */
public interface BaseValidator <T, PayloadType> {

    /**
     * support method use to indicate which validator is suppose to run for validation.
     * it works as a filter for validator chain. In certain case, only support validators will be triggered
     *
     * @param filter The filter condition.
     */
    boolean support (T filter);

    /**
     * Validate method to implement the detail business validation rules
     *
     * @param context The context value support the business validation. for example request context, rule context..
     * @param payload The object model use for business validation
     *
     * @return Steam of the ValidationResult
     */
    Stream<ValidationResult> validate(Object context, PayloadType payload);
}

package com.example.booking_backend.utils.annotation;

import com.example.booking_backend.utils.handler.NonExistHandler;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NonExistHandler.class)
public @interface NonExists {

    String message() default  "";
    String field() default "";

    String table() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
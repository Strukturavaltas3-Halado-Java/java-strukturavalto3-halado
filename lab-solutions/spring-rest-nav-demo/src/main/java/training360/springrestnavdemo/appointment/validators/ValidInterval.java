package training360.springrestnavdemo.appointment.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = IntervalValidator.class)
public @interface ValidInterval {

    String message() default "invalid interval!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

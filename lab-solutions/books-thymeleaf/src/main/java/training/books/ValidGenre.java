package training.books;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = GenreValidator.class)
public @interface ValidGenre {

    String message() default "Book genre not OK";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

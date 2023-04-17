package training.books;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class GenreValidator implements ConstraintValidator<ValidGenre, String> {

    @Override
    public boolean isValid(String genre, ConstraintValidatorContext constraintValidatorContext) {
        return Genre.isValidGenre(genre);
    }
}

package training360.springrestnavdemo.appointment.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import training360.springrestnavdemo.appointment.dtos.Interval;

public class IntervalValidator implements ConstraintValidator<ValidInterval, Interval> {

    @Override
    public boolean isValid(Interval interval, ConstraintValidatorContext constraintValidatorContext) {
        return interval.getStartDate().isBefore(interval.getEndDate());
    }

}

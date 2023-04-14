package training360.springrestnavdemo.appointment.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import training360.springrestnavdemo.appointment.model.Appointment;
import training360.springrestnavdemo.service.AppointmentService;

public class CdvValidator implements ConstraintValidator<ValidCdv, String> {



    @Override
    public boolean isValid(String code, ConstraintValidatorContext constraintValidatorContext) {
        return containsDigits(code) && containsTenDigit(code) && validCdv(code);
    }

    private boolean containsDigits(String code){
        for(char c:code.toCharArray()){
            if(!Character.isDigit(c)){
                return false;
            }
        }
        return true;
    }

    private boolean containsTenDigit(String code){
        return code.length()==10;
    }

    private boolean validCdv(String code){
        int sum = 0;
        for(int i=0;i<9;i++){
            int actNum = Integer.parseInt(code.substring(i,i+1));
            actNum*=i;
            sum+=actNum;
        }

        int last = sum%11;
        return last == Integer.parseInt(code.substring(9));
    }


}

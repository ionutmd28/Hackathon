package org.example;


import javax.validation.*;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Max;
import java.util.Set;

public class BeanValidation {
    @AssertTrue
    boolean check = true;

    @Max(value = 35, message = "The size must be less than 35.")
    int sum = 0;

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public static void main(String[] args) {

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        BeanValidation beanValidation = new BeanValidation();

        for(int i = 0; i < 20; i++) {

            Set<ConstraintViolation<BeanValidation>> violations = validator.validate(beanValidation);

            beanValidation.setSum(beanValidation.getSum() + i);
            if(beanValidation.getSum() > 35) {
                beanValidation.setCheck(false);
            }

            for (ConstraintViolation<BeanValidation> violation : violations) {
                System.out.println("Errors: " + violation.getMessage());
            }

            System.out.println("Suma curenta: " + beanValidation.getSum());
            System.out.println("Valuarea validarii sum < 35: " + beanValidation.isCheck());

        }
    }
}

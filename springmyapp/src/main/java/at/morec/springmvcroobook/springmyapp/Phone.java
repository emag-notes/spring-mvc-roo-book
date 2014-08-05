package at.morec.springmvcroobook.springmyapp;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author tanabe
 */
@Documented
@Constraint(validatedBy = PhoneValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Phone {
  String message() default "please input a phone number.";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

  boolean onlyNumber() default false;
}

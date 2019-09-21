package bookstore.bookstore.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AuthorValidationIml implements ConstraintValidator<AuthorValidation, String> {


    @Override
    public boolean isValid(String author, ConstraintValidatorContext constraintValidatorContext) {
        return author.toUpperCase().startsWith("A");
    }
}

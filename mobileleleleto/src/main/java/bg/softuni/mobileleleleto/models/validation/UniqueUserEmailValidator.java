package bg.softuni.mobileleleleto.models.validation;

import bg.softuni.mobileleleleto.repository.UserRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueUserEmailValidator implements ConstraintValidator<UniqueUserEmail, String> {



    private final UserRepository userRepository;

    public UniqueUserEmailValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return this.userRepository.findByEmail(value).isEmpty();
    }
}

package com.finalproject.util;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * Created by mehdi on 4/24/17.
 */
public class ValidatorUtil<T> {

    private Class<T> modelClass;

    public ValidatorUtil(Class<T> modelClass){
        this.modelClass = modelClass;
    }

    public Set<ConstraintViolation<T>> checkValidation(T modelObject){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<T>> violations = validator.validate(modelObject);
        return violations;
    }
}

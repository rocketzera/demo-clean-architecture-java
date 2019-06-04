package io.github.rocketzera.cleanarchitecture.usecase.validator;

import org.springframework.stereotype.Component;

import io.github.rocketzera.cleanarchitecture.domain.model.Car;
import io.github.rocketzera.cleanarchitecture.usecase.exception.ApplicationException;

@Component
public class CarValidator {

    public void emptyResult(Car item) {
        if(item == null) {
            throw new ApplicationException();
        }
    }

}

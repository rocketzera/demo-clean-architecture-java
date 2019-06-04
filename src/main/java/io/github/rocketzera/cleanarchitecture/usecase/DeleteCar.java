package io.github.rocketzera.cleanarchitecture.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.github.rocketzera.cleanarchitecture.domain.model.Car;
import io.github.rocketzera.cleanarchitecture.usecase.port.CarRepositoryPort;
import io.github.rocketzera.cleanarchitecture.usecase.validator.CarValidator;

@Component
public class DeleteCar {

    @Autowired
    private CarRepositoryPort repositoryPort;
    
    @Autowired
    private FindCar findCar;
    
    @Autowired
    private CarValidator validator;

    public void delete(Long id) {
        Car carFound = findCar.findById(id);
        validator.emptyResult(carFound);
        repositoryPort.delete(id);
    }

}

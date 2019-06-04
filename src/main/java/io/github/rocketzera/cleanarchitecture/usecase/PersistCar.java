package io.github.rocketzera.cleanarchitecture.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.github.rocketzera.cleanarchitecture.domain.model.Car;
import io.github.rocketzera.cleanarchitecture.usecase.port.CarRepositoryPort;
import io.github.rocketzera.cleanarchitecture.usecase.validator.CarValidator;

@Component
public class PersistCar {

    @Autowired
    private CarRepositoryPort repositoryPort;
    
    @Autowired
    private FindCar findCar;
    
    @Autowired
    private CarValidator validator;

    public Car create(Car dto) {
        return repositoryPort.create(dto);
    }

    public Car update(Long id, Car dto) {
        Car carFound = findCar.findById(id);
        validator.emptyResult(carFound);
        dto.setId(id);
        return repositoryPort.create(dto);
    }
}

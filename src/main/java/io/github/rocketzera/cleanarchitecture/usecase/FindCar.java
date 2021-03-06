package io.github.rocketzera.cleanarchitecture.usecase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.github.rocketzera.cleanarchitecture.domain.model.Car;
import io.github.rocketzera.cleanarchitecture.usecase.port.CarRepositoryPort;
import io.github.rocketzera.cleanarchitecture.usecase.validator.CarValidator;

@Component
public class FindCar {

    @Autowired
    private CarRepositoryPort repositoryPort;
    
    @Autowired
    private CarValidator validator;

    public List<Car> findAll() {
        return repositoryPort.findAllCars();
    }

    public Car findById(Long id) {
        Car item = repositoryPort.findById(id);
        validator.emptyResult(item);
        return item;
    }

}

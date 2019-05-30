package io.github.rocketzera.cleanarchitecture.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.github.rocketzera.cleanarchitecture.adapter.controller.model.CarDTO;
import io.github.rocketzera.cleanarchitecture.adapter.repository.CarRepository;
import io.github.rocketzera.cleanarchitecture.domain.entity.Car;
import io.github.rocketzera.cleanarchitecture.usecase.assembler.CarAssembler;

@Component
public class CreateCar {

    @Autowired
    private CarRepository repository;

    public CarDTO create(CarDTO dto) {
        Car savedCar = repository.save(CarAssembler.adapt(dto));
        return CarAssembler.adapt(savedCar);
    }

}

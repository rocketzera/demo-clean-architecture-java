package io.github.rocketzera.cleanarchitecture.usecase.port;

import java.util.List;

import io.github.rocketzera.cleanarchitecture.domain.model.Car;

public interface CarRepositoryPort {
    Car create(Car user);
    
    Car update(Long id, Car user);
    
    void delete(Long id);

    Car findById(Long id);

    List<Car> findAllCars();
}

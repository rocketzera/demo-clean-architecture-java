package io.github.rocketzera.cleanarchitecture.adapter.repository.port;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.github.rocketzera.cleanarchitecture.adapter.repository.CarRepository;
import io.github.rocketzera.cleanarchitecture.adapter.repository.model.CarEntity;
import io.github.rocketzera.cleanarchitecture.domain.model.Car;
import io.github.rocketzera.cleanarchitecture.mapper.CarMapper;
import io.github.rocketzera.cleanarchitecture.usecase.port.CarRepositoryPort;

@Component
public class CarRepositoryPortImpl implements CarRepositoryPort {

    @Autowired
    private CarRepository repository;
    
    @Override
    public Car create(Car user) {
        CarEntity entity = repository.save(CarMapper.toRepository(user));
        return CarMapper.toUseCase(entity);
    }

    @Override
    public Car update(Long id, Car user) {
        CarEntity entity = repository.save(CarMapper.toRepository(user));
        return CarMapper.toUseCase(entity);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Car findById(Long id) {
        return CarMapper.toUseCase(repository.findById(id).orElse(null));
    }

    @Override
    public List<Car> findAllCars() {
        return CarMapper.toUseCase(repository.findAll());
    }

}

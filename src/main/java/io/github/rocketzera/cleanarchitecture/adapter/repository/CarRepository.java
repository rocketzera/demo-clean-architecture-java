package io.github.rocketzera.cleanarchitecture.adapter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.rocketzera.cleanarchitecture.domain.entity.Car;

public interface CarRepository extends JpaRepository<Car, Long> {

}

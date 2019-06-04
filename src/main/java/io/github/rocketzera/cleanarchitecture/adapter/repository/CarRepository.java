package io.github.rocketzera.cleanarchitecture.adapter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.rocketzera.cleanarchitecture.adapter.repository.model.CarEntity;

public interface CarRepository extends JpaRepository<CarEntity, Long> {

}

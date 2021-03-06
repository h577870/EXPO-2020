package com.expo2020.services;

import com.expo2020.models.Stand;

import java.util.List;
import java.util.Optional;

public interface IStandService {

    Optional<Stand> findById(Long id);

    List<Stand> findAll();

    Long count();

    void save(Stand entity);

    void delete(Long id);

}

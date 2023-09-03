package com.app.rest.model.service;

import com.app.rest.model.entity.Maker;

import java.util.List;
import java.util.Optional;

public interface MakerService {
    Optional<Maker> findById(Long id);

    List<Maker> findAll();

    void save(Maker maker);

    void deleteById(Long id);
}

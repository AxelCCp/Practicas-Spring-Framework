package com.app.rest.model.persistence;

import com.app.rest.model.entity.Maker;

import java.util.List;
import java.util.Optional;

public interface MakerDao {

    Optional<Maker> findById(Long id);

    List<Maker> findAll();

    void save(Maker maker);

    void deleteById(Long id);
}

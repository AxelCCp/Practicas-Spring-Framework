package com.app.rest.model.dao;

import com.app.rest.model.entity.Maker;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MakerRepo extends CrudRepository<Maker, Long> {
}

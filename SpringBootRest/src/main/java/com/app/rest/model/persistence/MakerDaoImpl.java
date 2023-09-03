package com.app.rest.model.persistence;

import com.app.rest.model.dao.MakerRepo;
import com.app.rest.model.entity.Maker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MakerDaoImpl implements MakerDao{

    @Override
    public Optional<Maker> findById(Long id) {
        return makerRepo.findById(id);
    }

    @Override
    public List<Maker> findAll() {
        return (List<Maker>) makerRepo.findAll();
    }

    @Override
    public void save(Maker maker) {
        makerRepo.save(maker);
    }

    @Override
    public void deleteById(Long id) {
        makerRepo.deleteById(id);
    }

    @Autowired
    private MakerRepo makerRepo;
}

package com.app.rest.model.service;

import com.app.rest.model.entity.Maker;
import com.app.rest.model.persistence.MakerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MakerServiceImpl implements MakerService{

    @Override
    public Optional<Maker> findById(Long id) {
        return makerDao.findById(id);
    }

    @Override
    public List<Maker> findAll() {
        return makerDao.findAll();
    }

    @Override
    public void save(Maker maker) {
        makerDao.save(maker);
    }

    @Override
    public void deleteById(Long id) {
        makerDao.deleteById(id);
    }

    @Autowired
    private MakerDao makerDao;
}

package com.example.LotusClone.service;

import com.example.LotusClone.model.ChuDe;
import com.example.LotusClone.repo.ChuDeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChuDeService {
    @Autowired
    ChuDeRepo chuDeRepo;
    public List<ChuDe> findAll() {
        return chuDeRepo.findAll();
    }
    public ChuDe findOne(int id) {
        return chuDeRepo.getById(id);
    }
    public void save(ChuDe chuDe) {
        chuDeRepo.save(chuDe);
    }
    public void delete(ChuDe chuDe) {
        chuDeRepo.delete(chuDe);
    }
}

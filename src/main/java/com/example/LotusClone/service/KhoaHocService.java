package com.example.LotusClone.service;

import com.example.LotusClone.model.KhoaHoc;
import com.example.LotusClone.repo.KhoaHocRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhoaHocService {
    @Autowired
    KhoaHocRepo khoaHocRepo;

    public List<KhoaHoc> findAll() {
        return khoaHocRepo.findAll();
    }
    public KhoaHoc findOne(int id) {
        return khoaHocRepo.getById(id);
    }
    public void save(KhoaHoc khoaHoc) {
        khoaHocRepo.save(khoaHoc);
    }
    public void delete(KhoaHoc khoaHoc) {
        khoaHocRepo.delete(khoaHoc);
    }
}

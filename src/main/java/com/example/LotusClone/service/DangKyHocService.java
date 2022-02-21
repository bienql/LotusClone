package com.example.LotusClone.service;

import com.example.LotusClone.model.DangKyHoc;
import com.example.LotusClone.repo.DangKyHocRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DangKyHocService {
    @Autowired
    DangKyHocRepo dangKyHocRepo;

    public List<DangKyHoc> findAll() {
        return dangKyHocRepo.findAll();
    }
    public DangKyHoc findOne(int id) {
        return dangKyHocRepo.getById(id);
    }
    public void save(DangKyHoc dangKyHoc) {
        dangKyHocRepo.save(dangKyHoc);
    }
    public void delete(DangKyHoc dangKyHoc) {
        dangKyHocRepo.delete(dangKyHoc);
    }
}

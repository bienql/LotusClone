package com.example.LotusClone.service;

import com.example.LotusClone.model.HocVien;
import com.example.LotusClone.repo.HocVienRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HocVienService {
    @Autowired
    HocVienRepo hocVienRepo;
    public List<HocVien> findAll() {
        return hocVienRepo.findAll();
    }
    public HocVien findOne(int id) {
        return hocVienRepo.getById(id);
    }
    public void save(HocVien hocVien) {
        hocVienRepo.save(hocVien);
    }
    public void delete(HocVien hocVien) {
        hocVienRepo.delete(hocVien);
    }
}

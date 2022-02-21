package com.example.LotusClone.service;

import com.example.LotusClone.model.LoaiKhoaHoc;
import com.example.LotusClone.repo.LoaiKhoaHocRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoaiKhoaHocService {
    @Autowired
    LoaiKhoaHocRepo loaiKhoaHocRepo;

    public List<LoaiKhoaHoc> findAll() {
        return loaiKhoaHocRepo.findAll();
    }
    public LoaiKhoaHoc findOne(int id) {
        return loaiKhoaHocRepo.getById(id);
    }
    public void save(LoaiKhoaHoc loaiKhoaHoc) {
        loaiKhoaHocRepo.save(loaiKhoaHoc);
    }
    public void delete(LoaiKhoaHoc loaiKhoaHoc) {
        loaiKhoaHocRepo.delete(loaiKhoaHoc);
    }
}

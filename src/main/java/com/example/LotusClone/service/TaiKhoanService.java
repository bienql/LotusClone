package com.example.LotusClone.service;

import com.example.LotusClone.model.TaiKhoan;
import com.example.LotusClone.repo.TaiKhoanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaiKhoanService {
    @Autowired
    TaiKhoanRepo taiKhoanRepo;

    public List<TaiKhoan> findAll() {
        return taiKhoanRepo.findAll();
    }
    public TaiKhoan findOne(int id) {
        return taiKhoanRepo.getById(id);
    }
    public void save(TaiKhoan taiKhoan) {
        taiKhoanRepo.save(taiKhoan);
    }
    public void delete(TaiKhoan taiKhoan) {
        taiKhoanRepo.delete(taiKhoan);
    }
}

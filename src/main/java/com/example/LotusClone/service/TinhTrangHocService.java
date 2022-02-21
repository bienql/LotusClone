package com.example.LotusClone.service;

import com.example.LotusClone.model.TinhTrangHoc;
import com.example.LotusClone.repo.TinhTrangHocRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TinhTrangHocService {
    @Autowired
    TinhTrangHocRepo tinhTrangHocRepo;

    public List<TinhTrangHoc> findAll() {
        return tinhTrangHocRepo.findAll();
    }
    public TinhTrangHoc findOne(int id) {
        return tinhTrangHocRepo.getById(id);
    }
    public void save(TinhTrangHoc tinhTrangHoc) {
        tinhTrangHocRepo.save(tinhTrangHoc);
    }
    public void delete(TinhTrangHoc tinhTrangHoc) {
        tinhTrangHocRepo.delete(tinhTrangHoc);
    }
}

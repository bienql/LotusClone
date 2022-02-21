package com.example.LotusClone.service;

import com.example.LotusClone.model.BaiViet;
import com.example.LotusClone.repo.BaiVietRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaiVietService {
    @Autowired
    BaiVietRepo baiVietRepo;
    public List<BaiViet> findAll() {
        return baiVietRepo.findAll();
    }
    public BaiViet findOne(int id) {
        return baiVietRepo.getById(id);
    }
    public void save(BaiViet baiViet) {
        baiVietRepo.save(baiViet);
    }
    public void delete(BaiViet baiViet) {
        baiVietRepo.delete(baiViet);
    }
}

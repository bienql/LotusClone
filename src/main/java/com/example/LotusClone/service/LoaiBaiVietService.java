package com.example.LotusClone.service;

import com.example.LotusClone.model.LoaiBaiViet;
import com.example.LotusClone.repo.LoaiBaiVietRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoaiBaiVietService {
    @Autowired
    LoaiBaiVietRepo loaiBaiVietRepo;

    public List<LoaiBaiViet> findAll() {
        return loaiBaiVietRepo.findAll();
    }
    public LoaiBaiViet findOne(int id) {
        return loaiBaiVietRepo.getById(id);
    }
    public void save(LoaiBaiViet loaiBaiViet) {
        loaiBaiVietRepo.save(loaiBaiViet);
    }
    public void delete(LoaiBaiViet loaiBaiViet) {
        loaiBaiVietRepo.delete(loaiBaiViet);
    }
}

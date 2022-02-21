package com.example.LotusClone.service;

import com.example.LotusClone.model.QuyenHan;
import com.example.LotusClone.repo.QuyenHanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuyenHanService {
    @Autowired
    QuyenHanRepo quyenHanRepo;

    public List<QuyenHan> findAll() {
        return quyenHanRepo.findAll();
    }
    public QuyenHan findOne(int id) {
        return quyenHanRepo.getById(id);
    }
    public void save(QuyenHan quyenHan) {
        quyenHanRepo.save(quyenHan);
    }
    public void delete(QuyenHan quyenHan) {
        quyenHanRepo.delete(quyenHan);
    }
}

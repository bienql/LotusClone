package com.example.LotusClone.repo;

import com.example.LotusClone.model.QuyenHan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuyenHanRepo extends JpaRepository<QuyenHan, Integer> {
}

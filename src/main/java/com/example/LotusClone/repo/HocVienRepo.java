package com.example.LotusClone.repo;

import com.example.LotusClone.model.HocVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HocVienRepo extends JpaRepository<HocVien, Integer> {
}

package com.example.LotusClone.repo;

import com.example.LotusClone.model.LoaiKhoaHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoaiKhoaHocRepo extends JpaRepository<LoaiKhoaHoc, Integer> {
}

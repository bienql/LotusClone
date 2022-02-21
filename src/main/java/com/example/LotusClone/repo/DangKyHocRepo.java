package com.example.LotusClone.repo;

import com.example.LotusClone.model.DangKyHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DangKyHocRepo extends JpaRepository<DangKyHoc, Integer> {
}

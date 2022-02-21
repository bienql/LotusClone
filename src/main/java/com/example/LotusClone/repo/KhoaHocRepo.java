package com.example.LotusClone.repo;

import com.example.LotusClone.model.KhoaHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KhoaHocRepo extends JpaRepository<KhoaHoc, Integer> {
}

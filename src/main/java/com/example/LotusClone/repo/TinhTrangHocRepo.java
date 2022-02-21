package com.example.LotusClone.repo;

import com.example.LotusClone.model.TinhTrangHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TinhTrangHocRepo extends JpaRepository<TinhTrangHoc, Integer> {
}

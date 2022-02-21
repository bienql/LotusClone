package com.example.LotusClone.repo;

import com.example.LotusClone.model.BaiViet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaiVietRepo extends JpaRepository<BaiViet, Integer> {
}

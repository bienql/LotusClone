package com.example.LotusClone.repo;

import com.example.LotusClone.model.LoaiBaiViet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoaiBaiVietRepo extends JpaRepository<LoaiBaiViet, Integer> {
}

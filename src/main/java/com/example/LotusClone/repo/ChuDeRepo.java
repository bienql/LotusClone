package com.example.LotusClone.repo;

import com.example.LotusClone.model.ChuDe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChuDeRepo extends JpaRepository<ChuDe, Integer> {
}

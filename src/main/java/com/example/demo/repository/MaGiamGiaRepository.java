package com.example.demo.repository;

import com.example.demo.entity.MaGiamGia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MaGiamGiaRepository extends JpaRepository<MaGiamGia, Integer> {
    @Query("SELECT c FROM MaGiamGia c WHERE c.maGiamGia like %?1%")
    List<MaGiamGia> listSearch(String ma);
}

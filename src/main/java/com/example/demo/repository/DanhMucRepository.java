package com.example.demo.repository;

import com.example.demo.entity.DanhMuc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DanhMucRepository extends JpaRepository<DanhMuc, Integer> {
    @Query("SELECT c FROM DanhMuc c WHERE c.maDanhMuc like %?1%")
    List<DanhMuc> listSearch(String ma);
}

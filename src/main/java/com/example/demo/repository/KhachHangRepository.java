package com.example.demo.repository;

import com.example.demo.entity.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface KhachHangRepository extends JpaRepository<KhachHang, Integer> {
    @Query("SELECT c FROM KhachHang c WHERE c.maKhachHang like %?1%")
    List<KhachHang> listSearch(String ma);
}

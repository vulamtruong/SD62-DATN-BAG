package com.example.demo.service;

import com.example.demo.entity.KhachHang;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface KhachHangService {
    Page<KhachHang> findAll(int currentPage, int pageSize);

    List<KhachHang> getAll();

    void add(KhachHang khachHang);

    void remove(Integer id);

    Optional<KhachHang> findById(Integer id);

    List<KhachHang> search(String ma);
}

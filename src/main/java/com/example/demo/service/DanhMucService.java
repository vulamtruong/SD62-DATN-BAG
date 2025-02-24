package com.example.demo.service;

import com.example.demo.entity.DanhMuc;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface DanhMucService {
    Page<DanhMuc> findAll(int currentPage, int pageSize);

    List<DanhMuc> getAll();

    void add(DanhMuc danhMuc);

    void remove(Integer id);

    Optional<DanhMuc> findById(Integer id);

    List<DanhMuc> search(String ma);
}

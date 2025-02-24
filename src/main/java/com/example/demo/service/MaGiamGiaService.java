package com.example.demo.service;

import com.example.demo.entity.MaGiamGia;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface MaGiamGiaService {
    Page<MaGiamGia> findAll(int currentPage, int pageSize);

    List<MaGiamGia> getAll();

    void add(MaGiamGia maGiamGia);

    void remove(Integer id);

    Optional<MaGiamGia> findById(Integer id);

    List<MaGiamGia> search(String ma);
}

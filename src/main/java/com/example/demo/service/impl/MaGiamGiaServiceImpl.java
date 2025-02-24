package com.example.demo.service.impl;

import com.example.demo.entity.MaGiamGia;
import com.example.demo.repository.MaGiamGiaRepository;
import com.example.demo.service.MaGiamGiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaGiamGiaServiceImpl implements MaGiamGiaService {
    @Autowired
    private MaGiamGiaRepository maGiamGiaRepository;

    @Override
    public Page<MaGiamGia> findAll(int currentPage, int pageSize) {
        return this.maGiamGiaRepository.findAll(PageRequest.of(currentPage, pageSize, Sort.by("id").descending()));
    }

    @Override
    public List<MaGiamGia> getAll() {
        return maGiamGiaRepository.findAll();
    }

    @Override
    public void add(MaGiamGia maGiamGia) {
        maGiamGiaRepository.save(maGiamGia);
    }

    @Override
    public void remove(Integer id) {
        maGiamGiaRepository.deleteById(id);
    }

    @Override
    public Optional<MaGiamGia> findById(Integer id) {
        return this.maGiamGiaRepository.findById(id);
    }

    @Override
    public List<MaGiamGia> search(String ma) {
        return maGiamGiaRepository.listSearch(ma);
    }
}

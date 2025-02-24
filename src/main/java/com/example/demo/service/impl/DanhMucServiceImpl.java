package com.example.demo.service.impl;

import com.example.demo.entity.DanhMuc;
import com.example.demo.repository.DanhMucRepository;
import com.example.demo.service.DanhMucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DanhMucServiceImpl implements DanhMucService {
    @Autowired
    private DanhMucRepository danhMucRepository;

    @Override
    public Page<DanhMuc> findAll(int currentPage, int pageSize) {
        return this.danhMucRepository.findAll(PageRequest.of(currentPage, pageSize, Sort.by("id").descending()));
    }

    @Override
    public List<DanhMuc> getAll() {
        return danhMucRepository.findAll();
    }

    @Override
    public void add(DanhMuc danhMuc) {
        danhMucRepository.save(danhMuc);
    }

    @Override
    public void remove(Integer id) {
        danhMucRepository.deleteById(id);
    }

    @Override
    public Optional<DanhMuc> findById(Integer id) {
        return this.danhMucRepository.findById(id);
    }

    @Override
    public List<DanhMuc> search(String ma) {
        return danhMucRepository.listSearch(ma);
    }
}

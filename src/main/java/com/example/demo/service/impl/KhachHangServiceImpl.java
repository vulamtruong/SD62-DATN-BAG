package com.example.demo.service.impl;

import com.example.demo.entity.KhachHang;
import com.example.demo.repository.KhachHangRepository;
import com.example.demo.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KhachHangServiceImpl implements KhachHangService {
    @Autowired
    private KhachHangRepository khachHangRepository;

    @Override
    public Page<KhachHang> findAll(int currentPage, int pageSize) {
        return this.khachHangRepository.findAll(PageRequest.of(currentPage, pageSize, Sort.by("id").descending()));
    }

    @Override
    public List<KhachHang> getAll() {
        return khachHangRepository.findAll();
    }

    @Override
    public void add(KhachHang khachHang) {
        khachHangRepository.save(khachHang);
    }

    @Override
    public void remove(Integer id) {
        khachHangRepository.deleteById(id);
    }

    @Override
    public Optional<KhachHang> findById(Integer id) {
        return this.khachHangRepository.findById(id);
    }

    @Override
    public List<KhachHang> search(String ma) {
        return khachHangRepository.listSearch(ma);
    }
}

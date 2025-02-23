package com.example.demo.controller;

import com.example.demo.entity.ThoiGianBaoHanh;
import com.example.demo.entity.ThuongHieu;
import com.example.demo.repository.ThoiGianBaoHanhRepository;
import com.example.demo.repository.ThuongHieuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ThoiGianBaoHanhController {

    @Autowired
    private ThoiGianBaoHanhRepository thoiGianBaoHanhRepositoryRepository;
    @GetMapping("/thoi-gian-bao-hanh/hien-thi")
    public String hienThi(Model model){
        model.addAttribute("listt", thoiGianBaoHanhRepositoryRepository.findAll());
        return "thoi-gian-bao-hanh";

    }
    @PostMapping("/thoi-gian-bao-hanh/add")
    public String add(ThoiGianBaoHanh thoiGianBaoHanh){
        thoiGianBaoHanhRepositoryRepository.save(thoiGianBaoHanh);
        return "redirect:/thoi-gian-bao-hanh/hien-thi";
    }

    @GetMapping("/thoi-gian-bao-hanh/remove/{id}")
    public String remove(@PathVariable Integer id){
        ThoiGianBaoHanh thoiGianBaoHanh = thoiGianBaoHanhRepositoryRepository.findById(id).get();
        thoiGianBaoHanhRepositoryRepository.delete(thoiGianBaoHanh);
        return "redirect:/thoi-gian-bao-hanh/hien-thi";
    }
    @GetMapping("/thoi-gian-bao-hanh/detail/{id}")
    public String detail(@PathVariable Integer id, Model model){
        ThoiGianBaoHanh th = thoiGianBaoHanhRepositoryRepository.findById(id).get();
        model.addAttribute("detail", th);


        return "thoi-gian-bao-hanh";
    }

    @GetMapping("/thoi-gian-bao-hanh/view-update/{id}")
    public String viewUpdate(@PathVariable Integer id, Model model){
        ThoiGianBaoHanh th = thoiGianBaoHanhRepositoryRepository.findById(id).get();
        model.addAttribute("detail", th);
        model.addAttribute("listt", thoiGianBaoHanhRepositoryRepository.findAll());
        return "update-thoi-gian-bao-hanh";
    }

    @PostMapping("/thoi-gian-bao-hanh/update/{id}")
    public String update(@PathVariable Integer id, ThoiGianBaoHanh t) {
        // Tìm thương hiệu theo ID
        ThoiGianBaoHanh th = thoiGianBaoHanhRepositoryRepository.findById(id).orElse(null);
        if (th != null) {
            // Cập nhật thông tin từ form
            th.setMa(t.getMa());
            th.setThoiGian(t.getThoiGian());
            th.setTrangThai(t.getTrangThai());
            thoiGianBaoHanhRepositoryRepository.save(th); // Lưu lại vào database
        }
        return "redirect:/thoi-gian-bao-hanh/hien-thi";
    }
}

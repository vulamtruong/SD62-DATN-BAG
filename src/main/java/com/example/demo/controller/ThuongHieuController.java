package com.example.demo.controller;


import com.example.demo.entity.ThuongHieu;
import com.example.demo.repository.ThuongHieuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ThuongHieuController {

    @Autowired
private ThuongHieuRepository thuongHieuRepository;
    @GetMapping("/thuong-hieu/hien-thi")
    public String hienThi(Model model){
        model.addAttribute("listt", thuongHieuRepository.findAll());
        return "thuong-hieu";

    }
    @PostMapping("/thuong-hieu/add")
    public String add(ThuongHieu thuongHieu){
        thuongHieuRepository.save(thuongHieu);
        return "redirect:/thuong-hieu/hien-thi";
    }

    @GetMapping("/thuong-hieu/remove/{id}")
    public String remove(@PathVariable Integer id){
        ThuongHieu thuongHieu = thuongHieuRepository.findById(id).get();
        thuongHieuRepository.delete(thuongHieu);
        return "redirect:/thuong-hieu/hien-thi";
    }

    @GetMapping("/thuong-hieu/detail/{id}")
    public String detail(@PathVariable Integer id, Model model){
        ThuongHieu th = thuongHieuRepository.findById(id).get();
        model.addAttribute("detail", th);


        return "thuong-hieu";
    }

    @GetMapping("/thuong-hieu/view-update/{id}")
    public String viewUpdate(@PathVariable Integer id, Model model){
        ThuongHieu th = thuongHieuRepository.findById(id).get();
        model.addAttribute("detail", th);
        model.addAttribute("listt", thuongHieuRepository.findAll());
        return "update-thuong-hieu";
    }

    @PostMapping("/thuong-hieu/update/{id}")
    public String update(@PathVariable Integer id, ThuongHieu thuongHieu) {
        // Tìm thương hiệu theo ID
        ThuongHieu th = thuongHieuRepository.findById(id).orElse(null);
        if (th != null) {
            // Cập nhật thông tin từ form
            th.setMa(thuongHieu.getMa());
            th.setTen(thuongHieu.getTen());
            th.setTrangThai(thuongHieu.getTrangThai());
            thuongHieuRepository.save(th); // Lưu lại vào database
        }
        return "redirect:/thuong-hieu/hien-thi";
    }

}

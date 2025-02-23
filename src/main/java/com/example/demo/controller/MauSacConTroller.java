package com.example.demo.controller;


import com.example.demo.entity.MauSac;
import com.example.demo.entity.ThuongHieu;
import com.example.demo.repository.MauSacRepository;
import com.example.demo.repository.ThuongHieuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MauSacConTroller {

    @Autowired
private MauSacRepository mauSacRepository;
    @GetMapping("/mau-sac/hien-thi")
    public String hienThi(Model model){
        model.addAttribute("listt", mauSacRepository.findAll());
        return "mau-sac";

    }
    @PostMapping("/mau-sac/add")
    public String add(MauSac mauSac){
        mauSacRepository.save(mauSac);
        return "redirect:/mau-sac/hien-thi";
    }

    @GetMapping("/mau-sac/remove/{id}")
    public String remove(@PathVariable Integer id){
        MauSac mauSac = mauSacRepository.findById(id).get();
        mauSacRepository.delete(mauSac);
        return "redirect:/mau-sac/hien-thi";
    }

    @GetMapping("/mau-sac/detail/{id}")
    public String detail(@PathVariable Integer id, Model model){
        MauSac th = mauSacRepository.findById(id).get();
        model.addAttribute("detail", th);


        return "mau-sac";
    }

    @GetMapping("/mau-sac/view-update/{id}")
    public String viewUpdate(@PathVariable Integer id, Model model){
        MauSac th = mauSacRepository.findById(id).get();
        model.addAttribute("detail", th);
        model.addAttribute("listt", mauSacRepository.findAll());
        return "update-mau-sac";
    }

    @PostMapping("/mau-sac/update/{id}")
    public String update(@PathVariable Integer id, MauSac mauSac) {
        // Tìm thương hiệu theo ID
        MauSac th = mauSacRepository.findById(id).orElse(null);
        if (th != null) {
            // Cập nhật thông tin từ form
            th.setMa(mauSac.getMa());
            th.setTen(mauSac.getTen());
            mauSacRepository.save(th); // Lưu lại vào database
        }
        return "redirect:/mau-sac/hien-thi";
    }

}

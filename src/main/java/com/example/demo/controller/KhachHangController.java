package com.example.demo.controller;

import com.example.demo.entity.KhachHang;
import com.example.demo.service.KhachHangService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class KhachHangController {
    @Autowired
    private KhachHangService khachHangService;

    @GetMapping("/khach-hang/hien-thi")
    public String hienThiDuLieu(@RequestParam(value = "page", defaultValue = "1") int currentPage, Model model) {
        Page<KhachHang> page = khachHangService.findAll(currentPage - 1, 5);
        model.addAttribute("list", page.getContent());
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", page.getTotalPages());

//        model.addAttribute("listChucVu", chucVuService.getAll());
        model.addAttribute("kh", new KhachHang());
        return "khach_hang/index";
    }

    @PostMapping("/khach-hang/add")
    public String add(@Valid @ModelAttribute("kh") KhachHang khachHang, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("list", khachHangService.getAll());
            return "khach_hang/index";
        }
        khachHangService.add(khachHang);
        return "redirect:/khach-hang/hien-thi";
    }

    @GetMapping("/khach-hang/view-update")
    public String viewUpdate(@RequestParam("id") Integer id, Model model) {
        Optional<KhachHang> khachHangOptional = khachHangService.findById(id);

        if (khachHangOptional.isEmpty()) {
            return "redirect:/khach-hang/hien-thi";
        }
        model.addAttribute("kh", khachHangOptional.get());
//        model.addAttribute("listChucVu", chucVuService.getAll());

        return "khach_hang/view-update";
    }

    @PostMapping("/khach-hang/update")
    public String update(@Valid @ModelAttribute("kh") KhachHang khachHang, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("list", khachHangService.getAll());
            return "khach_hang/view-update";
        }
        khachHangService.add(khachHang);
        return "redirect:/khach-hang/hien-thi";
    }

    @GetMapping("/khach-hang/remove")
    public String delete(@RequestParam("id") Integer id) {
        khachHangService.remove(id);
        return "redirect:/khach-hang/hien-thi";
    }

    @GetMapping("/khach-hang/search")
    public String search(@RequestParam("ma") String ma,
                         Model model) {
        if (ma.isBlank()) {
            model.addAttribute("list", khachHangService.getAll());
            model.addAttribute("kh", new KhachHang());

            return "khach_hang/index";
        } else {
            model.addAttribute("list", khachHangService.search(ma));
            model.addAttribute("kh", new KhachHang());

            return "khach_hang/index";
        }
    }
}

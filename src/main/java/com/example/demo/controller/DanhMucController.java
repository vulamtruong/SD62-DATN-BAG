package com.example.demo.controller;

import com.example.demo.entity.DanhMuc;
import com.example.demo.service.DanhMucService;
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
public class DanhMucController {
    @Autowired
    private DanhMucService danhMucService;

    @GetMapping("/danh-muc/hien-thi")
    public String hienThiDuLieu(@RequestParam(value = "page", defaultValue = "1") int currentPage, Model model) {
        Page<DanhMuc> page = danhMucService.findAll(currentPage - 1, 5);
        model.addAttribute("list", page.getContent());
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", page.getTotalPages());

//        model.addAttribute("listChucVu", chucVuService.getAll());
        model.addAttribute("dm", new DanhMuc());
        return "danh_muc/index";
    }

    @PostMapping("/danh-muc/add")
    public String add(@Valid @ModelAttribute("dm") DanhMuc danhMuc, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("list", danhMucService.getAll());
            return "danh_muc/index";
        }
        danhMucService.add(danhMuc);
        return "redirect:/danh-muc/hien-thi";
    }

    @GetMapping("/danh-muc/view-update")
    public String viewUpdate(@RequestParam("id") Integer id, Model model) {
        Optional<DanhMuc> danhMucOptional = danhMucService.findById(id);

        if (danhMucOptional.isEmpty()) {
            return "redirect:/danh-muc/hien-thi";
        }
        model.addAttribute("dm", danhMucOptional.get());
//        model.addAttribute("listChucVu", chucVuService.getAll());

        return "danh_muc/view-update";
    }

    @PostMapping("/danh-muc/update")
    public String update(@Valid @ModelAttribute("dm") DanhMuc danhMuc, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("list", danhMucService.getAll());
            return "dang_muc/view-update";
        }
        danhMucService.add(danhMuc);
        return "redirect:/danh-muc/hien-thi";
    }

    @GetMapping("/danh-muc/remove")
    public String delete(@RequestParam("id") Integer id) {
        danhMucService.remove(id);
        return "redirect:/danh-muc/hien-thi";
    }

    @GetMapping("/danh-muc/search")
    public String search(@RequestParam("ma") String ma,
                         Model model) {
        if (ma.isBlank()) {
            model.addAttribute("list", danhMucService.getAll());
            model.addAttribute("dm", new DanhMuc());

            return "danh_muc/index";
        } else {
            model.addAttribute("list", danhMucService.search(ma));
            model.addAttribute("dm", new DanhMuc());

            return "danh_muc/index";
        }
    }
}

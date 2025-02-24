package com.example.demo.controller;

import com.example.demo.entity.MaGiamGia;
import com.example.demo.service.MaGiamGiaService;
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
public class MaGiamGiaController {
    @Autowired
    private MaGiamGiaService maGiamGiaService;

    @GetMapping("/ma-giam-gia/hien-thi")
    public String hienThiDuLieu(@RequestParam(value = "page", defaultValue = "1") int currentPage, Model model) {
        Page<MaGiamGia> page = maGiamGiaService.findAll(currentPage - 1, 5);
        model.addAttribute("list", page.getContent());
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", page.getTotalPages());

//        model.addAttribute("listChucVu", chucVuService.getAll());
        model.addAttribute("mgg", new MaGiamGia());
        return "ma_giam_gia/index";
    }

    @PostMapping("/ma-giam-gia/add")
    public String add(@Valid @ModelAttribute("mgg") MaGiamGia maGiamGia, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("list", maGiamGiaService.getAll());
            return "ma_giam_gia/index";
        }
        maGiamGiaService.add(maGiamGia);
        return "redirect:/ma-giam-gia/hien-thi";
    }

    @GetMapping("/ma-giam-gia/view-update")
    public String viewUpdate(@RequestParam("id") Integer id, Model model) {
        Optional<MaGiamGia> maGiamGiaOptional = maGiamGiaService.findById(id);

        if (maGiamGiaOptional.isEmpty()) {
            return "redirect:/ma-giam-gia/hien-thi";
        }
        model.addAttribute("mgg", maGiamGiaOptional.get());
//        model.addAttribute("listChucVu", chucVuService.getAll());

        return "ma_giam_gia/view-update";
    }

    @PostMapping("/ma-giam-gia/update")
    public String update(@Valid @ModelAttribute("mgg") MaGiamGia maGiamGia, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("list", maGiamGiaService.getAll());
            return "ma_giam_gia/view-update";
        }
        maGiamGiaService.add(maGiamGia);
        return "redirect:/ma-giam-gia/hien-thi";
    }

    @GetMapping("/ma-giam-gia/remove")
    public String delete(@RequestParam("id") Integer id) {
        maGiamGiaService.remove(id);
        return "redirect:/ma-giam-gia/hien-thi";
    }

    @GetMapping("/ma-giam-gia/search")
    public String search(@RequestParam("ma") String ma,
                         Model model) {
        if (ma.isBlank()) {
            model.addAttribute("list", maGiamGiaService.getAll());
            model.addAttribute("mgg", new MaGiamGia());

            return "ma_giam_gia/index";
        } else {
            model.addAttribute("list", maGiamGiaService.search(ma));
            model.addAttribute("mgg", new MaGiamGia());

            return "ma_giam_gia/index";
        }
    }
}

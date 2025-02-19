package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "san_pham")
@AllArgsConstructor
@NoArgsConstructor

public class SanPham {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "ma_san_pham")
    private String maSanPham;

    @Column(name = "ten")
    private String tenSanPham;

    @Column(name = "anh")
    private String anh;

    @Column(name = "product_url")
    private String productUrl;

    @Column(name = "kick_thuoc")
    private String kickThuoc;

    @Column(name = "khoi_luong")
    private Double khoiLuong;

    @Column(name = "chat_lieu")
    private String chatLieu;

    @Column(name = "xuat_xu")
    private String xuatXu;

    @Column(name = "mo_ta")
    private String moTa;

    @Column(name = "trang_thai")
    private Boolean trangThai;

    @ManyToOne
    @JoinColumn(name = "id_thoi_gian_bao_hanh")
    private ThoiGianBaoHanh thoiGianBaoHanh;

    @ManyToOne
    @JoinColumn(name = "id_thuong_hieu")
    private ThuongHieu thuongHieu;

    @ManyToOne
    @JoinColumn(name = "id_danh_muc")
    private DanhMuc danhMuc;

    @ManyToOne
    @JoinColumn(name = "id_doi_tuong_su_dung")
    private DoiTuongSuDung doiTuongSuDung;

}

package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Entity
@Table(name = "ma_giam_gia")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class MaGiamGia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "ma_giam_gia")
    private String maGiamGia;

    @Column(name = "ten_ma_giam_gia")
    private String tenMaGiamGia;

    @Column(name = "gia_tri_giam")
    private Double giaTriGiam;

    @Column(name = "ngay_bat_dau")
    private Date ngayBatDau;

    @Column(name = "ngay_ket_thuc")
    private Date ngayKetThuc;

    @Column(name = "mo_ta")
    private String moTa;

    @Column(name = "so_luong")
    private Integer soLuong;

    @Column(name = "dieu_kien")
    private Integer dieuKien;

    @Column(name = "trang_thai")
    private Integer trangThai;
}

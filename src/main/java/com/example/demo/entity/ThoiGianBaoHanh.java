package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "thoi_gian_bao_hanh")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ThoiGianBaoHanh {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "ma")
    private String ma;

    @Column(name = "thoi_gian")
    private String thoiGian;

    @Column(name = "trang_thai")
    private Integer trangThai;
}

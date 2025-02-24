package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Entity
@Table(name = "khach_hang")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "ma_khach_hang")
    @NotEmpty(message = "Vui lòng nhập mã")
    private String maKhachHang;

    @Column(name = "ten_khach_hang")
    @NotEmpty(message = "Vui lòng nhập tên")
    private String tenKhachHang;

    @Column(name = "gioi_tinh")
//    @NotEmpty(message = "Vui lòng nhập giới tính")
    private Integer gioiTinh;

    @Column(name = "ngay_sinh")
//    @Past(message = "Ngày sinh không được vượt quá ngày tháng năm hiện tại")
    private String ngaySinh;

    @Column(name = "sdt")
    @NotEmpty(message = "Vui lòng nhập SDT")
    private String soDienThoai;

    @Column(name = "email")
    @NotEmpty(message = "Vui lòng nhập email")
    private String email;

    @Column(name = "trang_thai")
    @NotNull(message = "Vui lòng chọn trạng thái")
    private Integer trangThai;

    @Column(name = "mat_khau")
    @NotEmpty(message = "Vui lòng nhập mk")
    private String matKhau;

}

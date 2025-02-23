package com.example.demo.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "mau_sac")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MauSac {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "ma")
    private String ma;

    @Column(name = "ten")
    private String ten;
}

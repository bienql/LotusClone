package com.example.LotusClone.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table
@Getter
@Setter
public class HocVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int hocVienID;

    @Column
    String hinhAnh;

    @Column(length = 50, nullable = false)
    String hoTen;

    @Column(nullable = false)
    LocalDate ngaySinh;

    @Digits(integer = 11, fraction = 0)
    @Column(length = 11, nullable = false)
    String soDienThoai;

    @Column(length = 40, nullable = false)
    String email;

    @Column(length = 50)
    String tinhThanh;

    @Column(length = 50)
    String quanHuyen;

    @Column(length = 50)
    String phuongXa;

    @Column(length = 50, nullable = false)
    String soNha;
}

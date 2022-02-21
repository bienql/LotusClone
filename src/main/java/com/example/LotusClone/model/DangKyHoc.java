package com.example.LotusClone.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
@Getter
@Setter
public class DangKyHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int dangKyHocID;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "khoaHocID")
    @JsonIgnoreProperties
    KhoaHoc khoaHoc;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "hocVienID")
    @JsonIgnoreProperties
    HocVien hocVien;

    @Column
    LocalDate ngayDangKy;

    @Column
    LocalDate ngayBatDau;

    @Column
    LocalDate ngayKetThuc;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "tinhTrangHocID")
    @JsonIgnoreProperties
    TinhTrangHoc tinhTrangHoc;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "taiKhoanID")
    @JsonIgnoreProperties
    TaiKhoan taiKhoan;
}

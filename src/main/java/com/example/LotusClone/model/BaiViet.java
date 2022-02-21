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
public class BaiViet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int baiVietID;

    @Column(length = 50)
    String tenBaiViet;

    @Column
    LocalDate thoiGianTao;

    @Column(length = 50)
    String tenTacGia;

    @Column
    String noiDung;

    @Column
    String noiDungNgan;

    @Column
    String hinhAnh;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "chuDeID")
    @JsonIgnoreProperties
    ChuDe chuDe;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "taiKhoanID")
    @JsonIgnoreProperties
    TaiKhoan taiKhoan;
}

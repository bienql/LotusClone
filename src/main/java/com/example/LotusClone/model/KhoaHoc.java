package com.example.LotusClone.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
public class KhoaHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int khoaHocID;

    @Column(nullable = false)
    String tenKhoaHoc;

    @Column(nullable = false)
    int thoiGianHoc;

    @Lob
    @Column
    String gioiThieu;

    @Column
    String noiDung;

    @Column(nullable = false)
    long hocPhi;

    @Column
    int soHocVien;

    @Column(nullable = false)
    int soLuongMon;

    @Lob
    @Column
    String hinhAnh;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "loaiKhoaHocID")
    @JsonIgnoreProperties
    LoaiKhoaHoc loaiKhoaHoc;
}

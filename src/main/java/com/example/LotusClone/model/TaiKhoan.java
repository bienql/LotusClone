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
public class TaiKhoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int taiKhoanID;

    @Column
    String tenNguoiDung;

    @Column
    String matKhau;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "quyenHanID")
    @JsonIgnoreProperties
    QuyenHan quyenHan;
}

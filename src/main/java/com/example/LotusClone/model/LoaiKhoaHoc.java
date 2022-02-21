package com.example.LotusClone.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
public class LoaiKhoaHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int loaiKhoaHocID;

    @Column
    String tenLoai;
}

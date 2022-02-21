package com.example.LotusClone.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
public class TinhTrangHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int tinhTrangHocID;

    @Column
    String tenTinhTrangHoc;
}

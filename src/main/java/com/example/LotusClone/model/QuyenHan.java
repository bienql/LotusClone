package com.example.LotusClone.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
public class QuyenHan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int quyenHanID;

    @Column
    String tenQuyenHan;
}

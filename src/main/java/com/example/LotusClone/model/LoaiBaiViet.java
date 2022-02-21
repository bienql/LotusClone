package com.example.LotusClone.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
public class LoaiBaiViet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int loaiBaiVietID;

    @Column
    String tenLoaiBaiViet;
}

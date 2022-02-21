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
public class ChuDe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int chuDeID;

    @Column(length = 50)
    String tenChuDe;

    @Column
    String noiDung;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "loaiBaiVietID")
    @JsonIgnoreProperties
    LoaiBaiViet loaiBaiViet;
}

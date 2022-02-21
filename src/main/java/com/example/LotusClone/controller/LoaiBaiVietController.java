package com.example.LotusClone.controller;

import com.example.LotusClone.model.LoaiBaiViet;
import com.example.LotusClone.model.TinhTrangHoc;
import com.example.LotusClone.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loaibaiviet")
public class LoaiBaiVietController {
    @Autowired
    BaiVietService baiVietService;
    @Autowired
    ChuDeService chuDeService;
    @Autowired
    DangKyHocService dangKyHocService;
    @Autowired
    HocVienService hocVienService;
    @Autowired
    KhoaHocService khoaHocService;
    @Autowired
    LoaiBaiVietService loaiBaiVietService;
    @Autowired
    LoaiKhoaHocService loaiKhoaHocService;
    @Autowired
    QuyenHanService quyenHanService;
    @Autowired
    TaiKhoanService taiKhoanService;
    @Autowired
    TinhTrangHocService tinhTrangHocService;

    @GetMapping("/")
    public List<LoaiBaiViet> findAll() {
        return loaiBaiVietService.findAll();
    }

    @PutMapping("/sua")
    public void suaLoaiBaiViet(@RequestBody LoaiBaiViet loaiBaiViet) {
        loaiBaiVietService.save(loaiBaiViet);
    }

    @DeleteMapping("/xoa")
    public void xoaLoaiBaiViet(@RequestParam int id) {
        loaiBaiVietService.delete(loaiBaiVietService.findOne(id));
    }

    @PostMapping("/them")
    public void themLoaiBaiViet(@RequestParam String tenloai) {
        LoaiBaiViet loaiBaiViet = new LoaiBaiViet();
        loaiBaiViet.setTenLoaiBaiViet(tenloai);
        loaiBaiVietService.save(loaiBaiViet);
    }
}

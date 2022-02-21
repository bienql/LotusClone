package com.example.LotusClone.controller;

import com.example.LotusClone.model.ChuDe;
import com.example.LotusClone.model.LoaiKhoaHoc;
import com.example.LotusClone.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loaikhoahoc")
public class LoaiKhoaHocController {
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
    public List<LoaiKhoaHoc> findAll() {
        return loaiKhoaHocService.findAll();
    }

    @PutMapping("/sua")
    public void suaLoaiKhoaHoc(@RequestBody LoaiKhoaHoc loaiKhoaHoc) {
        loaiKhoaHocService.save(loaiKhoaHoc);
    }

    @DeleteMapping("/xoa")
    public void xoaLoaiKhoaHoc(@RequestParam int id) {
        loaiKhoaHocService.delete(loaiKhoaHocService.findOne(id));
    }

    @PostMapping("/them")
    public void themLoaiKhoaHoc(@RequestParam String tenloai) {
        LoaiKhoaHoc loaiKhoaHoc = new LoaiKhoaHoc();
        loaiKhoaHoc.setTenLoai(tenloai);
        loaiKhoaHocService.save(loaiKhoaHoc);
    }
}

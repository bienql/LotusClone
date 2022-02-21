package com.example.LotusClone.controller;

import com.example.LotusClone.model.ChuDe;
import com.example.LotusClone.model.TinhTrangHoc;
import com.example.LotusClone.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tinhtranghoc")
public class TinhTrangHocController {
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
    public List<TinhTrangHoc> findAll() {
        return tinhTrangHocService.findAll();
    }

    @PutMapping("/sua")
    public void suaTinhTrangHoc(@RequestBody TinhTrangHoc tinhTrangHoc) {
        tinhTrangHocService.save(tinhTrangHoc);
    }

    @DeleteMapping("/xoa")
    public void xoaTinhTrangHoc(@RequestParam int id) {
        tinhTrangHocService.delete(tinhTrangHocService.findOne(id));
    }

    @PostMapping("/them")
    public String themTinhTrangHoc(@RequestParam String tentinhtranghoc) {
        TinhTrangHoc tinhTrangHoc = new TinhTrangHoc();
        tinhTrangHoc.setTenTinhTrangHoc(tentinhtranghoc);
        tinhTrangHocService.save(tinhTrangHoc);
        return "Added successfully!";
    }
}

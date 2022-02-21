package com.example.LotusClone.controller;

import com.example.LotusClone.model.LoaiBaiViet;
import com.example.LotusClone.model.QuyenHan;
import com.example.LotusClone.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quyenhan")
public class QuyenHanController {
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
    public List<QuyenHan> findAll() {
        return quyenHanService.findAll();
    }

    @PutMapping("/sua")
    public void suaQuyenHan(@RequestBody QuyenHan quyenHan) {
        quyenHanService.save(quyenHan);
    }

    @DeleteMapping("/xoa")
    public void xoaQuyenHan(@RequestParam int id) {
        quyenHanService.delete(quyenHanService.findOne(id));
    }

    @PostMapping("/them")
    public void themQuyenHan(@RequestParam String tenquyenhan) {
        QuyenHan quyenHan = new QuyenHan();
        quyenHan.setTenQuyenHan(tenquyenhan);
        quyenHanService.save(quyenHan);
    }
}

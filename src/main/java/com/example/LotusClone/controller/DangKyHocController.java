package com.example.LotusClone.controller;

import com.example.LotusClone.model.*;
import com.example.LotusClone.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/dangkyhoc")
public class DangKyHocController {
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
    public List<DangKyHoc> findAll() {
        return dangKyHocService.findAll();
    }

    @PutMapping("/sua")
    public void suaDangKyHoc(@RequestBody DangKyHoc dangKyHoc) {
        dangKyHocService.save(dangKyHoc);
    }

    @DeleteMapping("/xoa")
    public void xoaDangKyHoc(@RequestParam int id) {
        DangKyHoc dangKyHoc = dangKyHocService.findOne(id);
        khoaHocService.findAll().stream().filter(x -> x.getKhoaHocID() == id).forEach(x -> x.setSoHocVien(x.getSoHocVien() - 1));
        dangKyHocService.delete(dangKyHoc);

    }

    @PostMapping("/them")
    public void themDangKyHoc(@RequestParam String ngaybatdau, int tinhtranghocid, int khoahocid, int hocvienid, int taikhoanid) {
        DangKyHoc dangKyHoc = new DangKyHoc();
        dangKyHoc.setNgayDangKy(LocalDate.now());

        LocalDate startdate = LocalDate.parse(ngaybatdau);
        dangKyHoc.setNgayBatDau(startdate);
        int thoiGianHoc = khoaHocService.findAll().stream().filter(x -> x.getKhoaHocID() == khoahocid).findFirst().get().getThoiGianHoc();
        dangKyHoc.setNgayKetThuc(startdate.plusDays(thoiGianHoc));

        TinhTrangHoc tinhTrangHoc = tinhTrangHocService.findOne(tinhtranghocid);
        dangKyHoc.setTinhTrangHoc(tinhTrangHoc);

        TaiKhoan taiKhoan = taiKhoanService.findOne(taikhoanid);
        dangKyHoc.setTaiKhoan(taiKhoan);

        KhoaHoc khoaHoc = khoaHocService.findOne(khoahocid);
        khoaHoc.setSoHocVien(khoaHoc.getSoHocVien() + 1);
        dangKyHoc.setKhoaHoc(khoaHoc);

        HocVien hocVien = hocVienService.findOne(hocvienid);
        dangKyHoc.setHocVien(hocVien);

        ValidatorFactory valfac = Validation.buildDefaultValidatorFactory();
        Validator validator = valfac.getValidator();
        Set<ConstraintViolation<DangKyHoc>> violation = validator.validate(dangKyHoc);
        violation.forEach(x -> System.out.println(x.getMessage()));
        if(violation.size() == 0) {
            dangKyHocService.save(dangKyHoc);
        }
    }
}

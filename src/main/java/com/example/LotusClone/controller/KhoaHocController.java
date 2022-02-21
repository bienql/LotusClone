package com.example.LotusClone.controller;

import com.example.LotusClone.model.DangKyHoc;
import com.example.LotusClone.model.HocVien;
import com.example.LotusClone.model.KhoaHoc;
import com.example.LotusClone.model.LoaiKhoaHoc;
import com.example.LotusClone.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/khoahoc")
public class KhoaHocController {
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
    public List<KhoaHoc> findAll() {
        return khoaHocService.findAll();
    }

    @PutMapping("/sua")
    public void suaKhoaHoc(@RequestBody KhoaHoc khoaHoc) {
        khoaHocService.save(khoaHoc);
    }

    @DeleteMapping("/xoa")
    public void suaKhoaHoc(@RequestParam int id) {
        khoaHocService.delete(khoaHocService.findOne(id));
    }

    @PostMapping("/them")
    public String themKhoaHoc(@RequestParam String tenkhoahoc, int thoigianhoc, String gioithieu, String noidung, long hocphi, int soluongmon, String hinhanh, int loaikhoahocid) {
        KhoaHoc khoaHoc = new KhoaHoc();
        khoaHoc.setTenKhoaHoc(tenkhoahoc);
        khoaHoc.setThoiGianHoc(thoigianhoc);
        khoaHoc.setGioiThieu(gioithieu);
        khoaHoc.setNoiDung(noidung);
        khoaHoc.setHocPhi(hocphi);
        khoaHoc.setSoHocVien(0);
        khoaHoc.setSoLuongMon(soluongmon);
        khoaHoc.setHinhAnh(hinhanh);

        LoaiKhoaHoc loaiKhoaHoc = loaiKhoaHocService.findOne(loaikhoahocid);
        khoaHoc.setLoaiKhoaHoc(loaiKhoaHoc);

        ValidatorFactory valfac = Validation.buildDefaultValidatorFactory();
        Validator validator = valfac.getValidator();
        Set<ConstraintViolation<KhoaHoc>> violation = validator.validate(khoaHoc);
        violation.forEach(x -> System.out.println(x.getMessage()));
        if(violation.size() == 0) {
            khoaHocService.save(khoaHoc);
        }
        return "Added successfully!";
    }

    @GetMapping("/tim")
    public List<KhoaHoc> timKhoaHoc(@RequestParam String ten) {
        List<KhoaHoc> listKhoaHoc = new ArrayList<>();
        khoaHocService.findAll().stream().filter(x -> x.getTenKhoaHoc().equals(ten)).forEach(x -> listKhoaHoc.add(x));
        return listKhoaHoc;
    }
}

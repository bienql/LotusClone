package com.example.LotusClone.controller;

import com.example.LotusClone.model.BaiViet;
import com.example.LotusClone.model.ChuDe;
import com.example.LotusClone.model.HocVien;
import com.example.LotusClone.model.TaiKhoan;
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
@RequestMapping("/baiviet")
public class BaiVietController {
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
    public List<BaiViet> findAll() {
        return baiVietService.findAll();
    }

    @PutMapping("/sua")
    public void suaBaiViet(@RequestBody BaiViet baiViet) {
        baiVietService.save(baiViet);
    }

    @DeleteMapping("/xoa")
    public void xoaBaiViet(@RequestParam int id) {
        baiVietService.delete(baiVietService.findOne(id));
    }

    @PostMapping("/them")
    public String themBaiViet(@RequestParam String tenbaiviet, String tentacgia, String noidung, String hinhanh, int chudeid, int taikhoanid) {
        BaiViet baiViet = new BaiViet();
        baiViet.setTenBaiViet(tenbaiviet);
        baiViet.setTenTacGia(tentacgia);
        baiViet.setNoiDung(noidung);
        if(noidung.trim().length() > 19) {
            baiViet.setNoiDungNgan(noidung.trim().substring(0, 1000));
        }
        else baiViet.setNoiDungNgan(noidung.trim());
        baiViet.setHinhAnh(hinhanh);
        baiViet.setThoiGianTao(LocalDate.now());

        ChuDe chuDe = chuDeService.findOne(chudeid);
        baiViet.setChuDe(chuDe);

        TaiKhoan taiKhoan = taiKhoanService.findOne(taikhoanid);
        baiViet.setTaiKhoan(taiKhoan);

        ValidatorFactory valfac = Validation.buildDefaultValidatorFactory();
        Validator validator = valfac.getValidator();
        Set<ConstraintViolation<BaiViet>> violation = validator.validate(baiViet);
        violation.forEach(x -> System.out.println(x.getMessage()));
        if(violation.size() == 0) {
            baiVietService.save(baiViet);
        }
        return "Added successfully!";
    }
}

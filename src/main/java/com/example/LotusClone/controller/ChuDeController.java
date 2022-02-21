package com.example.LotusClone.controller;

import com.example.LotusClone.model.BaiViet;
import com.example.LotusClone.model.ChuDe;
import com.example.LotusClone.model.HocVien;
import com.example.LotusClone.model.LoaiBaiViet;
import com.example.LotusClone.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/chude")
public class ChuDeController {
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
    public List<ChuDe> findAll() {
        return chuDeService.findAll();
    }

//    @PutMapping("/sua")
//    public void suaBaiViet(@RequestBody ChuDe chuDe) {
//        chuDeService.save(chuDe);
//    }

    @PutMapping("/sua")
    public void suaChuDe(@RequestParam int id, String tenchude, String noidung, int loaibaivietid) {
        ChuDe chuDe = chuDeService.findOne(id);
        chuDe.setTenChuDe(tenchude);
        chuDe.setNoiDung(noidung);

        LoaiBaiViet loaiBaiViet = loaiBaiVietService.findOne(loaibaivietid);
        chuDe.setLoaiBaiViet(loaiBaiViet);

        ValidatorFactory valfac = Validation.buildDefaultValidatorFactory();
        Validator validator = valfac.getValidator();
        Set<ConstraintViolation<ChuDe>> violation = validator.validate(chuDe);
        violation.forEach(x -> System.out.println(x.getMessage()));
        if(violation.size() == 0) {
            chuDeService.save(chuDe);
        }
    }

    @DeleteMapping("/xoa")
    public void xoaBaiViet(@RequestParam int id) {
        chuDeService.delete(chuDeService.findOne(id));
    }

    @PostMapping("/them")
    public void themChuDe(@RequestParam String tenchude, String noidung, int loaibaivietid) {
        ChuDe chuDe = new ChuDe();
        chuDe.setTenChuDe(tenchude);
        chuDe.setNoiDung(noidung);

        LoaiBaiViet loaiBaiViet = loaiBaiVietService.findOne(loaibaivietid);
        chuDe.setLoaiBaiViet(loaiBaiViet);

        ValidatorFactory valfac = Validation.buildDefaultValidatorFactory();
        Validator validator = valfac.getValidator();
        Set<ConstraintViolation<ChuDe>> violation = validator.validate(chuDe);
        violation.forEach(x -> System.out.println(x.getMessage()));
        if(violation.size() == 0) {
            chuDeService.save(chuDe);
        }
    }
}

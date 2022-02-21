package com.example.LotusClone.controller;

import com.example.LotusClone.model.BaiViet;
import com.example.LotusClone.model.DangKyHoc;
import com.example.LotusClone.model.HocVien;
import com.example.LotusClone.model.KhoaHoc;
import com.example.LotusClone.service.*;
import org.apache.commons.lang3.text.WordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/hocvien")
public class HocVienController {
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
    public List<HocVien> findAll() {
        return hocVienService.findAll();
    }

    @PutMapping("/sua")
    public void suaHocVien(@RequestBody HocVien hocVien) {
        hocVienService.save(hocVien);
    }

    @DeleteMapping("/xoa")
    public void xoaHocVien(@RequestParam int id) {
        hocVienService.delete(hocVienService.findOne(id));
    }

    @PostMapping("/them")
    public String themHocVien(@RequestParam String hinhanh, String hoten, String ngaysinh, String sodienthoai, String email, String tinhthanh, String quanhuyen, String phuongxa, String sonha) {
        HocVien hocVien = new HocVien();
        hocVien.setHinhAnh(hinhanh);
        hocVien.setHoTen(WordUtils.capitalizeFully(hoten.trim()));
        LocalDate birthday = LocalDate.parse(ngaysinh);
        hocVien.setNgaySinh(birthday);
        if (!checkSoDienThoai(sodienthoai)) hocVien.setSoDienThoai(sodienthoai);
        else return "So dien thoai da duoc su dung!";
        if (!checkEmail(email)) hocVien.setEmail(email);
        else return "Email da duoc su dung!";
        hocVien.setTinhThanh(tinhthanh);
        hocVien.setPhuongXa(phuongxa);
        hocVien.setQuanHuyen(quanhuyen);
        hocVien.setSoNha(sonha);

        ValidatorFactory valfac = Validation.buildDefaultValidatorFactory();
        Validator validator = valfac.getValidator();
        Set<ConstraintViolation<HocVien>> violation = validator.validate(hocVien);
        violation.forEach(x -> System.out.println(x.getMessage()));
        if(violation.size() == 0) {
            hocVienService.save(hocVien);
        }
        else return "Da co loi xay ra!";
        return "Them hoc vien thanh cong!";
    }

    @GetMapping("/tim")
    public List<HocVien> timHocVien(@RequestParam String ten, String email) {
        List<HocVien> listHocVien = new ArrayList<>();
        hocVienService.findAll().stream().filter(x -> x.getHoTen().equals(ten) || x.getEmail().equals(email)).forEach(x -> listHocVien.add(x));
        return listHocVien;
    }

    public boolean checkEmail(String email) {
        return hocVienService.findAll().stream().anyMatch(x -> x.getEmail().equals(email));
    }

    public boolean checkSoDienThoai(String sodienthoai) {
        return hocVienService.findAll().stream().anyMatch(x -> x.getSoDienThoai().equals(sodienthoai));
    }
}

package com.example.LotusClone.controller;

import com.example.LotusClone.model.TaiKhoan;
import com.example.LotusClone.model.TinhTrangHoc;
import com.example.LotusClone.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/taikhoan")
public class TaiKhoanController {
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
    public List<TaiKhoan> findAll() {
        return taiKhoanService.findAll();
    }

    @PutMapping("/sua")
    public void suaTaiKhoan(@RequestBody TaiKhoan taiKhoan) {
        taiKhoanService.save(taiKhoan);
    }

    @DeleteMapping("/xoa")
    public void xoaTaiKhoan(@RequestParam int id) {
        taiKhoanService.delete(taiKhoanService.findOne(id));
    }

    @PostMapping("/them")
    public String themTaiKhoan(@RequestParam String username, String password, int quyenhanid) {
        TaiKhoan taiKhoan = new TaiKhoan();
        taiKhoan.setTenNguoiDung(username);
        if (validatePassword(password)) {
            taiKhoan.setMatKhau(password);
        }
        else {
            return "Toi thieu 8 ky tu, it nhat 1 chu cai, 1 chu so va 1 ky tu dac biet";
        }

        taiKhoan.setQuyenHan(quyenHanService.findOne(quyenhanid));
        if (!checkUsername(username)) {
            taiKhoanService.save(taiKhoan);
        }
        else return "Username da duoc su dung, xin hay chon username khac!";
        return "Them tai khoan thanh cong!";
    }

    public boolean checkUsername(String tennguoidung) {
        return taiKhoanService.findAll().stream().anyMatch(x -> x.getTenNguoiDung().equals(tennguoidung));
    }

    public boolean validatePassword(String password) {
        String regex = "^(?=.*[A-Za-z])(?=.*\\d)" +
                "(?=.*[@$!%*#?&])" +
                "[A-Za-z\\d@$!%*#?&]" +
                "{8,}$";
//        minimum 8 characters, at least 1 letter, 1 number and 1 special character
        Pattern p = Pattern.compile(regex);
        if (password == null) return false;
        Matcher m = p.matcher(password);
        return m.matches();
    }
}

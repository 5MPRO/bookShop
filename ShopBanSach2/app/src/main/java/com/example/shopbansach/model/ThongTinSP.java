package com.example.shopbansach.model;

public class ThongTinSP {
    public int ID;
    public String DanhMuc;
    public String TacGia;
    public String TenSach;
    public String NhaCungCap;
    public String CtyPhatHanh;
    public String NgayXB;
    public String HinhAnh;

    public ThongTinSP(int ID, String danhMuc, String tacGia, String tenSach, String nhaCungCap, String ctyPhatHanh, String ngayXB, String hinhAnh) {
        this.ID = ID;
        DanhMuc = danhMuc;
        TacGia = tacGia;
        TenSach = tenSach;
        NhaCungCap = nhaCungCap;
        CtyPhatHanh = ctyPhatHanh;
        NgayXB = ngayXB;
        HinhAnh = hinhAnh;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDanhMuc() {
        return DanhMuc;
    }

    public void setDanhMuc(String danhMuc) {
        DanhMuc = danhMuc;
    }

    public String getTacGia() {
        return TacGia;
    }

    public void setTacGia(String tacGia) {
        TacGia = tacGia;
    }

    public String getTenSach() {
        return TenSach;
    }

    public void setTenSach(String tenSach) {
        TenSach = tenSach;
    }

    public String getNhaCungCap() {
        return NhaCungCap;
    }

    public void setNhaCungCap(String nhaCungCap) {
        NhaCungCap = nhaCungCap;
    }

    public String getCtyPhatHanh() {
        return CtyPhatHanh;
    }

    public void setCtyPhatHanh(String ctyPhatHanh) {
        CtyPhatHanh = ctyPhatHanh;
    }

    public String getNgayXB() {
        return NgayXB;
    }

    public void setNgayXB(String ngayXB) {
        NgayXB = ngayXB;
    }

    public String getHinhAnh() {
        return HinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        HinhAnh = hinhAnh;
    }
}

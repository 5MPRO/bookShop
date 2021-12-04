package com.example.shopbansach.model;

public class diachi {
    private String tenDiaChi;
    private String diaChi;
    private String tenNguoiDung;
    private String soDienThoai;

    public diachi(String tenDiaChi, String diaChi, String tenNguoiDung, String soDienThoai) {
        this.tenDiaChi = tenDiaChi;
        this.diaChi = diaChi;
        this.tenNguoiDung = tenNguoiDung;
        this.soDienThoai = soDienThoai;
    }

    public String getTenDiaChi() {
        return tenDiaChi;
    }

    public void setTenDiaChi(String tenDiaChi) {
        this.tenDiaChi = tenDiaChi;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getTenNguoiDung() {
        return tenNguoiDung;
    }

    public void setTenNguoiDung(String tenNguoiDung) {
        this.tenNguoiDung = tenNguoiDung;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }
}

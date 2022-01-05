package com.example.shopbansach.model;

public class DonHang {
    private String MaDH;
    private String OrderName;
    private String Quantity;
    private String Status;
    private String Total;

    public DonHang(String maDH, String orderName, String quantity, String status, String total) {
        MaDH = maDH;
        OrderName = orderName;
        Quantity = quantity;
        Status = status;
        Total = total;
    }

    public String getMaDH() {
        return MaDH;
    }

    public void setMaDH(String maDH) {
        MaDH = maDH;
    }

    public String getOrderName() {
        return OrderName;
    }

    public void setOrderName(String orderName) {
        OrderName = orderName;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getTotal() {
        return Total;
    }

    public void setTotal(String total) {
        Total = total;
    }
}

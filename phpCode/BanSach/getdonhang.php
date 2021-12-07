<?php
    include "connect.php";
    $email = $_GET['email'];
    $query = "SELECT * FROM chitietdonhang, donhang where donhang.id = chitietdonhang.maDonHang and email = '$email' ";
    $data = mysqli_query($conn, $query);
    $mangdonhang = array();
    while ($row = mysqli_fetch_assoc($data)){

        array_push($mangdonhang,new DonHang(
                $row['tenSanPham'],
                $row['trangThai'],
                $row['soLuongSanPham']*$row['giaSanPham'],
                $row['soLuongSanPham']
            ));  
    }
    echo json_encode($mangdonhang);
    
    class DonHang{
        function __construct($tenSanPham,$trangThai,$tongtien,$soLuongSanPham) {
            $this->tenSanPham = $tenSanPham;
            $this->trangThai = $trangThai;
            $this->tongtien = $tongtien;
            $this->soLuongSanPham = $soLuongSanPham;
        }
    }
?>


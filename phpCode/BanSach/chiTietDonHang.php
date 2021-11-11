<?php
    include "connect.php";
    $json = $_POST['json'];
    $data = json_decode($json,true);
    foreach ($data as $value ){
        $madonhang = $value['maDonHang'];
        $masanpham = $value['maSanPham'];
        $tensanpham = $value['tenSanPham'];
        $giasanpham = $value['giaSanPham'];
        $soluongsanpham = $value['soLuongSanPham'];
        $query = "INSERT INTO chitietdonhang(id,maDonHang,maSanPham,tenSanPham,giaSanPham,soLuongSanPham)"
                . "VALUE(null,'$madonhang','$masanpham','$tensanpham','$giasanpham','$soluongsanpham')";
        $Dta = mysqli_query($conn, $query);
    }
    if($Dta){
        echo "1";
    }
    else {
        echo "0";
    }
?>
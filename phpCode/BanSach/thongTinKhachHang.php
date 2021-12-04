<?php
    include "connect.php";
    $tenkhachhang = $_POST['tenKhachHang'];
    $sodienthoai = $_POST['soDienThoai'];
    $email = $_POST['email'];
    $diaChi = $_POST['diaChi'];
    if(strlen($tenkhachhang)>0 && strlen($email) > 0 && strlen($diaChi) > 0 && strlen($sodienthoai) >0){
        $query = "INSERT INTO donhang(id,tenKhachHang,soDienThoai,email,diaChi) VALUES(null,'$tenkhachhang','$sodienthoai','$email','$diaChi')";
        if(mysqli_query($conn, $query)){
            $iddonhang = $conn->insert_id;
            echo $iddonhang;
        }
        else {
            echo "Thất bại";
        }
    } else {
        echo "Bạn hãy kiểm tra lại các dữ liệu";
}
?>
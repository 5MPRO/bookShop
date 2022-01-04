<?php
    include_once("connect.php");
    $maDonHang = $_POST['maDonHang'];
	$query = "UPDATE chitietdonhang SET trangThai='Đã hủy' where maDonHang = '$maDonHang'";
    if(mysqli_query($conn,$query)){
        echo "success";
    }
    else{
        echo "error";
    }
?>
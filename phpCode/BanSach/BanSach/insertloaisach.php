<?php
    include_once("connect.php");
    $image = $_POST["image"];
    $name = $_POST["name"];
    $images = "/BanSach/BanSach/uploads/$name.jpg";
    $sql = "INSERT into  loaisanpham(tenLoaiSanPham,hinhAnhLoaiSanPham) values('$name', '$images')"; 
    $upload_path = "uploads/$name.jpg";
    $result =mysqli_query($conn, $sql);
    if($result)
    {
        file_put_contents($upload_path,base64_decode($image));
        echo "success";
    }
    else echo "error";
?>
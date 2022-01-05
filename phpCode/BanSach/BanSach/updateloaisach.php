<?php
    include_once("connect.php");
    $id = $_POST['id'];
    $tenLoaiSanPham = $_POST['tenLoaiSanPham'];
    $hinhAnhLoaiSanPham = $_POST['hinhAnhLoaiSanPham'];
    $images = "/BanSach/BanSach/uploads/$tenLoaiSanPham.jpg";
    $querry = "UPDATE loaisanpham set tenLoaiSanPham ='$tenLoaiSanPham', 
                        hinhAnhLoaiSanPham ='$images'
                        where id = ".$id;
    $upload_path = "uploads/$tenLoaiSanPham.jpg";
    $result =mysqli_query($conn, $querry);
    if($result)
    {
        file_put_contents($upload_path,base64_decode($hinhAnhLoaiSanPham));
        echo "success";
    }
    else echo "error";
?>
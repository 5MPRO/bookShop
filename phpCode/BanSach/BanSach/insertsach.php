<?php
    include_once("connect.php");
    $idLoaiSach = $_POST["idLoaiSach"];
    $tenSach = $_POST["tenSach"];
    $gia = $_POST["gia"];
    $soLuong = $_POST["soLuong"];
    $moTa = $_POST["moTa"];
    $hinhAnh = $_POST["hinhAnh"];
    $images = "/BanSach/BanSach/uploads/$tenSach.jpg";
    $sql = " INSERT INTO `sanpham` (`id`, `tenSanPham`, `giaSanPham`, `hinhAnhSanPham`, `moTaSanPham`, `idSanPham`, `soLuong`)
                             VALUES (NULL, '$tenSach', ' $gia','$images', ' $moTa','$idLoaiSach', '$soLuong');";
                             
    $upload_path = "uploads/$tenSach.jpg";
    $result =mysqli_query($conn, $sql);
    if($result)
    {
        file_put_contents($upload_path,base64_decode($hinhAnh));    
        echo "success";
    }
    else echo "error";
?>
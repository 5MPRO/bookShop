<?php
    include_once("connect.php");
    $idLoaiSach = $_POST["idLoaiSach"];
    $tenSach = $_POST["tenSach"];
    $gia = $_POST["gia"];
    $soLuong = $_POST["soLuong"];
    $moTa = $_POST["moTa"];
    $hinhAnh = $_POST["hinhAnh"];
    $sql = " INSERT INTO `sanpham` (`id`, `tenSanPham`, `giaSanPham`, `hinhAnhSanPham`, `moTaSanPham`, `idSanPham`, `soLuong`)
                             VALUES (NULL, '$tenSach', ' $gia',          '$hinhAnh', ' $moTa','$idLoaiSach', '$soLuong');";
    $result =mysqli_query($conn, $sql);
    if($result)
    {    
        echo "success";
    }
    else echo "error";
?>
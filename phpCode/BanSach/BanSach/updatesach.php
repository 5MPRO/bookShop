<?php
    include_once("connect.php");
    $id = $_POST['id'];
    $tenSanPham = $_POST['tenSanPham'];
    $giaSanPham = $_POST['giaSanPham'];
    $hinhAnhSanPham = $_POST['hinhAnhSanPham'];
    $moTaSanPham = $_POST['moTaSanPham'];
    $idSanPham = $_POST['idSanPham'];
    $images = "/BanSach/BanSach/uploads/$tenSanPham.jpg";
    $querry = "UPDATE sanpham set tenSanPham ='$tenSanPham', 
                        giaSanPham ='$giaSanPham',
                        hinhAnhSanPham ='$images', 
                        moTaSanPham ='$moTaSanPham',
                        idSanPham ='$idSanPham'
                        where id = ".$id;
    $upload_path = "uploads/$tenSanPham.jpg";
    $result =mysqli_query($conn, $querry);
    if($result)
    {
        file_put_contents($upload_path,base64_decode($hinhAnhSanPham));    
        echo "success";
    }
    else echo "error";
?>
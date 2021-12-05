<?php
    include_once("connect.php");
    $tenDiaChi = $_POST['tenDiaChi'];
    $diaChi = $_POST['diaChi'];
    $soDienThoaiDc = $_POST['soDienThoaiDc'];
    $tenNguoiNhan = $_POST['tenNguoiNhan'];
    $email = $_POST['email'];
    $querry = "INSERT into  diachigiaohang  values('$tenDiaChi', '$diaChi', '$email', null,
                        '$soDienThoaiDc', '$tenNguoiNhan'  )";           
    $result =mysqli_query($conn, $querry);
    if($result)
    {
        echo "success";
    }
    else echo "error";
?>
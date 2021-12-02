<?php
    include_once("connect.php");
    $id = $_POST['id'];
    $name = $_POST['name'];
    $email = $_POST['email'];
   //$password = $_POST['password'];
    $soDienThoai = $_POST['soDienThoai'];
    $diaChi = $_POST['diaChi'];
    $ngaySinh  = $_POST['ngaySinh'];
    $querry = "UPDATE  users set name ='$name', email ='$email', 
                        soDienThoai ='$soDienThoai', 
                        diaChi ='$diaChi', 
                        ngaySinh = '$ngaySinh' 
                        where id = ".$id;

    $result =mysqli_query($conn, $querry);
    if($result)
    {
        echo "ok";
    }
?>
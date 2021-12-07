<?php
    include "connect.php";
    $idDiaChi = $_POST['idDiaChi'];
    $email = $_POST['email'];
    $mangdiachi = array();
    $query = "DELETE  FROM diachigiaohang WHERE idDiaChi = '$idDiaChi' and email = '$email'";
    if( mysqli_query($conn, $query)){
        echo "success";
    }
    else echo "error";
?>


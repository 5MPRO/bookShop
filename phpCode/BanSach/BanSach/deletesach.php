<?php
    include "connect.php";
    $idSP = $_POST['id'];
    $query = "DELETE FROM sanpham where id='$idSP'";
    
    if(mysqli_query($conn,$query)){
        echo "success";
    }   
    else{
        echo "error";
    }
?>
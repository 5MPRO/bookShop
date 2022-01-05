<?php
    include "connect.php";
    $idLSP = $_POST['id'];
    $query = "DELETE FROM loaisanpham where id='$idLSP'";
    
    if(mysqli_query($conn,$query)){
        echo "success";
    }   
    else{
        echo "error";
    }
?>
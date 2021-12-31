<?php
    $host="localhost";
    $username = "root";
    $password = "";
    $database = "bookshop";
    $url = "https://192.168.1.109";
    $conn = mysqli_connect($host,$username,$password,$database);
    mysqli_query($conn, "SET NAMES 'utf8'");
?>
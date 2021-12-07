<?php
     include "connect.php";
     $idUser = $_GET['email'];
    class user{
        function __construct($id, $name, $email, $password, $soDienThoai, $diaChi, $ngaySinh){
            $this->id = $id;
            $this->name = $name;
            $this ->email = $email;
            $this ->password = $password;
            $this ->soDienThoai = $soDienThoai;
            $this ->diaChi = $diaChi;
            $this ->ngaySinh = $ngaySinh;
        }
    }
    $userArray = array();
    $query = "SELECT * FROM users WHERE email = '$idUser'";
    $data = mysqli_query($conn, $query);
    while($row = mysqli_fetch_array($data)){
        array_push($userArray,new user(
            $row['id'],
            $row['name'],
            $row['email'],
            $row['password'],
            $row['soDienThoai'],
            $row['diaChi'],
            $row['ngaySinh']
          ));
}
    
    
    echo json_encode($userArray);
?>
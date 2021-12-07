<?php
    include "connect.php";
    $mangdiachi = array();
    $email = $_POST['email'];
    $query = "SELECT * FROM diachigiaohang as dc , users where dc.email = users.email and dc.email = '$email'";
  
    $data = mysqli_query($conn, $query);
    while ($row = mysqli_fetch_assoc($data)){
        array_push($mangdiachi,new DiaChi(
                $row['idDiaChi'],
                $row['email'],
                $row['diaChi'],
                $row['tenDiaChi'],
                $row['soDienThoaiDc'],
                $row['tenNguoiNhan']
                ));
    }
    echo json_encode($mangdiachi);
    
    class DiaChi{
        function __construct($idDiaChi,$email,$diaChi,$tenDiaChi,$soDienThoaiDc,$tenNguoiNhan) {
            $this->idDiaChi = $idDiaChi;
            $this->email = $email;
            $this->diaChi = $diaChi;
            $this->tenDiaChi = $tenDiaChi;  
            $this->soDienThoaiDc = $soDienThoaiDc;  
            $this->tenNguoiNhan = $tenNguoiNhan;  
        }
    }
?>


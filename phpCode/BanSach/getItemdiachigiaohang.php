<?php
    include "connect.php";
    $idDiaChi = $_GET['idDiaChi'];
    $email = $_POST['email'];
    $mangdiachi = array();
    $query = "SELECT * FROM diachigiaohang WHERE idDiaChi = '$idDiaChi' and email = '$email'";
    $data = mysqli_query($conn, $query);
    while ($row = mysqli_fetch_assoc($data)){
        array_push($mangdiachi,new DiaChi(
                $row['idDiaChi'],
                $row['email'],
                $row['diaChi'],
                $row['tenDiaChi'],
                $row['tenNguoiNhan'],
                $row['soDienThoaiDc']
                ));
    }
    echo json_encode($mangdiachi);
    
    class DiaChi{
        function __construct($idDiaChi,$email,$diaChi,$tenDiaChi,$soDienThoaiDc, $tenNguoiNhan) {
            $this->idDiaChi = $idDiaChi;
            $this->email = $email;
            $this->diaChi = $diaChi;
            $this->tenDiaChi = $tenDiaChi;  
            $this->soDienThoaiDc = $soDienThoaiDc;  
            $this->tenNguoiNhan = $tenNguoiNhan;  
        }
    }
?>


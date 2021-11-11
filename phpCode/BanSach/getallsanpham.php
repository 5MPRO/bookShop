<?php
    include "connect.php";
    $mangsanpham = array();
    $query = 'SELECT * FROM sanpham';
    $data = mysqli_query($conn, $query);
    while ($row = mysqli_fetch_assoc($data)){
        array_push($mangsanpham,new SanPham(
                $row['id'],
                $row['tenSanPham'],
                $row['giaSanPham'],
                $row['hinhAnhSanPham'],
                $row['moTaSanPham'],
                $row['idSanPham']));
    }
    echo json_encode($mangsanpham);
    
    class SanPham{
        function __construct($id,$tensp,$giasp,$hinhanhsp,$motasp,$idsanpham) {
            $this->id = $id;
            $this->tensp = $tensp;
            $this->giasp = $giasp;
            $this->hinhanhsp = $hinhanhsp;
            $this->motasp = $motasp;
            $this->idsanpham = $idsanpham;
        }
    }
?>


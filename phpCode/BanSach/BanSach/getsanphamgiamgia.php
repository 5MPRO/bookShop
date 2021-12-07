<?php
    include "connect.php";
    $query = "SELECT * FROM sanpham LIMIT 6";
    $data = mysqli_query($conn, $query);
    $mangsp = array();
    while($row = mysqli_fetch_assoc($data)){
        array_push($mangsp, new Sanphamgiamgia(
            $row['id'],
            $row['tenSanPham'],
            $row['giaSanPham'],
            $row['hinhAnhSanPham'],
            $row['moTaSanPham'],
            $row['idSanPham']));
    }
    echo json_encode($mangsp);
    class Sanphamgiamgia{
        function __construct ($id,$tensp,$giasp,$hinhanhsp,$motasp,$idsanpham){
            $this->id=$id;
             $this->tensp=$tensp;
             $this->giasp=$giasp;
             $this->hinhanhsp=$hinhanhsp;
             $this->motasp=$motasp;
             $this->idsanpham=$idsanpham;
        }
    }
?>

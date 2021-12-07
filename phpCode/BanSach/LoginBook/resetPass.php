<?php
    if(isset($_POST['email'])&&isset($_POST['NewPass'])){
        require_once "conn.php";
        require_once "validate.php";
        $id = validate($_POST['email']);
        $passNew = validate($_POST['NewPass']);
        $passOld = validate($_POST['OldPass']);
        $sql = "select password from users where email='$id' and password='$passOld'";
	    $result = mysqli_query($connect,$sql);
        if($result->num_rows > 0){
            $sql = "UPDATE  users set users.password = $passNew where email = '$id'";
            $result = mysqli_query($connect,$sql);
            echo "success" ;
        } else {
            echo "failure";
        }
    }
?>
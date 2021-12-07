<?php
    if(isset($_POST['email'])&&isset($_POST['password'])){
        require_once "conn.php";
        require_once "validate.php";
        $email = validate($_POST['email']);
        $password = validate($_POST['password']);
        $sql = "select * from users where email='$email' and password='$password'";
	$result = mysqli_query($connect,$sql);
        if($result->num_rows > 0){
            echo "success" ;
        } else {
            echo "failure";
        }
    }
?>

<?php
    if(isset($_POST['name'])&&isset($_POST['email'])&&isset($_POST['password'])){
        require_once "conn.php";
        require_once "validate.php";
        $name =  validate($_POST['name']);
        $email = validate($_POST['email']);
        $password = validate($_POST['password']);
        $sql = "insert into users(id,name,email,password) values('', '$name', '$email', '$password')";
        if(!$result = mysqli_query($connect,$sql)){
            echo "failure";
        }else {
            echo "success";
        }
    }
?>

<?php 

    $con=mysqli_connect("localhost","id17346616_mohamad","Amir671995*#","id17346616_orderdata");
    
    $username=$_POST["username"];
    $password=$_POST["password"];
    
    $sql = "SELECT * FROM User WHERE username='$username' AND password='$password'";
    $result = mysqli_query($con,$sql);
    
    if($result->num_rows>0){
        echo"logged in successfully";
    }
        else{
              echo"user not found";
        }
    
    ?>
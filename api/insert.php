<?php

    $connection = mysqli_connect("localhost","id17346616_mohamad","Amir671995*#","id17346616_orderdata");
    
     $client = $_POST["client"];
     $item = $_POST["item"];
     $price = $_POST["price"];
     $quantity = $_POST["quantity"];
     $date = $_POST["date"];
     
     $sql = "INSERT INTO order(client,item,price,quantity,date) VALUES ('$client','$item','$price','$quantity','$date')";
     
     $result = mysqli_query($connection,$sql);
     
     if($result){
         echo "Data Inserted";
        
     }
     else{
         echo "Failed";
     }
     mysqli_close($connection);
     
          
 ?>
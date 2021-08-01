<?php
    $con=mysqli_connect("localhost","id17346616_mohamad","Amir671995*#","id17346616_orderdata");
    
     $oderId = $_POST["orderId"];
     $client = $_POST["client"];
     $item = $_POST["item"];
     $price = $_POST["price"];
     $quantity = $_POST["quantity"];
     $date = $_POST["date"];
     
     $sql = "UPDATE order SET  client = '$client', item = '$item', price = '$price', quantity = '$quantity'  date = '$date'  WHERE orderId = '$orderId' ";
     
     $result = mysqli_query($connection,$sql);
     
     if($result){
         echo "Data Updated";
        
     }
     else{
         echo "Failed";
     }
     mysqli_close($connection);
     
        
?>
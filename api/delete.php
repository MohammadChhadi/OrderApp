  
<?php

  $connection = mysqli_connect("localhost","id17346616_mohamad","Amir671995*#","id17346616_orderdata");
    
     $orderId = $_POST["orderId"];
     
     $sql = "DELETE FROM order WHERE orderId='$orderId'";
     
     $result = mysqli_query($connection,$sql);
     
     if($result){
         echo "Data Deleted";
        
     }
     else{
         echo "Failed";
     }
     mysqli_close($connection);
     


?>
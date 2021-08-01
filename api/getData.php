  
<?php 

    $connection = mysqli_connect("localhost","id17346616_mohamad","Amir671995*#","id17346616_orderdata");
	$result = array();
	$result['order'] = array();
	$select= "SELECT *from order";
	$responce = mysqli_query($connection,$select);
	
	while($row = mysqli_fetch_array($responce))
		{
			$index['orderID']      = $row['0'];
			$index['client']    = $row['1'];
			$index['item']   = $row['2'];
			$index['price'] = $row['3'];
			$index['quantity'] = $row['4'];
		    $index['date'] = $row['5'];
			
			array_push($result['order'], $index);
		}
			
			$result["success"]="1";
			echo json_encode($result);
			mysqli_close($connection);

 ?>
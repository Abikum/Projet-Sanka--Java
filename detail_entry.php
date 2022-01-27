<?php
	$servername="localhost";
	$username="root";
	$password="";
	$database_name="databaseupaul";

	$conn=mysqli_connect($servername,$username,$password,$database_name);
	if (!$conn) {
		die("connection failed" . mysqli_connect_error());
	}
	if(isset($_POST['save']))
	{
		$first_neme=$_POST['first_name'];
		$last_neme=$_POST['first_name'];
		$gender=$_POST['gender'];
		$email=$_POST['email'];
		$phone=$_POST['phone'];

		$sql_query = "INSERT INTO entry_details(first_name,last_name,gender,email,mobile)
		VALUES('$first_name','$last_name','$gender','$email','$phone')";

		if(mysqli_query($conn,$sql_query))
			{
				echo("new details updated");
			}
		else {
			echo"Error:" .$sql. "". mysqli_error($conn);
		}
		mysqli_close($conn);
	}
?>
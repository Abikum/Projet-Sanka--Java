<?php
	$servername="localhost";
	$username="root";
	$password="";
	$database_name="connected";

	$conn=mysqli_connect($servername,$username,$password,$database_name);
	if (!$conn) {
		die("Account creation failed. Try angain." . mysqli_connect_error());
	}
	if(isset($_POST['save']))
	{
		$first_neme=$_POST['first_name'];
		$second_neme=$_POST['second_name'];
		$phone=$_POST['phone'];
		$email=$_POST['email'];
		$gender=$_POST['gender'];
		$password=$_POST['password'];
		
		$sql_query = "INSERT INTO entry_details(first_name,second_name,mobile,email,gender,password)
		VALUES('$first_name','$second_name','$phone','$email','$gender','$password')";

		if(mysqli_query($conn,$sql_query))
			{
				echo("Account successfully created.");
			}
		else {
			echo"Error:" .$sql. "". mysqli_error($conn);
		}
		mysqli_close($conn);
	}
?>
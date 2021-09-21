<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Upload File</title>
</head>
<body>
<form action="uploadfile.controller" method="post" enctype="multipart/form-data">
	<p>
		Please Select Your Photo to Upload:</br>
		<input type="file" name="myFiles"/>
	</p>
	<input type="submit" value="upload"/>
</form>
</body>
</html>
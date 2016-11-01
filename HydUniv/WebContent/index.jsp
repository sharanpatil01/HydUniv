<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>/HydUniv</title>
</head>
<body bgcolor="yellow">
Hi<br>
This is index.jsp page for "/HydUniv" proj.
<br><br>

i) http://localhost:8080/HydUniv/student/DB/create/{studId}/{fn}/{ln} <br>
ii)http://localhost:8080/HydUniv/student/DB/update/{studId}/{fn}/{ln} <br>
iii)http://localhost:8080/HydUniv/student/DB/delete/{studId} <br>

iv) <a href="student/list"> 
	http://localhost:9080/HydUniv/student/list  </a> <br>
	
	
v)<a href="student/DB/list">
http://localhost:9080/HydUniv/student/DB/list</a>  <br>

vi) http://localhost:8080/HydUniv/student/find/{studId} <br>
vii) http://localhost:8080/HydUniv/student/getdetails/{studId} <br><br><br>

ix)http://localhost:8080/HydUniv/student/geturl<br>
x) http://localhost:8080/HydUniv/student/seturl?url=http://host:port/GOIEducationDept<br>
xi) get input first webservice base url endpoint<br>
	set that into context.<br>  Set  this only one time.
	
	
</body>
</html>
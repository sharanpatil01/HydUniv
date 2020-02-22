# Univ Project




Two Application(Webservice based)
1) Govt Education Dept exposes student past records (courses passed etc)
i) http://localhost:8080/GOIEductionDept/students/verify/{studId}/courses
		- return list of courses passed by student, identified by universion stud id.

2) Univ has student application, which while enrolling gets more info from govt edu appliction


WS's
i) http://localhost:8080/HydUniv/student/create/{studId}/{fn}/{ln}
ii)http://localhost:8080/HydUniv/student/update/{studId}/{fn}/{ln}
iii)http://localhost:8080/HydUniv/student/delete/{studId}
iv)http://localhost:8080/HydUniv/student/list
v) http://localhost:8080/HydUniv/student/find/{studId}
vi) http://localhost:8080/HydUniv/student/getdetails/{studId}




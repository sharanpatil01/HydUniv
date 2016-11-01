package com.indg.univ.stud;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.indg.univ.stud.dao.StudentDAO;

@Component
public class StudentDBUtil {

	private static Map<String, Student> studentsMap = new HashMap<String, Student>();

	@Autowired
	private StudentDAO studentDAO;

	public StudentDBUtil() {
	}

	public Collection<Student> getStudents() {
		studentsMap.clear();
		List<Student> studlist = getStudentDAO().findAllStudent();
		for (Student stud : studlist) {
			System.out.println(stud);
			studentsMap.put(stud.getStId(), stud);
		}
		return studentsMap.values();
	}

	public Student getStudent(String studId) {
		Student stud = getStudentDAO().findById(studId);
		if (stud == null)
			stud = new Student("00", "undefined", "undefined");
		return stud;
	}

	public String removeStudent(String id) {
		getStudentDAO().removeStudentById(id);
		return "removed";
	}

	public Student updateStudent(String id, String fn, String ln) {
		Student stud = new Student(id, fn, ln);
		getStudentDAO().insert(stud);
		return stud;
	}

	public Student createStudent(String id, String fn, String ln) {
		Student stud = new Student(id, fn, ln);
		getStudentDAO().insert(stud);
		return stud;
	}

	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

}

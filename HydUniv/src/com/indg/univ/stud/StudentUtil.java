package com.indg.univ.stud;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class StudentUtil {

	private static Map<String, Student> studentsMap = new HashMap<String, Student>();

	public StudentUtil() {
		Student stud1 = new Student.StudentBuilder("10", "Ajay").lastname("Verma").build();
		Student stud2 = new Student.StudentBuilder("20", "Vijay").lastname("Verma").build();
		Student stud3 = new Student.StudentBuilder("30", "Manoj").build();
		Student stud4 = new Student.StudentBuilder("40", "Prem").build();
		Student stud5 = new Student.StudentBuilder("50", "Suman").build();

		studentsMap.put("10", stud1);
		studentsMap.put("20", stud2);
		studentsMap.put("30", stud3);
		studentsMap.put("40", stud4);
		studentsMap.put("50", stud5);
	}

	public Collection<Student> getStudents() {
		return studentsMap.values();
	}

	public Student getStudent(String studId) {
		Student stud = studentsMap.get(studId);
		if (stud == null)
			stud = new Student("00", "undefined", "undefined");

		return stud;
	}

	public Student removeStudent(String id) {
		Student stud = studentsMap.get(id);
		studentsMap.remove(id);
		return stud;
	}

	public Student updateStudent(String id, String fn, String ln) {
		Student stud = new Student(id, fn, ln);
		studentsMap.put(id, stud);
		return stud;
	}

	public Student createStudent(String id, String fn, String ln) {
		Student stud = new Student(id, fn, ln);
		studentsMap.put(id, stud);
		return stud;
	}

	public Courses getCourses(int sno) {
		Courses courses;

		switch (sno) {
		case 1:
			courses = new Courses.CourseBuilder("PUC").board("TSEB")
					.subjects("Telugu,English,Physics, Chemistry,Maths")
					.build();
			break;
		case 2:
			courses = new Courses.CourseBuilder("BSc").board("JNTU")
					.subjects("Telugu,English, Databases, Applications, MIS")
					.build();
			break;
		case 3:
			courses = new Courses.CourseBuilder("MSc").board("JNTU")
					.subjects("Languages, Databases, Cloud Computing").build();
			break;
		case 4:
			courses = new Courses.CourseBuilder("MCA")
					.board("Bangalore University")
					.subjects("Languages, Databases, Cloud").build();
			break;
		case 5:
			courses = new Courses.CourseBuilder("BCom")
					.board("Bangalore University").subjects("Legdering, Laws")
					.build();
			break;
		case 6:
			courses = new Courses.CourseBuilder("MCom")
					.board("Osmania University")
					.subjects("Legder, Business Model, Company laws").build();
			break;
		case 7:
			courses = new Courses.CourseBuilder("MPhil")
					.board("Osmania University")
					.subjects("Philosophy, Social Science").build();
			break;
		case 8:
			courses = new Courses.CourseBuilder("BTech").board("JNTU")
					.subjects("Data Structure,DB,Java, SE").build();
			break;
		case 9:
			courses = new Courses.CourseBuilder("MTech").board("JNTU")
					.subjects("SE, Hardware, Languages, AI").build();

			break;

		default:
			courses = new Courses.CourseBuilder("SSC").board("TSEB")
					.subjects("Telugu,English,Hindi,Maths,Science,Social")
					.build();
			break;
		}

		return courses;
	}

}

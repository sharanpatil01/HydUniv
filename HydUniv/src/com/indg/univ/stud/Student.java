package com.indg.univ.stud;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Student implements Serializable{

	private static final long serialVersionUID = -3107337924487723768L;

	private String stId = "100";
	private String firstName = "Sharan";
	private String lastName = "Patil";
	private List<Courses> coursesCompleted;
	private String citizenship = "Indian";
	
	public String getStId() {
		return stId;
	}

	public void setStId(String stId) {
		this.stId = stId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Courses> getCoursesCompleted() {
		return coursesCompleted;
	}

	public void setCoursesCompleted(List<Courses> coursesCompleted) {
		this.coursesCompleted = coursesCompleted;
	}

	public String getCitizenship() {
		return citizenship;
	}

	public void setCitizenship(String citizenship) {
		this.citizenship = citizenship;
	}

	public Student() {
	}

	public Student(String iid, String fn, String ln) {
		this.stId = iid;
		this.firstName = fn;
		this.lastName = ln;
	}

	public Student(String iid, String fn) {
		this.stId = iid;
		this.firstName = fn;
	}
	
	public Student(StudentBuilder StudentBuilder) {
		this.stId = StudentBuilder.stId;
		this.firstName = StudentBuilder.firstName;
		this.lastName = StudentBuilder.lastName;
		this.coursesCompleted = StudentBuilder.coursesCompleted;
	}


	public static class StudentBuilder {
		private final String stId;
		private final String firstName;
		private String lastName = "Patil";
		private List<Courses> coursesCompleted;

		public StudentBuilder(String studid, String fname){
			this.stId = studid;
			this.firstName = fname;
		}
		
		public StudentBuilder lastname(String ln){
			this.lastName = ln;
			return this;
		}
		
		public StudentBuilder courses(Courses course){
			if (this.coursesCompleted == null){
				this.coursesCompleted = new ArrayList<Courses>();
			}
			this.coursesCompleted.add(course);
			return this;
		}
		
		public StudentBuilder listSubjects(){
			List<Courses> crslist = new ArrayList<Courses>();
			List<String> sublist = new ArrayList<String>();
			
			for (Courses course : crslist) {

				String[] subjects = course.getSubjects().split(",");
				for (String subject : subjects) {
					System.out.println(subject);
					sublist.add(subject);
				}
			}
			 			
			return this;
			
		}
	
		public Student build(){
			return new Student(this);
		}
	}
}

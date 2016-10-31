package com.indg.univ.stud;

import java.io.Serializable;

public class Courses implements Serializable {

	private static final long serialVersionUID = 287761629659710996L;

	private String courseName;
	private String boardName;
	private String subjects;

	// SSC, boardName, subjects

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getBoardName() {
		return boardName;
	}

	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}

	public String getSubjects() {
		return subjects;
	}

	public void setSubjects(String subjects) {
		this.subjects = subjects;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	//constructor
	public Courses() { 
	}
	
	public Courses(CourseBuilder courseBuilder) {
		this.courseName = courseBuilder.courseName;
		this.boardName = courseBuilder.board;
		this.subjects = courseBuilder.subjects;
	}

	
	
	public static class CourseBuilder {
		private final String courseName;
		private String board;
		private String subjects;

		public CourseBuilder(String courseName) {
			this.courseName = courseName;
		}

		public CourseBuilder board(String board) {
			this.board = board;
			return this;
		}

		public CourseBuilder subjects(String subjects) {
			this.subjects = subjects;
			return this;
		}

		public Courses build() {
			return new Courses(this);
		}

	}

}

package com.indg.univ.stud.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.indg.univ.stud.Student;
import com.indg.univ.stud.dao.StudentDAO;

@Component
public class JdbcStudentDAO implements StudentDAO
{
	@Autowired
	private DataSource dataSource;


	public void insert(Student student){

		String sql = "INSERT INTO STUDENT (id, firstname, lastname, citizenship)values (?, ?, ?, ?)";
		Connection conn = null;

		try {
			conn = getDataSource().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, student.getStId());
			ps.setString(2, student.getFirstName());
			ps.setString(3, student.getLastName());
			ps.setString(4, student.getCitizenship());
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}

	
	
	
	public Student findById(String id){

		String sql = "SELECT * FROM STUDENT WHERE ID = ?";

		Connection conn = null;

		try {
			conn = getDataSource().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			Student Student = null;
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				Student = new Student(
					rs.getString("ID"),
					rs.getString("FIRSTNAME"),
					rs.getString("LASTNAME")
				);
			}
			rs.close();
			ps.close();
			return Student;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}
	}
	
	
	
	public List<Student> findAllStudent(){
		List<Student> studList = new ArrayList<Student>();
		String sql = "SELECT * FROM STUDENT";

		Connection conn = null;

		try {
			conn = getDataSource().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			Student stud = null;
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				stud = new Student(
					rs.getString("ID"),
					rs.getString("FIRSTNAME"),
					rs.getString("LASTNAME")
				);
				studList.add(stud);
			}
			rs.close();
			ps.close();
			return studList;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}
	}
	
	public void removeStudentById(String stid){
		String sql = "DELETE FROM STUDENT WHERE ID = ?";

		Connection conn = null;

		try {
			conn = getDataSource().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, stid);
			ps.executeQuery();
			ps.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}
	}




	public DataSource getDataSource() {
		return dataSource;
	}




	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

}
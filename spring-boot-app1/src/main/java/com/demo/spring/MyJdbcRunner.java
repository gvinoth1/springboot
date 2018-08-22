package com.demo.spring;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import ch.qos.logback.core.net.SyslogOutputStream;

@Component
public class MyJdbcRunner implements CommandLineRunner {

	@Autowired
	JdbcTemplate jt;

	@Override
	public void run(String... args) throws Exception {

		//String INSERT_EMP = "insert into EMP(empno, name, address,salary) values (?,?,?,?)";
		/*int count = jt.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pst = con.prepareStatement(INSERT_EMP);
				pst.setInt(1, 455);
				pst.setString(2, "Mohan");
				pst.setString(3, "Hyderabad");
				pst.setDouble(4, 78000);
				return pst;
			}
		});*/
		
		
		List<Emp> empList = jt.query("select * from emp", new RowMapper() {

			@Override
			public Emp mapRow(ResultSet rs, int rowNum) throws SQLException{
				return new Emp(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4));
			}
			
		});
		
		empList.stream().forEach(s -> System.out.println(s));

		/*Emp e = jt.queryForObject("", new RowMapper<Emp>{
			
		});
		*/
		/*jt.query("", new RowMapper() {
			
			@Override
			public Emp mapRow(ResultSet rs, int rowNum) throws SQLException{
				return new Emp(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4));
			}
			
		});*/

	}
	
	

}

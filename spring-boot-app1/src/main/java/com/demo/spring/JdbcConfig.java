package com.demo.spring;




import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class JdbcConfig {
	
	
	@Qualifier("myds")
	DataSource ds2;
	
	
	
	public JdbcTemplate jt() {
		JdbcTemplate jt = new JdbcTemplate();		
		jt.setDataSource(ds2);
		return jt;
	}
}

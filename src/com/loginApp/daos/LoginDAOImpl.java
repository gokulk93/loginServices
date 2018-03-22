package com.loginApp.daos;

import com.loginApp.beans.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDAOImpl implements LoginDAO {
	@Autowired
	JdbcTemplate jdbcTemplate;
	String sqlInsertQuery = "INSERT INTO users (user_id, user_name, access,password) VALUES (?, ?, ?, ?)";
	
	public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
	
	@Override
	public boolean validateUsers(User user){
		
		String sql = "select password from users where user_name = ?";
        String password = jdbcTemplate.queryForObject(sql,new Object[]{user.getName()},String.class);
		if(!password.equals(null) && user.getPassword().equals(password))
			return true;
		else
			return false;
	}
}

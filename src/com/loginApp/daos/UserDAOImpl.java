package com.loginApp.daos;

import com.loginApp.beans.User;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {
	@Autowired
	JdbcTemplate jdbcTemplate;
	private final String addUser = "INSERT INTO users (user_id, user_name, access,password) VALUES (?, ?, ?, ?)";
	private final String validateUser = "select count(*) from users where user_name = ? and password = ?";
	
	public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
	
	@Override
	public int validateUsers(User user){
		
        String result= jdbcTemplate.queryForObject(validateUser,new Object[]{user.getUserName(),user.getPassword()},String.class);

        return Integer.parseInt(result);
	}

	@Override
	public int addUser(User user) throws DataAccessException{
		try {
			System.out.println("DAO");
			int result= jdbcTemplate.update(addUser,new Object[]{user.getUserId(),
					user.getUserName(),
					User.getAccess(), 
					user.getPassword()});
	        return result;
		}catch(DataAccessException e) {
			System.out.println(e.toString());
			throw e;
		}
		
	}
}

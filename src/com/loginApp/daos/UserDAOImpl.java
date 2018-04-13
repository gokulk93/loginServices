package com.loginApp.daos;

import com.loginApp.beans.User;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	User user;
	private final String addUser = "INSERT INTO users (user_id, user_name, access,password) VALUES (?, ?, ?, ?)";
	private final String validateUser = "select count(*) from users where user_name = ? and BINARY password = ?";
	private final String getUser = "select * from users where user_id = ?";
	
	public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
	
	@Override
	public boolean validateUsers(User user){
		
        String result= jdbcTemplate.queryForObject(validateUser,new Object[]{user.getUserName(),user.getPassword()},String.class); 
        boolean booleanValue=Integer.parseInt(result)==1;
        return booleanValue;
	}

	@Override
	public int addUser(User user) throws DataAccessException{
		try {
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

	@Override
	public User getUserById(int userId) {
		try {
			return jdbcTemplate.queryForObject(getUser,new Object[]{userId},new RowMapper<User>(){  
		        public User mapRow(ResultSet rs, int row) throws SQLException {  
		        	user.setUserId(rs.getInt(1));  
		            user.setUserName(rs.getString(2));
		            return user;  
		        }
			});
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
		
	}
}

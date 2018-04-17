package com.loginApp.daos;

import com.loginApp.beans.User;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {
	private static final Logger LOGGER = LogManager.getLogger(UserDAOImpl.class.getName());
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	User users;
	
	private final String addUser = "INSERT INTO users (user_id, user_name, access,password) VALUES (?, ?, ?, ?)";
	private final String userLogin = "select count(*) from users where user_id = ? and BINARY password = ?";
	private final String validateUser = "select count(*) from users where user_id = ?";
	private final String getUser = "select * from users where user_id = ?";
	
	public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
	
	@Override
	public boolean checkLogin(User user){
	    LOGGER.info("Validating user");
        String result= jdbcTemplate.queryForObject(userLogin,new Object[]{user.getUserId(),user.getPassword()},String.class);
        boolean booleanValue=Integer.parseInt(result)==1;
        System.out.println(booleanValue);
        return booleanValue;
	}

	@Override
	public int addUser(User newUser) throws DataAccessException{
	    LOGGER.info("Adding Users");
		try {
			if(!validateUser(newUser.getUserId())) {
				System.out.println(newUser.toString());
				int result= jdbcTemplate.update(addUser,new Object[]{newUser.getUserId(),
						newUser.getUserName(),
						User.getAccess(), 
						newUser.getPassword()});
		        return result;
			}else {
				return -1;
			}
		}catch(DataAccessException e) {
			LOGGER.error("Error Message Logged !!!"+e);
			throw e;
		}
	}

	@Override
	public User getUserById(int userId) {
	    LOGGER.info("Getting user name");
		try {
			return jdbcTemplate.queryForObject(getUser,new Object[]{userId},new RowMapper<User>(){  
		        public User mapRow(ResultSet rs, int row) throws SQLException {  
		        	users.setUserId(rs.getInt(1));  
		            users.setUserName(rs.getString(2));
		            return users;  
		        }
			});
		}catch(EmptyResultDataAccessException e) {
			LOGGER.error("Error while getting user name!!! "+e);
			return null;
		}
		
	}

	@Override
	public boolean validateUser(int userId) {
		boolean available = false;

		int count = getJdbcTemplate().queryForObject(validateUser, new Object[] { userId }, Integer.class);
				
		if (count > 0) {
			available = true;
		}

		return available;
	}
}

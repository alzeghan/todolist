package com.todo.persistance.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.todo.persistance.dao.UserDao;
import com.todo.persistance.model.Users;


@Repository
public class UserDaoImpl extends AbstractGenericDaoImpl<Users, Integer> implements UserDao {

	private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

	public List<Users> getUserById(int userId) {
		return null;

	}

	public Users getUserById(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	@Override
	public boolean isValidUser(String username, String password) throws SQLException
	{
		try {
			Criteria criteria = getSession().createCriteria(Users.class);
			criteria.add(Restrictions.eq("username", username));
			criteria.add(Restrictions.eq("password", password));

			Users user = (Users) criteria.uniqueResult();
			return (user != null);

		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error(ex.getMessage());
		}
		
		return false;
	}
	@Override
	public Users getUserByUsernamePassword(String username, String password){
		try {
			Criteria criteria = getSession().createCriteria(Users.class);
			criteria.add(Restrictions.eq("username", username));
			criteria.add(Restrictions.eq("password", password));

			Users user = (Users) criteria.uniqueResult();
			return user;

		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error(ex.getMessage());
		}
		
		return null;
	}
	
	@Override
	public Users getUserByUsername(String username){
		try {
			Criteria criteria = getSession().createCriteria(Users.class);
			criteria.add(Restrictions.eq("username", username));
			
			Users user = (Users) criteria.setMaxResults(1).uniqueResult();
			return user;

		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error(ex.getMessage());
		}
		
		return null;
	}
}

package com.todo.persistance.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
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
		try {
//			Criteria criteria = getSession().createCriteria(HubRoute.class);
//			criteria.createAlias("hubFrom", "hubFrom");
//			criteria.createAlias("hubFrom.country", "country");
//			criteria.add(Restrictions.eq("country.code", countryCode));
//			@SuppressWarnings("unchecked")
//			List<HubRoute> list = criteria.list();
//
//			return list;

		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
		return null;

	}

	public Users getUserById(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

}

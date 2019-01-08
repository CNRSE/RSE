package com.lovo.springMVC.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.lovo.springMVC.db.HibernateSession;

@Repository(value="userDao")
public class UserDaoImpl {

	Session session = HibernateSession.getSession();
	public void addUser(String username,String password) {
		//获取事务
		Transaction tr = session.getTransaction();
		//开启事务
		tr.begin();
		String sql = "insert into zc_user(username, password)value (?,?)";
		session.createSQLQuery(sql).setParameter(0, username).setParameter(1, password);
		//提交事务
		tr.commit();
	}
}

package com.lovo.springMVC.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;



@Repository
public class BasicDao<T> {
	protected Class<T> entityClass;
    String className="";
	/**
	 * 获得泛型的类型
	 */
	public BasicDao() {
		entityClass = ReflectUtils.getClassGenricType(getClass());
		className=entityClass.getSimpleName();//获得类的名字
	}
    //注入工厂
	@Autowired
	private LocalSessionFactoryBean sessionFactory;
	
	protected Session getCurrentSession(){
	return	sessionFactory.getObject().getCurrentSession();
	}
	
	protected Session getOpenSession(){
		return	sessionFactory.getObject().openSession();
	}
	/**
	 * 保存
	 * @param t
	 * @return
	 */
	public void savaObject(T t){
	
    getCurrentSession().save(t);
	 
	}
	/**
	 * get查询对象
	 * @param id
	 * @return
	 */
	public T getObjectByUserName(String id){
		return getCurrentSession().get(entityClass, id);
	}
	/**
	 * load查询对象
	 * @param id
	 * @return
	 */
	public T loadObjectById(String id){
		return getCurrentSession().load(entityClass, id);
	}
	/**
	 * 查询所有
	 * @return
	 */
	public List<T> findHQLList(){
		
		String hql="from "+className;
		return getCurrentSession().createQuery(hql).list();
	}
	/**
	 * 根据条件查询
	 * @param hql
	 * @param objs
	 * @return
	 */
  public List<T> findHQLList(String hql,Object[] objs){
	 
	  Query query= getCurrentSession().createQuery(hql);
		//判断数组是否为空，如果为空就不组装
		if(null!=objs&&objs.length>0){
			for(int i=0;i<objs.length;i++){
				query.setParameter(i,objs[i]);
			}
		}
		
		return query.list();
	}
  /**
   * 根据ID删除
   * @param id
   */
  public void  delObject(String id){
	getCurrentSession().delete(getCurrentSession().load(entityClass, id));  
  }
  
  public void updateObject(T t){
	  getCurrentSession().update(t);
	  
  }
  
  
}

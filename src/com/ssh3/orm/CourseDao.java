package com.ssh3.orm;


import java.io.Serializable;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ssh.orm.Course;


public class CourseDao extends HibernateDaoSupport {
	
	/**查询*/
	@SuppressWarnings("unchecked")
	public List<Course> getObjects(String queryString) throws Exception{
		return (List<Course>)this.getHibernateTemplate().find(queryString);
	}
	
	@SuppressWarnings("unchecked")
	public List<Course> getCourses()
	{ 
		String queryString = "SELECT u FROM Course u";
		return (List<Course>)this.getHibernateTemplate().find(queryString);
	}
	
	/**查询所有*/
	public List<Course> getAllObjects(Class<Course> clazz){
		return this.getHibernateTemplate().loadAll(clazz);
	}
	
	/**添加一个*/
	public <T> void addObject(T clazz){
		this.getHibernateTemplate().save(clazz);
	}
	
	/**更新指定的*/
	public <T> void updateObject(T clazz){
		this.getHibernateTemplate().update(clazz);
	}

	/**删除指定的*/
	public <T> void deleteObject(T clazz){
		this.getHibernateTemplate().delete(clazz);
	}
	
	/**通过zzbm获取*/
	public <T> T getObject(Class<T> clazz,Serializable zzbm){
		return this.getHibernateTemplate().get(clazz, zzbm);
	}
}


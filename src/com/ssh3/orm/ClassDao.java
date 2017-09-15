package com.ssh3.orm;


import java.io.Serializable;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ssh.orm.ClaM;

public class ClassDao extends HibernateDaoSupport {
	
	/**查询*/
	@SuppressWarnings("unchecked")
	public List<ClaM> getObjects(String queryString) throws Exception{
		return (List<ClaM>)this.getHibernateTemplate().find(queryString);
	}
	
	@SuppressWarnings("unchecked")
	public List<ClaM> getClaMs()
	{ 
		String queryString = "SELECT u FROM ClaM u";
		return (List<ClaM>)this.getHibernateTemplate().find(queryString);
	}
	
	/**查询所有*/
	public List<ClaM> getAllObjects(Class<ClaM> clazz){
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
	
	/**通过cno获取*/
	public <T> T getObject(Class<T> clazz,Serializable cno){
		return this.getHibernateTemplate().get(clazz, cno);
	}
}


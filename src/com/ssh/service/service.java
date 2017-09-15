package com.ssh.service;

import java.util.List;

import com.ssh.orm.Student;
import com.ssh3.orm.Dao;

/**
 * 用户管理业务逻辑的实现
 * */
public class service<T> {
	
private Dao dao;

    public List<Student> query(Class<Student> clazz) throws Exception{	
	    return dao.getUsers();
    }

	public Student doLogin(String sno,String password) throws Exception{
		if(sno == null || password == null) return null;
		String queryString = "SELECT u FROM Student u WHERE u.sno = '"+sno+"' AND u.password = '"+password+"'";

		System.out.println(queryString);
		List<Student> users = dao.getObjects(queryString);
		return users.get(0);
	}

	public List<Student> queryUsers(String sno,Class<Student> clazz) throws Exception{
		if(sno == null || "".equals(sno))
			return dao.getAllObjects();
		String queryString = "SELECT u FROM Student u WHERE u.sno = '"+sno+"'";
		return dao.getObjects(queryString);
	}
	
	
	public void addUser(T user) throws Exception{
		dao.addObject(user);
	}
	
	public void modifyUser(T user) throws Exception{
		dao.updateObject(user);
	}
	
	public void deleteUser(String sno,Class<T> clazz) throws Exception{
		T u = dao.getObject(clazz, sno);
		dao.deleteObject(u);
	}
	
	@SuppressWarnings("unchecked")
	public T getUser(Class<Student> class1, String sno){
		return (T) dao.getObject(class1, sno);
	}
	
	public Dao getDao() {
		return dao;
	}

	public void setDao(Dao dao) {
		this.dao = dao;
	}
}


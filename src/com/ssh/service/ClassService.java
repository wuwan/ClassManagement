package com.ssh.service;

import java.util.List;

import com.ssh3.orm.ClassDao;
import com.ssh.orm.ClaM;

public class ClassService<T> {
	
private ClassDao classdao;
	
	public List<ClaM> queryClaMs(String cno,Class<ClaM> clazz) throws Exception{
		if(cno == null || "".equals(cno))
		{
		    return classdao.getAllObjects(clazz);
		}
		String queryString = "SELECT u FROM ClaM u WHERE u.cno = '"+cno+"'";
		return classdao.getObjects(queryString);
	}
	
	public List<ClaM> query(Class<ClaM> clazz) throws Exception{	
		return classdao.getClaMs();
    }
	
	public void addClaM(T user) throws Exception{
		classdao.addObject(user);
	}
	
	public void modifyClaM(T user) throws Exception{
		classdao.updateObject(user);
	}
	
	public void deleteClaM(String cno,Class<ClaM> class1) throws Exception{
		ClaM u = classdao.getObject(class1, cno);
		classdao.deleteObject(u);
	}
	
	@SuppressWarnings("unchecked")
	public T getClaM(Class<ClaM> class1, String cborder){
		return (T) classdao.getObject(class1, cborder);
	}

	public ClassDao getClassdao()
	{
		return classdao;
	}

	public void setClassdao(ClassDao classdao)
	{
		this.classdao = classdao;
	}
	
}

package com.ssh.service;

import java.util.List;

import com.ssh.orm.Grade;
import com.ssh3.orm.GradeDao;


public class GradeService<T> {
	
private GradeDao gradedao;

	public List<Grade> queryGrades1(String sno,Class<Grade> clazz) throws Exception{
		if(sno == null || "".equals(sno))
		{
		    return gradedao.getAllObjects();
		}
		String queryString = "SELECT u FROM Grade u WHERE u.id.student.sno = '"+sno+"'";
		return gradedao.getObjects(queryString);
	}
	public List<Grade> querystuGrades1_1(String sno,Class<Grade> clazz) throws Exception{
		if(sno == null || "".equals(sno))
		{
		    return gradedao.getAllObjects();
		}
		String queryString = "SELECT u from Grade u where u.grade=(SELECT max(u.grade) FROM Grade u WHERE u.id.student.sno = '"+sno+"')";
		return gradedao.getObjects(queryString);
	}
	public List<Grade> querystuGrades1_2(String sno,Class<Grade> clazz) throws Exception{
		if(sno == null || "".equals(sno))
		{
		    return gradedao.getAllObjects();
		}
		String queryString = "SELECT u from Grade u where u.grade=(SELECT min(u.grade) FROM Grade u WHERE u.id.student.sno = '"+sno+"')";
		return gradedao.getObjects(queryString);
	}
	
	public List<Grade> querycouGrades1_1(String sno,Class<Grade> clazz) throws Exception{
		if(sno == null || "".equals(sno))
		{
		    return gradedao.getAllObjects();
		}
		String queryString = "SELECT u from Grade u where u.grade=(SELECT max(u.grade) FROM Grade u WHERE u.id.course.courseNumber = '"+sno+"')";
		return gradedao.getObjects(queryString);
	}
	public List<Grade> querycouGrades1_2(String sno,Class<Grade> clazz) throws Exception{
		if(sno == null || "".equals(sno))
		{
		    return gradedao.getAllObjects();
		}
		String queryString = "SELECT u from Grade u where u.grade=(SELECT min(u.grade) FROM Grade u WHERE u.id.course.courseNumber = '"+sno+"')";
		return gradedao.getObjects(queryString);
	}
	
	public List<Grade> queryGrades2(String cno,Class<Grade> clazz) throws Exception{
		if(cno == null || "".equals(cno))
		{
		    return gradedao.getAllObjects();
		}
		String queryString = "SELECT u FROM Grade u WHERE u.id.course.courseNumber = '"+cno+"'";
		return gradedao.getObjects(queryString);
	}
	
	public List<Grade> query(Class<Grade> clazz) throws Exception{	
		return gradedao.getGrades();
    }
	
	public void addGrade(T user) throws Exception{
		gradedao.addObject(user);
	}
	
	public void modifyGrade(T user) throws Exception{
		gradedao.updateObject(user);
	}
	
	public void deleteGrade(String zzbm,Class<Grade> class1) throws Exception{
		Grade u = gradedao.getObject(class1, zzbm);
		gradedao.deleteObject(u);
	}
	
	@SuppressWarnings("unchecked")
	public T getGrade(Class<Grade> class1, String cborder){
		return (T) gradedao.getObject(class1, cborder);
	}

	public GradeDao getGradedao()
	{
		return gradedao;
	}

	public void setGradedao(GradeDao gradedao)
	{
		this.gradedao = gradedao;
	}
	
}

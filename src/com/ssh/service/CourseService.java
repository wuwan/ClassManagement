package com.ssh.service;

import java.util.List;

import com.ssh.orm.Course;
import com.ssh3.orm.CourseDao;

public class CourseService<T> {
	
private CourseDao coursedao;
	
	public List<Course> queryCourses(String courseNumber,Class<Course> clazz) throws Exception{
		if(courseNumber == null || "".equals(courseNumber))
		{
		    return coursedao.getAllObjects(clazz);
		}
		String queryString = "SELECT u FROM Course u WHERE u.courseNumber = '"+courseNumber+"'";
		return coursedao.getObjects(queryString);
	}
	
	public List<Course> query(Class<Course> clazz) throws Exception{	
		return coursedao.getCourses();
    }
	
	public void addCourse(T user) throws Exception{
		coursedao.addObject(user);
	}
	
	public void modifyCourse(T user) throws Exception{
		coursedao.updateObject(user);
	}
	
	public void deleteCourse(String zzbm,Class<Course> class1) throws Exception{
		Course u = coursedao.getObject(class1, zzbm);
		coursedao.deleteObject(u);
	}
	
	@SuppressWarnings("unchecked")
	public T getCourse(Class<Course> class1, String cborder){
		return (T) coursedao.getObject(class1, cborder);
	}

	public CourseDao getCoursedao()
	{
		return coursedao;
	}

	public void setCoursedao(CourseDao coursedao)
	{
		this.coursedao = coursedao;
	}

}

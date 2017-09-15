package com.ssh.action;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.ssh.orm.Course;
import com.ssh.orm.Grade;
import com.ssh.orm.Student;
import com.ssh.service.CourseService;
import com.ssh.service.GradeService;
import com.ssh.service.service;

/**
 * 用户管理控制器
 * */
public class gradeAction extends ActionSupport {

	private static final long serialVersionUID = -281275682819237996L;
	
	private Grade grade = new Grade(); 
	
	private GradeService<Grade> gradeService;
	
	private List<Grade> grades;

	private List<Grade> couGrades1;
	private List<Grade> couGrades2;
	
	private String gradeCode;
	
	
	private String searchText;
	/////////////////学生表////////////////
    private service<Student> userService;
	private List<Student> users;
	/////////////////课程表////////////////////////
    private CourseService<Course> courseService;
	private List<Course> courses;

	
	//////////////////////查询某一学生的课程、成绩、学分////////////////////////
	public String doStudentGrade() throws Exception{
		try{
			searchText = getParam("queryText");
			String cno=null;
			double sum=0;
			grades = gradeService.queryGrades1(searchText,Grade.class);
			for(Grade gd:grades){
				cno=gd.getId().getCourse().getCourseNumber();
				courses=courseService.queryCourses(cno, Course.class);
				for(Course c:courses){
					if(Double.parseDouble(gd.getGrade())>60)
						sum+=Integer.parseInt(c.getCredit());	
				}
			}		
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("sum",sum);		
			return SUCCESS;
		}catch (Exception e) {
			e.printStackTrace();
			return ERROR;
			}
	}
/////////////////////////查询某一门课程的最高、最低分、平均分////////////////////////////////	
	public String doCourseGrade() throws Exception{
		try{
			searchText = getParam("queryText");
			grades = gradeService.queryGrades2(searchText,Grade.class);
			couGrades1 = gradeService.querycouGrades1_1(searchText,Grade.class);
			couGrades2 = gradeService.querycouGrades1_2(searchText,Grade.class);
			double sum=0;
			int n=grades.size();
			for(Grade gd:grades){
				sum+=Double.parseDouble((gd.getGrade()));
			}
			double avg=sum/n;
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("avg", avg);
			return SUCCESS;
		}catch (Exception e) {
			e.printStackTrace();
			return ERROR;
			}
	}
	
	
/////////////////////////查询成绩录入时的学号课程号///////////////////////	
	public String doQuery2() throws Exception
	{
		users =(List<Student>) userService.query(Student.class);
		courses=(List<Course>) courseService.query(Course.class);
		return "stuGrade";
	}
////////////////////////////成绩录入///////////////////////////////////
	public String doGradeAdd(){
		String result = "";
		try {
			System.out.println("进入查询");
			String param = getParam("param");
			System.out.println(param);
			if(Integer.parseInt(param) > 0){
				gradeService.addGrade(grade);
				return "GradeS";
			}else
				result = "addGrade";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	protected String getParam(String key){
		return ServletActionContext.getRequest().getParameter(key);
	}
	public Grade getGrade()
	{
		return grade;
	}
	public void setGrade(Grade grade)
	{
		this.grade = grade;
	}
	public GradeService<Grade> getGradeService()
	{
		return gradeService;
	}
	public void setGradeService(GradeService<Grade> gradeService)
	{
		this.gradeService = gradeService;
	}
	public List<Grade> getGrades()
	{
		return grades;
	}
	public void setGrades(List<Grade> grades)
	{
		this.grades = grades;
	}
	public String getGradeCode()
	{
		return gradeCode;
	}
	public void setGradeCode(String gradeCode)
	{
		this.gradeCode = gradeCode;
	}
	public String getSearchText()
	{
		return searchText;
	}
	public void setSearchText(String searchText)
	{
		this.searchText = searchText;
	}
	public service<Student> getUserService()
	{
		return userService;
	}
	public void setUserService(service<Student> userService)
	{
		this.userService = userService;
	}
	public List<Student> getUsers()
	{
		return users;
	}
	public void setUsers(List<Student> users)
	{
		this.users = users;
	}
	public CourseService<Course> getCourseService()
	{
		return courseService;
	}
	public void setCourseService(CourseService<Course> courseService)
	{
		this.courseService = courseService;
	}
	public List<Course> getCourses()
	{
		return courses;
	}
	public void setCourses(List<Course> courses)
	{
		this.courses = courses;
	}
	
	public List<Grade> getCouGrades1()
	{
		return couGrades1;
	}
	public void setCouGrades1(List<Grade> couGrades1)
	{
		this.couGrades1 = couGrades1;
	}
	public List<Grade> getCouGrades2()
	{
		return couGrades2;
	}
	public void setCouGrades2(List<Grade> couGrades2)
	{
		this.couGrades2 = couGrades2;
	}
    
}

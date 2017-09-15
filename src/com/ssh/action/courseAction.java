package com.ssh.action;


import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.ssh.orm.Course;
import com.ssh.service.CourseService;

/**
 * 用户管理控制器
 * */
public class courseAction extends ActionSupport {

	private static final long serialVersionUID = -281275682819237996L;
	
	private Course course = new Course(); 
	
	private CourseService<Course> courseService;
	
	private List<Course> courses;

	private String CourseCode;
	
	
	private String searchText;
	
/////////////////////////////查询课程/////////////////////////////////	
	public String doCourseQuery() throws Exception{
		try{
			searchText = getParam("queryText");
			courses = courseService.queryCourses(searchText,Course.class);
			return SUCCESS;
		}catch (Exception e) {
			e.printStackTrace();
			return ERROR;
			}
	}

////////////////////////////增加课程///////////////////////////////////
	public String doCourseAdd(){
		String result = "";
		try {
			System.out.println("进入查询");
			String param = getParam("param");
			System.out.println(param);
			if(Integer.parseInt(param) > 0){
				courseService.addCourse(course);
				return "CourseS";
			}else
				result = "addCourse";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
//////////////////////////课程信息修改///////////////////////////////////
	public String docourseEdit() throws Exception{
		try {
			Integer param = Integer.parseInt(getParam("param"));
			if(param == 0){
				String courseNumber = getParam("courseNumber");
				course = (Course) courseService.getCourse(Course.class, courseNumber);
				return "editCourse";
			}else if(param == 1){
				courseService.modifyCourse(course);
				return "updateCourse";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return doCourseQuery();
	}
///////////////////////////课程删除///////////////////////////////////////
	public String docourseDelete() throws Exception{
		try {
			String courseNumber = getParam("courseNumber");
			courseService.deleteCourse(courseNumber,Course.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "deleteCourse";
	}
	
	protected String getParam(String key){
		return ServletActionContext.getRequest().getParameter(key);
	}
	public Course getCourse()
	{
		return course;
	}
	public void setCourse(Course course)
	{
		this.course = course;
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
	
	public String getCourseCode()
	{
		return CourseCode;
	}
	public void setCourseCode(String courseCode)
	{
		CourseCode = courseCode;
	}
	public String getSearchText()
	{
		return searchText;
	}
	public void setSearchText(String searchText)
	{
		this.searchText = searchText;
	}
	
}

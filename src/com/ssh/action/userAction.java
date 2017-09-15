package com.ssh.action;


import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.ssh.orm.ClaM;
import com.ssh.orm.Student;
import com.ssh.service.ClassService;
import com.ssh.service.service;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 用户管理控制器
 * */
public class userAction extends ActionSupport {

	private static final long serialVersionUID = -281275682819237996L;
	
	private Student user = new Student(); 
	
	private service<Student> userService;
	
	private List<Student> users;
	
    private ClaM clam = new ClaM(); 
	
	private ClassService<ClaM> classService;
	
	private List<ClaM> clams;
	
	private String searchText;

 //////////////////////////////用户登录//////////////////////////////////////
	public String doLogin() throws Exception
	{	
		if(this.user.getSno() == null || this.user.getPassword() == null) return INPUT;
		try {
			Student user = userService.doLogin(this.user.getSno(), this.user.getPassword());
			if(user != null){
				ActionContext.getContext().getSession().put("sno", user.getSno());
				return "login";
			}else
				return INPUT;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		
	}
	
	public String doQuery() throws Exception{
		searchText = getParam("queryText");
		users = userService.queryUsers(searchText,Student.class);
		return "login";
	}
	
	//////////////////////查询学生/////////////////////////////////////
	public String dostudentQuery() throws Exception{
		try{
			searchText = getParam("queryText");
			users = userService.queryUsers(searchText,Student.class);
			return SUCCESS;
		}catch (Exception e) {
			e.printStackTrace();
			return ERROR;
			}
	}
	
///////////////////学生添加///////////////////////////	
	public String dostudentAdd(){
		String result = "";
		try {
			System.out.println("进入查询");
			String param = getParam("param");
			System.out.println(param);
			if(Integer.parseInt(param) > 0){
				userService.addUser(user);
				return "userS";
			}else
				result = "addStudent";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
////////////////////////////学生信息修改////////////////////////////////	
	public String dostudentEdit() throws Exception{
		try {
			Integer param = Integer.parseInt(getParam("param"));
			if(param == 0){
				String sno = getParam("sno");
				clams =(List<ClaM>) classService.query(ClaM.class);
				user = (Student) userService.getUser(Student.class, sno);
				return "editUser";
			}else if(param == 1){
				userService.modifyUser(user);
				return "updateUser";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dostudentQuery();
	}
////////////////////////学生删除///////////////////////////////
	public String dostudentDelete() throws Exception{
		try {
			String sno = getParam("sno");
			userService.deleteUser(sno,Student.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "deleteUser";
	}
	
	protected String getParam(String key){
		return ServletActionContext.getRequest().getParameter(key);
	}
	

	public String getSearchText() {
		return searchText;
	}

	public Student getUser() {
		return user;
	}

	public void setUser(Student user) {
		this.user = user;
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
    
	public ClaM getClam()
	{
		return clam;
	}

	public void setClam(ClaM clam)
	{
		this.clam = clam;
	}

	public ClassService<ClaM> getClassService()
	{
		return classService;
	}

	public void setClassService(ClassService<ClaM> classService)
	{
		this.classService = classService;
	}

	public List<ClaM> getClams()
	{
		return clams;
	}

	public void setClams(List<ClaM> clams)
	{
		this.clams = clams;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

}

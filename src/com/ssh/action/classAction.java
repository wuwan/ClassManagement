package com.ssh.action;


import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.ssh.orm.ClaM;
import com.ssh.service.ClassService;

/**
 * 用户管理控制器
 * */
public class classAction extends ActionSupport {

	private static final long serialVersionUID = -281275682819237996L;
	
	private ClaM clam = new ClaM(); 
	
	private ClassService<ClaM> classService;
	
	private List<ClaM> clams;

	private String ClamCode;
	
	
	private String searchText;
	
/////////////////////////////查询班级/////////////////////////////////	
	public String doclamQuery() throws Exception{
		try{
			searchText = getParam("queryText");
			clams = classService.queryClaMs(searchText,ClaM.class);
			return SUCCESS;
		}catch (Exception e) {
			e.printStackTrace();
			return ERROR;
			}
	}
/////////////////////////查询学生添加时的班级///////////////////////	
	public String doQuery2() throws Exception
	{
		clams =(List<ClaM>) classService.query(ClaM.class);
		return "stuClass";
	}
////////////////////////////增加班级///////////////////////////////////
	public String doclamAdd(){
		String result = "";
		try {
			System.out.println("进入查询");
			String param = getParam("param");
			System.out.println(param);
			if(Integer.parseInt(param) > 0){
				classService.addClaM(clam);
				return "clamS";
			}else
				result = "addClaM";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
////////////////////////班级修改////////////////////////////////////	
	public String doclamEdit() throws Exception{
		try {
			Integer param = Integer.parseInt(getParam("param"));
			if(param == 0){
				String cno = getParam("cno");
				clam = (ClaM) classService.getClaM(ClaM.class, cno);
				return "editClass";
			}else if(param == 1){
				classService.modifyClaM(clam);
				return "updateClass";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return doclamQuery();
	}
///////////////////////班级删除////////////////////////////////////////	
	public String doclamDelete() throws Exception{
		try {
			String cno = getParam("cno");
			classService.deleteClaM(cno,ClaM.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "deleteClass";
	}
	
	protected String getParam(String key){
		return ServletActionContext.getRequest().getParameter(key);
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
	public String getClamCode()
	{
		return ClamCode;
	}
	public void setClamCode(String clamCode)
	{
		ClamCode = clamCode;
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

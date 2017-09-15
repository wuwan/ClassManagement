package com.ssh.orm;

import java.util.HashSet;
import java.util.Set;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */

public class Student implements java.io.Serializable
{

	// Fields

	private String sno;
	private ClaM claM;
	private String sname;
	private String sex;
	private String dateBirth;
	private String password;
	private String contact;
	private String home;
	private Set grades = new HashSet(0);

	// Constructors

	/** default constructor */
	public Student()
	{
	}

	/** minimal constructor */
	public Student(String sno)
	{
		this.sno = sno;
	}

	/** full constructor */
	public Student(String sno, ClaM claM, String sname, String sex,
			String dateBirth, String password, String contact, String home,
			Set grades)
	{
		this.sno = sno;
		this.claM = claM;
		this.sname = sname;
		this.sex = sex;
		this.dateBirth = dateBirth;
		this.password = password;
		this.contact = contact;
		this.home = home;
		this.grades = grades;
	}

	// Property accessors

	public String getSno()
	{
		return this.sno;
	}

	public void setSno(String sno)
	{
		this.sno = sno;
	}

	public ClaM getClaM()
	{
		return this.claM;
	}

	public void setClaM(ClaM claM)
	{
		this.claM = claM;
	}

	public String getSname()
	{
		return this.sname;
	}

	public void setSname(String sname)
	{
		this.sname = sname;
	}

	public String getSex()
	{
		return this.sex;
	}

	public void setSex(String sex)
	{
		this.sex = sex;
	}

	public String getDateBirth()
	{
		return this.dateBirth;
	}

	public void setDateBirth(String dateBirth)
	{
		this.dateBirth = dateBirth;
	}

	public String getPassword()
	{
		return this.password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getContact()
	{
		return this.contact;
	}

	public void setContact(String contact)
	{
		this.contact = contact;
	}

	public String getHome()
	{
		return this.home;
	}

	public void setHome(String home)
	{
		this.home = home;
	}

	public Set getGrades()
	{
		return this.grades;
	}

	public void setGrades(Set grades)
	{
		this.grades = grades;
	}

}
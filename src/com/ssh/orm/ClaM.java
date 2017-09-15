package com.ssh.orm;

import java.util.HashSet;
import java.util.Set;

/**
 * ClaM entity. @author MyEclipse Persistence Tools
 */

public class ClaM implements java.io.Serializable
{

	// Fields

	private String cno;
	private String cname;
	private Set students = new HashSet(0);
	private Set grades = new HashSet(0);

	// Constructors

	/** default constructor */
	public ClaM()
	{
	}

	/** minimal constructor */
	public ClaM(String cno)
	{
		this.cno = cno;
	}

	/** full constructor */
	public ClaM(String cno, String cname, Set students, Set grades)
	{
		this.cno = cno;
		this.cname = cname;
		this.students = students;
		this.grades = grades;
	}

	// Property accessors

	public String getCno()
	{
		return this.cno;
	}

	public void setCno(String cno)
	{
		this.cno = cno;
	}

	public String getCname()
	{
		return this.cname;
	}

	public void setCname(String cname)
	{
		this.cname = cname;
	}

	public Set getStudents()
	{
		return this.students;
	}

	public void setStudents(Set students)
	{
		this.students = students;
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
package com.ssh.orm;

/**
 * Course entity. @author MyEclipse Persistence Tools
 */

public class Course implements java.io.Serializable
{

	// Fields

	private String courseNumber;
	private String courseName;
	private String property;
	private String credit;

	// Constructors

	/** default constructor */
	public Course()
	{
	}

	/** minimal constructor */
	public Course(String courseNumber)
	{
		this.courseNumber = courseNumber;
	}

	/** full constructor */
	public Course(String courseNumber, String courseName, String property,
			String credit)
	{
		this.courseNumber = courseNumber;
		this.courseName = courseName;
		this.property = property;
		this.credit = credit;
	}

	// Property accessors

	public String getCourseNumber()
	{
		return this.courseNumber;
	}

	public void setCourseNumber(String courseNumber)
	{
		this.courseNumber = courseNumber;
	}

	public String getCourseName()
	{
		return this.courseName;
	}

	public void setCourseName(String courseName)
	{
		this.courseName = courseName;
	}

	public String getProperty()
	{
		return this.property;
	}

	public void setProperty(String property)
	{
		this.property = property;
	}

	public String getCredit()
	{
		return this.credit;
	}

	public void setCredit(String credit)
	{
		this.credit = credit;
	}

}
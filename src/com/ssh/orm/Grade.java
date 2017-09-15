package com.ssh.orm;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * Grade entity. @author MyEclipse Persistence Tools
 */

public class Grade implements java.io.Serializable
{

	// Fields

	private GradeId id;
	private String grade;

	// Constructors

	/** default constructor */
	public Grade()
	{
	}

	/** full constructor */
	public Grade(GradeId id, String grade)
	{
		this.id = id;
		this.grade = grade;
	}

	// Property accessors
	@GeneratedValue(strategy = GenerationType.AUTO)  
	public GradeId getId()
	{
		return this.id;
	}

	public void setId(GradeId id)
	{
		this.id = id;
	}

	public String getGrade()
	{
		return this.grade;
	}

	public void setGrade(String grade)
	{
		this.grade = grade;
	}

}
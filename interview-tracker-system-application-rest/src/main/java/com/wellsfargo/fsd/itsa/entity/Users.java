package com.wellsfargo.fsd.itsa.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="users")
public class Users implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

/*	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
*/
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="userId")
	//@NotNull(message = "userId can not be omited")
	//@Size(min = 5,max=30,message = "userId must be of 5 to 30 chars in length")
	private int userId;
	


	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="inter_id", referencedColumnName="interview_id")
	@JsonIgnoreProperties("users")
	private Interview interview;
	
	public Interview getInterview() {
		return interview;
	}

	public void setInterview(Interview interview) {
		this.interview = interview;
	}

	@Column(name="firstName")
	@NotNull(message = "firstName can not be omitted")
	@NotBlank(message = "firstName can not be omitted")
	@Size(min = 5,max=30,message = "firstName must be of 5 to 30 chars in length")
	private String firstName;
	
	@Column(name="lastName")
	@NotNull(message = "lastName can not be omitted")
	@NotBlank(message = "lastName can not be omitted")
	@Size(min = 3,max=25,message = "lastName must be of 3 to 25 chars in length")
	private String lastName;
	
	@Column(name="email")
	@NotNull(message = "email can not be omitted")
	@NotBlank(message = "email can not be omitted")
	private String email;
	
		
	
	@Column(name="mobile")
	@NotNull(message = "mobile can not be omitted")
	@NotBlank(message = "mobile can not be omitted")
	@Size(min = 10,max=10,message = "mobile must be 10 chars in length")
	private String mobile;
	
	
	
	public Users() {
		//left unimplemente
	}

	public Users(int userId, String firstName,String lastName,String email , String mobile) {
		super();
		//this.id = id;
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
		
	}
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	
}

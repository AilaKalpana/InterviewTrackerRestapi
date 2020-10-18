package com.wellsfargo.fsd.itsa.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="interview")
public class Interview implements Serializable{
	
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
	@Column(name="interview_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	//@NotNull(message = "interviewId can not be omitted")
	//@NotBlank(message = "interviewId can not be omitted")
	//@Size(min = 4,max=30,message = "interviewId must be of 4 to 30 chars in length")
	private int interviewId;
	
	@Column(name="interviewerName")
	@NotNull(message = "interviewerName can not be omitted")
	@NotBlank(message = "interviewerName can not be omitted")
	@Size(min = 5,max=30,message = "interviewerName must be of 5 to 30 chars in length")
	private String interviewerName;
	
	
	@Column(name="interviewName")
	@NotNull(message = "interviewName can not be omitted")
	@NotBlank(message = "interviewName can not be omitted")
	@Size(min = 3,max=30,message = "interviewName must be of 3 to 30 chars in length")
	private String interviewName;
	
	@Column(name="usersSkills")
	@NotNull(message = "usersSkills can not be omitted")
	@NotBlank(message = "usersSkills can not be omitted")
	@Size(min = 3,max=30,message = "usersSkills must be of 3 to 30 chars in length")
	private String usersSkills;
	

	@Column(name="time")
	@DateTimeFormat(iso = ISO.TIME)
	@NotNull(message = "time can not be omitted")
	private LocalTime time;
	

	@Column(name="date")
	@DateTimeFormat(iso = ISO.DATE)
	@NotNull(message = "date can not be omitted")
	@PastOrPresent(message = "date can not be a past date")
	private LocalDate date;
	
		
	
	@Column(name="interviewStatus")
	@NotNull(message = "interviewStatus can not be omitted")
	@NotBlank(message = "interviewStatus can not be omitted")
	@Size(min = 5,max=100,message = "interviewStatus must be 5 to 100 chars in length")
	private String interviewStatus;
	
	@Column(name="remarks")
	@NotNull(message = "remarks can not be omitted")
	@NotBlank(message = "remarks can not be omitted")
	@Size(min =5,max=100,message = "remarks must be 5 to 100 chars in length")
	private String remarks;
	
	@OneToMany(mappedBy="interview", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnoreProperties("interview")
	private Set<Users> users = new HashSet<>();
	
	public Interview(int interviewId, String interviewerName,String interviewName,LocalTime time,LocalDate date,String usersSkills , String interviewStatus,String remarks) {
		super();
		
		this.interviewId = interviewId;
		this.interviewerName = interviewerName;
		this.interviewName = interviewName;
		this.time = time;
		this.date = date;
		this.usersSkills = usersSkills;
		this.interviewStatus = interviewStatus;
		this.remarks = remarks; 
		
	}
	
	public Interview() {
		//left unimplemente
	}

	public Set<Users> getUsers() {
		return users;
	}

	public void setUsers(Set<Users> users) {
		this.users = users;
	}

	public int getInterviewId() {
		return interviewId;
	}

	public void setInterviewId(int interviewId) {
		this.interviewId = interviewId;
	}

	public String getInterviewerName() {
		return interviewerName;
	}

	public void setInterviewerName(String interviewerName) {
		this.interviewerName = interviewerName;
	}

	public String getInterviewName() {
		return interviewName;
	}

	public void setInterviewName(String interviewName) {
		this.interviewName = interviewName;
	}

	public String getUsersSkills() {
		return usersSkills;
	}

	public void setUsersSkills(String usersSkills) {
		this.usersSkills = usersSkills;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getInterviewStatus() {
		return interviewStatus;
	}

	public void setInterviewStatus(String interviewStatus) {
		this.interviewStatus = interviewStatus;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	
	

	
}

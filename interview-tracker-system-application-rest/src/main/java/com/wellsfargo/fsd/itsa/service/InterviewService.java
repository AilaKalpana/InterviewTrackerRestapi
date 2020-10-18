package com.wellsfargo.fsd.itsa.service;

import java.util.List;

import com.wellsfargo.fsd.itsa.entity.Interview;

import com.wellsfargo.fsd.itsa.exception.ImsException;

public interface InterviewService {

	Interview addInterview(Interview interview) throws ImsException;

	Interview save(Interview interview) throws ImsException;

	boolean deleteInterview(int interviewId) throws ImsException;
	
	Interview findByInterviewId(int interviewId) throws ImsException;
	
	List<Interview> getAllInterviews() throws ImsException;
	
	Interview addInterviewStatus(int interviewId) throws ImsException;
	
	//Interview updateInterviewStatus(int interviewId) throws ImsException;
	Interview updateInterviewStatus(Interview interview) throws ImsException;
	
	Interview addAttendeeToInterview(int interviewId,int userId) throws ImsException;
	
	Interview showAllAttendeeToInterview(String interviewId) throws ImsException;

	List<Interview> getAllInterviewsByInterviewName(String interviewName) throws ImsException;

	List<Interview> getAllInterviewsByInterviewerName(String interviewerName) throws ImsException;

	//Item getItemById(int icode) throws ImsException;

	
}

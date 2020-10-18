package com.wellsfargo.fsd.itsa.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.fsd.itsa.dao.InterviewRepository;
import com.wellsfargo.fsd.itsa.entity.Interview;
import com.wellsfargo.fsd.itsa.exception.ImsException;

@Service
public class InterviewServiceImpl implements InterviewService {

	@Autowired
	private InterviewRepository interviewRepo;

	@Override
	public Interview addInterview(Interview interview) throws ImsException {

		try {
			Interview Interviewdb = interviewRepo.findByInterviewId(interview.getInterviewId());
			if (Interviewdb != null) {
				throw new ImsException("Interview Id already exists!");
			}
			LocalDate dateIST = LocalDate.now(ZoneId.of("Asia/Kolkata"));
			interview.setDate(dateIST);
			LocalTime timeIST = LocalTime.now(ZoneId.of("Asia/Kolkata"));
			interview.setTime(timeIST);
			interviewRepo.save(interview);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ImsException("Exception while adding interview details");
		}

		return interview;
	}

	@Override
	public Interview save(Interview interview) throws ImsException {
		Interview Interviewdb = interviewRepo.findByInterviewId(interview.getInterviewId());
		if (Interviewdb != null) {

			throw new ImsException("Interview Id already exists!");
		}

		interviewRepo.save(interview);
		// }
		return interview;
	}

	@Override
	public Interview updateInterviewStatus(Interview interview) throws ImsException {
		Interview Interviewdb = interviewRepo.findByInterviewId(interview.getInterviewId());
		if (Interviewdb != null) {
			throw new ImsException("interviewId Not Found");
		}
		interview.setInterviewStatus(null);
		interviewRepo.save(interview);

		return interview;
	}

	@Override
	public boolean deleteInterview(int interviewId) throws ImsException {
		Interview Interviewdb = interviewRepo.findByInterviewId(interviewId);
		if (Interviewdb != null) {
			throw new ImsException("interviewId Not Found");
		}

		interviewRepo.deleteById(interviewId);
		return true;
	}

//	@Override
//	public Item getItemById(int icode) throws ImsException {
//		return itemRepo.findById(icode).orElse(null);		
//	}

	@Override
	public List<Interview> getAllInterviews() throws ImsException {
		return interviewRepo.findAll();
	}
	
	@Override
	public List<Interview> getAllInterviewsByInterviewName(String interviewName) throws ImsException {
		List<Interview> interviewdb = interviewRepo.findByInterviewName(interviewName);
		if (interviewdb != null) {
			throw new ImsException("interview Name Not Found");
		}
		return interviewdb;
	}
	
	@Override
	public List<Interview> getAllInterviewsByInterviewerName(String interviewerName) throws ImsException {
		List<Interview> interviewdb = interviewRepo.findByInterviewerName(interviewerName);
		if (interviewdb != null) {
			throw new ImsException("interviewer Name Not Found");
		}
		return interviewdb;
	}

	@Override
	public Interview addInterviewStatus(int interviewId) throws ImsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Interview addAttendeeToInterview(int interviewId, int userId) throws ImsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Interview showAllAttendeeToInterview(String interviewId) throws ImsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Interview findByInterviewId(int interviewId) throws ImsException {
		// TODO Auto-generated method stub
		return null;
	}

}

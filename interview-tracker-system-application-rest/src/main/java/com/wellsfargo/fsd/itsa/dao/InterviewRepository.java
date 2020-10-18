package com.wellsfargo.fsd.itsa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wellsfargo.fsd.itsa.entity.Interview;

@Repository
public interface InterviewRepository extends JpaRepository<Interview, Integer> {

//	Item findByTitle(String title);
//	List<Item> findAllByUnit(String unit);
//	
//	@Query("SELECT i FROM Item i WHERE i.sellingPrice BETWEEN :lower AND :upper")
//	List<Item> findAllInSellingPriceRange(double lower,double upper);
	
	

	Interview findByInterviewId(int interviewId);

	List<Interview> findAllByOrderByInterviewId();

	List<Interview> findByInterviewName(String interviewName);

	List<Interview> findByInterviewerName(String interviewerName);
}

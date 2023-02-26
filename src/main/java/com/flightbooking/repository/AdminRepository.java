package com.flightbooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.flightbooking.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long>  {
	
	@Query("Select a from Admin a where a.emailId=:emailId")
	public Admin getEmailId(@Param(value="emailId")String emailId);
	
	@Query("Select a from Admin a where a.emailId=:email_id and a.password=:password")
	public List<Admin> validateAdmin(@Param(value="email_id")String emailId, @Param(value="password") String password);
}

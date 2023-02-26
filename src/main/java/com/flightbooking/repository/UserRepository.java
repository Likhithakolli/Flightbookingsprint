package com.flightbooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.flightbooking.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query("Select u from User u where u.emailId=:emailId")
	public User getUserByEmail(@Param(value="emailId")String emailId);
	
	@Query("Select u from User u where u.emailId=:email_id and u.password=:password")
	public List<User> validateUser(@Param(value="email_id")String emailId, @Param(value="password") String password);

}

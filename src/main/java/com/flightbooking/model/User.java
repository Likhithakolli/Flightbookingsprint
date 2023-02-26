package com.flightbooking.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private long userId;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="password")
	private String password;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	

	@Column(name="dob")
	private Date dob;
	
	@Column(name="email_id")
	private String emailId;
	
	@Column(name="address")
	private String address;

	
	@Column(name="mobile")
	private long mobile;
	
	//one to many bidirectional mapping- one user can do many bookings
	
	@OneToMany(mappedBy="user")
	//for ignoring the circular mapping between users and booking
	@JsonIgnoreProperties({"user","tickets"})
	private List<Booking> bookings;
}

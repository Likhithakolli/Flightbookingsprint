package com.flightbooking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data 
@AllArgsConstructor 
@NoArgsConstructor	
@Table(name="admin") 
public class Admin {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="admin_id")
	public long adminId;
	
	@Column(name="user_name")
	public String userName;
	
	@Column(name="email_Id")
	public String emailId;
	
	@Column(name="password")
	public String password;
	
}

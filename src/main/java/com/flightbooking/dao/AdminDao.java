package com.flightbooking.dao;

import com.flightbooking.exception.InvalidAdminException;
import com.flightbooking.model.Admin;

public interface AdminDao {
	
	public Admin registerAdmin(Admin admin);
	
	public String loginAdmin(Admin admin) throws InvalidAdminException;

	
}
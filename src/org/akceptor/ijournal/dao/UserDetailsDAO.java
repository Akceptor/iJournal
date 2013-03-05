package org.akceptor.ijournal.dao;

import org.akceptor.ijournal.domain.UserDetails;

public interface UserDetailsDAO {
	public UserDetails getUserRoleByID(int userID);
}
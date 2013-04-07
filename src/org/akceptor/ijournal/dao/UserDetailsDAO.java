package org.akceptor.ijournal.dao;

import org.akceptor.ijournal.domain.UserRoles;

public interface UserDetailsDAO {
	public UserRoles getUserRoleByID(int userID);
}
package org.akceptor.ijournal.dao;

import org.akceptor.ijournal.domain.UsersAndRoles;


public interface UserAndRoleDAO {
	public void addUserAndRole(UsersAndRoles userRole);
	public void updateUserAndRole(UsersAndRoles userRole);
	public void deleteUserAndRole(UsersAndRoles userRole);
}
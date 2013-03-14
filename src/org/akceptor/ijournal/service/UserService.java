package org.akceptor.ijournal.service;

import org.akceptor.ijournal.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserDAO userDAO;

	public int getUserIDByName(String username){
		return userDAO.getUserByName(username).getUserID();
	}
	

	
}
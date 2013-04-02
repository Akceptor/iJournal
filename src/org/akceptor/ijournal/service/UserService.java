package org.akceptor.ijournal.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import org.akceptor.ijournal.dao.UserDAO;
import org.akceptor.ijournal.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserDAO userDAO;

	public int getUserIDByName(String username) {
		return userDAO.getUserByName(username).getUserID();
	}

	public ArrayList<User> findUsers() {
		return (ArrayList<User>) userDAO.findUsers();

	}

	public void addUser(String login, String password) {
		User user = new User();
		user.setUsername(login);
		// MD5 hash password
		MessageDigest m = null;
		try {
			m = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		m.update(password.getBytes(), 0, password.length());
		String hashtext = new BigInteger(1,m.digest()).toString(16);
		// Now we need to zero pad it if you actually want the full 32 chars.
		while(hashtext.length() < 32 ){
		  hashtext = "0"+hashtext;
		}
		
		//set MD5-hashed password to User-object inctance
		user.setPassword(hashtext);
		userDAO.addUser(user);

	}

}
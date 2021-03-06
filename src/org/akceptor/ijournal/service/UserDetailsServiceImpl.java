package org.akceptor.ijournal.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.akceptor.ijournal.dao.UserDAO;
import org.akceptor.ijournal.dao.UserDetailsDAO;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	Logger logger = Logger.getLogger(UserDetailsServiceImpl.class);
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private UserDetailsDAO userDetailsDAO;

	@Transactional
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException, DataAccessException {
		org.akceptor.ijournal.domain.User userFromDAO = userDAO
				.getUserByName(userName);
		if (userFromDAO == null) {
			throw new BadCredentialsException("Bad credentials");
		}
//		System.err.println(userName);
//		System.err.println("UID: "+userDAO.getUserByName(userName).getUserID());
//		System.err.println(userDetailsDAO.getUserRoleByID(userDAO.getUserByName(userName).getUserID()).getAuthority());

		List<GrantedAuthority> grantedAuthorityList = new ArrayList<GrantedAuthority>(
				1);
		grantedAuthorityList.add(new GrantedAuthorityImpl(userDetailsDAO.getUserRoleByID(userDAO
				.getUserByName(userName).getUserID()).getAuthority()));
		//<intercept-url pattern="/**" access="ROLE_USER" />
		User user = new User(userFromDAO.getUsername(),
				userFromDAO.getPassword(), true, true, true, true,
				grantedAuthorityList);
		System.out.println(user.getAuthorities());
		return user;
	}
}
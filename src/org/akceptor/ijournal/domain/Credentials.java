package org.akceptor.ijournal.domain;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
/*
 * Class for getting user credentials from spring security
 * More info here: stackoverflow.com/questions/3523763
 */
public class Credentials {
	public static String getUserName(){
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		UserDetails userDetails = null;
		if (principal instanceof UserDetails) {
		  userDetails = (UserDetails) principal;
		}
		String userName = userDetails.getUsername();
		
		return userName;
	}
	
	public static Collection<GrantedAuthority> getUserRole(){
		Object principal;
		try{
			principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		} catch (Exception e){ principal = null;}
			
			UserDetails userDetails = null;
			if (principal instanceof UserDetails) {
			  userDetails = (UserDetails) principal;
			}
			Collection<GrantedAuthority> userRole = userDetails.getAuthorities();
			
			return userRole;
		}

}

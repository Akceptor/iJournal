package org.akceptor.ijournal.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_roles")
public class UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ROLE_ID")
	private int userRoleID;

	@Column(name = "USER_ID")
	private int userID;
	
	@Column(name = "AUTHORITY")
	private String authority;

	
	public String getAuthority() {
		return authority;
	}


	public void setAuthority(String authority) {
		this.authority = authority;
	}


	public UserDetails() {
	}

	
}
package com.web.config;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.web.model.User;

import lombok.Getter;

@Getter
public class PrincipalDetail implements UserDetails {
	private static final long serialVersionUID = 1L;
	
	private User user;

	public PrincipalDetail(User user) {
		this.user=user;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUserid();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> collectors=new ArrayList<>();
		collectors.add(()->{
			return "ROLE_"+user.getRole();
		});
		return collectors;
	}	
}

package com.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.web.model.User;
import com.web.repository.UserRepository;

@Service
public class PrincipalDetailService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;
	
	//스프링이 로그인 요청을 가로챌 때, id, password 변수 2개를 가로챈다.
	//password는 알아서 하지만 id는 db에 있는지 확인해주어야 한다.
	@Override
	public UserDetails loadUserByUsername(String userid) throws UsernameNotFoundException {
		User principal=userRepository.findByUserid(userid).orElseThrow(()->{
					return new UsernameNotFoundException("해당 사용자를 찾을 수 없습니다.:"+userid);
				});
		return new PrincipalDetail(principal); //시큐리티 세션에 유저 정보가 저장된다.
	}
}

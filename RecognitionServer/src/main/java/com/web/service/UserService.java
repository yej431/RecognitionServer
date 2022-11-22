package com.web.service;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.model.BlockUser;
import com.web.model.RoleType;
import com.web.model.User;
import com.web.repository.ArticleRepository;
import com.web.repository.BlockUserRepository;
import com.web.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;	
	@Autowired
	private BlockUserRepository blockUserRepository;	
	@Autowired
	private ArticleRepository articleRepository;	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	HttpServletResponse response;

	@Transactional
	public int join(User user){	
		String idCheck=userRepository.idCheck(user.getUserid());
		if(idCheck=="" || idCheck == null) {
			String rawPassword = user.getPassword();
			String encPassword = encoder.encode(rawPassword);
			user.setPassword(encPassword);
			user.setRole(RoleType.USER);
			userRepository.save(user);	
			return 1;			
		}else {
			return 0;
		}					
	}
	public Page<User> userList(Pageable pageable) {	
		return userRepository.findAll(pageable);
	}
	public User selectUser(String userid){	
		return userRepository.findUserid(userid);			
	}
	@Transactional
	public int blockUser(String userid){		
		if(userid != "" || userid != null) {
			userRepository.blockUser(userid);	
			userRepository.deleteUser(userid);
			articleRepository.deleteArticleFromBlockUser(userid);
			return 1;
		}else {
			return 0;
		}		
	}
	public Page<BlockUser> blockUserList(Pageable pageable) {	
		return blockUserRepository.findAll(pageable);
	}
	
	/* android */
	@Transactional
	public int androidSignup(User user){	
		String idCheck=userRepository.idCheck(user.getUserid());
		if(idCheck=="" || idCheck == null) {
			String rawPassword = user.getPassword();
			String encPassword = encoder.encode(rawPassword);
			user.setPassword(encPassword);
			user.setRole(RoleType.USER);
			userRepository.save(user);
			return 1;		
		}else{
			return 0;
		}					
	}	
	public int androidLogin(String userid, String password){	
		String idCheck=userRepository.idCheck(userid);
		User user = userRepository.findUserid(userid);
		if(idCheck=="" || idCheck == null) {
			System.out.println("아이디가 존재하지 않습니다,");
			return 2;
		}else if(encoder.matches(password, user.getPassword())){
			System.out.println("비밀번호 일치");
			return 1;
		}else {
			System.out.println("비밀번호 불일치");
			return 0;
		}
	}
}

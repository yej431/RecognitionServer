package com.web.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.web.model.BlockUser;
import com.web.model.User;

public interface UserRepository extends JpaRepository<User,Integer> {	
	
	@Query(value="select userid from user where userid=?1", nativeQuery=true)
	String idCheck(String userid);
	
	@Query(value="select * from user where userid=?1", nativeQuery=true)
	User findUserid(String userid);
	
	Optional<User> findByUserid(String userid);
	
	@Query(value="SELECT date_format(joinDate, '%m') as joinDate, count(*) as cnt FROM user"
			+ "	group by date_format(joinDate, '%Y%m') order by joinDate asc", nativeQuery=true)
	List<Map<String, Object>> userMonthChart();
	
	@Modifying
	@Query(value="insert into blockuser(blockDate, userid) values(now(), ?1)", nativeQuery=true)
	int blockUser(String userid);
	
	@Modifying
	@Query(value="delete from user where userid=?1", nativeQuery=true)
	int deleteUser(String userid);
	
	@Query(value="select * from user order by id desc", nativeQuery=true)
	List<Map<String, Object>> userList(Pageable pageable);	
}
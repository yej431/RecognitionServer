package com.web.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity 
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(nullable=false, length=100, name="userid")
	private String userid;
	
	@Column(nullable=false, length=100, name="password")
	private String password;	
	
	@Column(nullable=false, length=100, name="email")
	private String email;	
	
	@Column(name="role")
	private String role;
	
	@Column(name="joinDate")
	private Date joinDate;
}

package com.mt.spring.security.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="APP_USER")
public class User {
	@Id
	@GeneratedValue
	private Long id;
	@Column(unique=true)
	private String username;
	private String password;
	private String email;
	private boolean active;
	@ElementCollection(fetch=FetchType.EAGER)
	private List<String> roles = new ArrayList<>();

}

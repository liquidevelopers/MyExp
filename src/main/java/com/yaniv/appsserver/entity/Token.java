package com.yaniv.appsserver.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="TOKEN")
public class Token {
	
	@Id
    @GeneratedValue
    private Long id;
	 
	@Column(name="TOKEN")
	@Lob
	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Token [id=" + id + ", token=" + token + "]";
	}

}

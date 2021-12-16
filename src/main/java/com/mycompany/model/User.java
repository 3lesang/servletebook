package com.mycompany.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	private String fullname;
	private String username;
	private String pword;
	private String avatar;
    private String role;
        
	public User() {
            super();
	}
    public User(String fullname, String username, String pword) {
        this.fullname = fullname;
        this.username = username;
        this.pword = pword;
    }

	public void setId(int id) {
		this.id = id;
	}


	public int getId() {
		return id;
	}
	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPword() {
		return pword;
	}

	public void setPword(String pword) {
		this.pword = pword;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
        
    public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.avatar = role;
	}
}
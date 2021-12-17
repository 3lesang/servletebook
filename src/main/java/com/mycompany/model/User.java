package com.mycompany.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
    @OneToMany(mappedBy = "owner")
    private List<Book> ownBooks;
    @ManyToMany(mappedBy="followers")
	private Set<Book> listBooksFollowed;


	public User() {
            super();
	}
    public User(String fullname, String username, String pword, String avatar, String role) {
        this.fullname = fullname;
        this.username = username;
        this.pword = pword;
        this.avatar = avatar;
        this.role = role;
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
    public List<Book> getOwnBooks() {
		return ownBooks;
	}
	public void setOwnBooks(List<Book> ownBooks) {
		this.ownBooks = ownBooks;
	}
	public Set<Book> getListBooksFollowed() {
		return listBooksFollowed;
	}
	public void setListBooksFollowed(Set<Book> listBooksFollowed) {
		this.listBooksFollowed = listBooksFollowed;
	}
}
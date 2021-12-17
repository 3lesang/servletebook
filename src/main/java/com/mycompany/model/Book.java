package com.mycompany.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="books")
public class Book implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private String img;
	private int views;
	@ManyToOne
    @JoinColumn(name = "user_id")
    private User owner;
    private String detail;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated_at;
    @ManyToMany
    @JoinTable(
    		name = "follow",
    		joinColumns = { @JoinColumn(name = "bookID")},
    		inverseJoinColumns = {@JoinColumn(name = "userID")}
    )
    private Set<User> followers;



	public String getCreated_at() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = formatter.format(created_at);
			return strDate;
		}
		public void setCreated_at(Date created_at) {
			this.created_at = created_at;
		}
		public Date getUpdated_at() {
			return updated_at;
		}
		public void setUpdated_at(Date updated_at) {
			this.updated_at = updated_at;
		}
	public Book() {
		
	}
	public Book(String title, String img, int views, User owner, String detail) {
		super();
		this.title = title;
		this.img = img;
		this.views = views;
        this.owner = owner;
        this.detail = detail;
	}
	public Book(int id, String title, String img, int views, User owner, String detail) {
		super();
		this.id = id;
		this.title = title;
		this.img = img;
		this.views = views;
        this.owner = owner;
        this.detail = detail;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}

	public int getViews() {
		return views;
	}


	public void setViews(int views) {
		this.views = views;
	}
        
    public User getOwner() {
            return owner;
        }

    public void setOwner(User user) {
            this.owner = user;
        }
	
    public void setImg(String img) {
            this.img = img;
        }

    public void setDetail(String detail) {
            this.detail = detail;
        }

    public String getImg() {
            return img;
        }

    public String getDetail() {
            return detail;
        }
    
	public Set<User> getFollowers() {
		return followers;
	}
	
	public void setFollowers(Set<User> followers) {
		this.followers = followers;
	}
}
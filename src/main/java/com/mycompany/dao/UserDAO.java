package com.mycompany.dao;

import com.mycompany.model.Book;
import com.mycompany.model.User;
import com.mycompany.util.HibernateUtil;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDAO {
    
    public List<User> getAllUsers(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query q = session.createQuery("FROM User");
            List<User> users = q.getResultList();
            return users;

        } catch (Exception e) {
            System.out.println(e);
        } finally{
            session.close();
        }
        return null;
    }
    public User getUserById(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query q = session.createQuery("FROM User u Where u.id=:id");
            q.setParameter("id", id);
            User user = (User)q.getSingleResult();
            return user;

        } catch (Exception e) {
            System.out.println(e);
        } finally{
            session.close();
        }
        return null;
    }

    public User getUserByUsername(String username){
        Session session = HibernateUtil.getSessionFactory().openSession();
        User user = null;
        try {
                Query q = session.createQuery("FROM User u WHERE u.username=:uname");
                q.setParameter("uname", username);
                user = (User) q.getSingleResult();

        } catch (Exception e) {
                System.out.println(e);
        } finally{
                session.close();
        }
        return user;
    }
    public Set<Book> getListBooksFollowed(int userid) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
        	User u = session.get(User.class, userid);
        	return u.getListBooksFollowed();

        } catch (Exception e) {
                System.out.println(e);
        } finally{
//                session.close();
        }
        return null;
       
    }
    public boolean insertUser(User newUser) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        String username = newUser.getUsername();
        User u = this.getUserByUsername(username);
        if(u == null) {
            try {
                tx = session.beginTransaction();
                session.save(newUser);
                tx.commit();
                return true;
            } catch(Exception e){
                e.printStackTrace();  
            } finally {
                session.close();
            }  

        }
        return false;
    }

    public boolean deleteUser(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            Query q = session.createQuery("DELETE User u Where u.id=:id");
            tx = session.beginTransaction();
            q.setParameter("id", id);
            q.executeUpdate();
            tx.commit();
            return true;
        } catch(Exception e){
            e.printStackTrace();  
        } finally {
            session.close();
        }  
        return false;
    }
    
    public User login(String username, String pw) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        User user = null;
        try {
                Query q = session.createQuery("FROM User u WHERE u.username=:uname AND u.pword=:pw");
                q.setParameter("uname", username);
                q.setParameter("pw", pw);
                user = (User) q.getSingleResult();

        } catch (Exception e) {
                System.out.println(e);
        } finally{
                session.close();
        }
        return user;
    }
    public boolean changePass(String username, String newPass) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        Transaction tx = null;
        try {
        	
            Query q = session.createQuery("UPDATE User u SET u.pword=:pw Where u.username=:username");
            tx = session.beginTransaction();
            q.setParameter("username", username);
            q.setParameter("pw", newPass);
            q.executeUpdate();
            tx.commit();
            return true;
        } catch(Exception e){
            e.printStackTrace();
        } finally {
            session.close();
        }  
        return false;
    }
    
}

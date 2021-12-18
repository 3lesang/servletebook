package com.mycompany.dao;

import com.mycompany.model.Book;
import com.mycompany.model.Category;
import com.mycompany.model.User;
import com.mycompany.util.HibernateUtil;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BookDAO {
    public List<Book> getBooks(String query){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
        	String hql;
        	List<Book> books = null;
        	 switch ( query ) {
        	    
        	    case "trending":
        	    	 hql = "FROM Book ORDER BY views DESC";
	       	    	 Query q1 = session.createQuery(hql);
	       	         books = q1.getResultList();
	       	    	 break;
        	    case "best":
        	    	 hql = "FROM Book ORDER BY rating DESC";
	       	    	 Query q3 = session.createQuery(hql);
	       	         books = q3.getResultList();
	       	         break;
        	    case "new":
        	    	 hql = "FROM Book ORDER BY created_at DESC";
	       	    	 Query q4 = session.createQuery(hql);
	       	         books = q4.getResultList();
        	    	 break;
        	    default:
        	    	hql = "FROM Book WHERE (:title IS NULL) OR title LIKE :title";
        	    	Query q5 = session.createQuery(hql);
                    q5.setParameter("title", '%' +query+ '%');
                    books = q5.getResultList();
        	}
            
            return books;

        } catch (Exception e) {
            System.out.println(e);
        } finally{
            session.close();
        }
        return null;
    }
    
    public Book getBookById(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query q = session.createQuery("FROM Book b Where b.id=:id");
            q.setParameter("id", id);
            Book book = (Book)q.getSingleResult();
            return book;

        } catch (Exception e) {
            System.out.println(e);
        } finally{
            session.close();
        }
        return null;
    }

    public List<Book> getBooksByAuthor(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            User u = session.get(User.class, id);
            return u.getOwnBooks();

        } catch (Exception e) {
            System.out.println(e);
        } finally{
//            session.close();
        }
        return null;
    }

    public List<Book> getAllBooks(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query q = session.createQuery("FROM Book b");
            List<Book> books = q.getResultList();
            return books;

        } catch (Exception e) {
            System.out.println(e);
        } finally{
            session.close();
        }
        return null;
    }

    public int setViewOfBook(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
        	tx = session.beginTransaction();
            Query q = session.createQuery("UPDATE Book b set b.views=(b.views + 1) where b.id =:id");
            q.setParameter("id", id);
            int idBook =  q.executeUpdate();
            tx.commit();
            return idBook;

        } catch (Exception e) {
        	e.printStackTrace();  
        } finally{
            session.close();
        }
        return -1;
    }
    
    public boolean insertBook(Book newBook){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(newBook);
            tx.commit();
            return true;
        } catch(Exception e){
            e.printStackTrace();  
        } finally {
            session.close();
        }  
        return false;
    }
    
    public boolean deleteBook(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            Query q = session.createQuery("DELETE Book b Where b.id=:id");
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

    public boolean updateBook(Book book){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            Query q = session.createQuery("UPDATE Book b SET title = :title, img = :img, detail =:detail Where b.id=:id");
            tx = session.beginTransaction();
            q.setParameter("id", book.getId());
            q.setParameter("title", book.getTitle());
            q.setParameter("img", book.getImg());
            q.setParameter("detail", book.getDetail());
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
    public void follow(int userid, int bookid) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try {
        	Book book = session.get(Book.class, bookid);
        	Set<User> followers = new HashSet<>();
        	followers.add(session.get(User.class, userid));
        	book.setFollowers(followers);
        	session.getTransaction().begin();
        	session.save(book);
        	session.getTransaction().commit();

        } catch (Exception e) {
                System.out.println(e);
        } finally{
                session.close();
        }
      
    }
    public static void main(String[] args ) {
    	
    	
    	Session session = HibernateUtil.getSessionFactory().openSession();
//    	Book book = session.get(Book.class, 90);
//    	Set<User> followers = new HashSet<>();
//    	followers.add(session.get(User.class, 1));
//    	followers.add(session.get(User.class, 2));
//    	book.setFollowers(followers);
//    	session.getTransaction().begin();
//    	session.save(book);
//    	session.getTransaction().commit();
//    	User u = session.get(User.class, 1);
//    	u.getListBooksFollowed().forEach(e -> {
//    		System.out.println(e.getTitle());
//    	});

//    	User entity = (User) session.get(User.class, 1);
//    	Book book = session.get(Book.class, 90);
//    	book.getFollowers().remove(entity);
//    	session.getTransaction().begin();
//    	session.save(book);
//    	session.getTransaction().commit();
//    	Book book = session.get(Book.class, 90);
//    	User entity = (User) session.get(User.class, 2);
//    	if(book.getFollowers().contains(entity)) {
//    		System.out.println("hello");
//    	}

//    	Category c = session.get(Category.class, 10);
//    	c.getBooks().forEach(e -> {
//    		System.out.println(e.getTitle());
//    	});
    }
}

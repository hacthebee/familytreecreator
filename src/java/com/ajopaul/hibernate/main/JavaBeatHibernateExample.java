package com.ajopaul.hibernate.main;

import com.ajopaul.hibernate.model.Author;
import com.ajopaul.hibernate.model.Book;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class JavaBeatHibernateExample {
  public static void main(String args[]) {
      Configuration configuration = new Configuration();
      // configuring hibernate
      SessionFactory sessionFactory = configuration.configure().buildSessionFactory();
      Session session = sessionFactory.openSession();
      Transaction tx = session.beginTransaction();
     // tx.begin();
     
      Book book1 = new Book();
      book1.setName("Java Book");

      List<Book> list = new ArrayList<Book>();
      list.add(book1);

      Author author = new Author();
      author.setName("First Author");
      author.setBooks(list);
      session.save(author);
      tx.commit();;
      session.flush();
      session.close();        
  }
}

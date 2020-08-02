package com.bogdan.Dao;

import com.bogdan.Storage;
import com.bogdan.model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.bogdan.HibernateUtil;
import org.hibernate.query.Query;

import java.util.List;

public class UserDao implements Storage {

    public void addUser(User user) {
        //Create session factory object and getting session object from session factory
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }

    public void updateUser(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
        session.close();
    }

    public void removeUserById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(getUserById(id));
        transaction.commit();
        session.close();
    }

    public void removeUserByName(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(getUserByName(name));
        transaction.commit();
        session.close();
    }

    public void removeAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String sql = String.format("DELETE FROM %s", User.class.getSimpleName());
        Query query = session.createQuery(sql);
        query.executeUpdate();
        transaction.commit();
        session.close();
    }

    public User getUserById(int id) {
        return HibernateUtil.getSessionFactory().openSession().get(User.class, id);
    }

    public List<User> getUserByName(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session
                .createQuery("FROM User WHERE name = :name", User.class)
                .setParameter("name", name)
                .list();
    }

    public List<User> getAllUsers() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        transaction.commit();
        return session.createQuery("FROM User", User.class).list();
    }
}
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
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }

    public void removeAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String hql = String.format("DELETE FROM %s", User.class.getSimpleName());
        Query query = session.createQuery(hql);
        query.executeUpdate();
        transaction.commit();
    }

    public void removeUserById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(getUserById(id));
        transaction.commit();
    }

    public void removeUserByName(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(getUserByName(name));
        transaction.commit();
    }

    public User getUserById(int id) {
        return HibernateUtil.getSessionFactory().openSession().get(User.class, id);
    }

    public User getUserByName(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session
                .createQuery("FROM User WHERE name = :name ", User.class)
                .setParameter("name", name)
                .getSingleResult();
    }

    public List<User> getAllUsers() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.createQuery("FROM User", User.class).list();
    }

    public void updateUser(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
    }
}
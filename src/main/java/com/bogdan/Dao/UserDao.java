package com.bogdan.Dao;

import com.bogdan.Storage;
import com.bogdan.model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.bogdan.HibernateUtil;
import org.hibernate.query.Query;

import java.util.List;

public class UserDao implements Storage {

    private static Session session;

    // Method 1: Create a new user in the database
    public void addUser(User user) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
            System.out.println("\n>>> Successfully created user!\n");
        } catch(Exception sqlException) {
            if(session.getTransaction() != null) {
                System.out.println("\nTransaction is being rolled back\n");
                session.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if(session != null) {
                session.close();
            }
        }
    }

    // Method 2: Update a user in the database
    public void updateUser(User user) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
            System.out.println("\n>>> User with id = " + user.getId() + " is successfully updated!\n");
        } catch(Exception sqlException) {
            if(session.getTransaction() != null) {
                System.out.println("\nTransaction is being rolled back\n");
                session.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if(session != null) {
                session.close();
            }
        }
    }

    // Method 3.1: Delete a user by id from the database
    public void removeUserById(int id) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.delete(getUserById(id));
            transaction.commit();
            System.out.println("\n>>> Student with id = " + id + " is successfully deleted!\n");
        } catch(Exception sqlException) {
            if(session.getTransaction() != null) {
                System.out.println("\nTransaction is being rolled back\n");
                session.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if(session != null) {
                session.close();
            }
        }
    }

    // Method 3.2: Delete a users by name from the database
    public void removeUserByName(String name) {
        getUserByName(name);
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("DELETE FROM User WHERE name = :name").setParameter("name", name);
            query.executeUpdate();
            transaction.commit();
            System.out.println("\n>>> Students with name = " + name + " is successfully deleted!\n");
        } catch(Exception sqlException) {
            if(session.getTransaction() != null) {
                System.out.println("\nTransaction is being rolled back\n");
                session.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if(session != null) {
                session.close();
            }
        }
    }

    // Method 3.3: Delete all users from the database
    public void removeAll() {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("DELETE FROM User");
            query.executeUpdate();
            transaction.commit();
            System.out.println("\n>>> Successfully deleted all users from the database!\n");
        } catch(Exception sqlException) {
            if(session.getTransaction() != null) {
                System.out.println("\nTransaction is being rolled back\n");
                session.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if(session != null) {
                session.close();
            }
        }
    }

    // Method 4.1: Find user by id i the database
    public User getUserById(int id) {
        User user = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            user = session.get(User.class, id);
            transaction.commit();
            System.out.println(">>> User with id = " + id + ":\n" + user);
        } catch(Exception sqlException) {
            if(session.getTransaction() != null) {
                System.out.println("\nTransaction is being rolled back\n");
                session.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if(session != null) {
                session.close();
            }
        }
        return user;
    }

    // Method 4.2: Display all users by name from the database
    public List<User> getUserByName(String name) {
        List<User> usersList = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            usersList = session.createQuery("FROM User WHERE name = :name", User.class).setParameter("name", name).list();
            transaction.commit();
            if (usersList != null) {
                System.out.println(">>> User(s) with name = " + name + ": ");
                for (User s : usersList) {
                    System.out.println(s);
                }
            }
        } catch(Exception sqlException) {
            if(session.getTransaction() != null) {
                System.out.println("\nTransaction is being rolled back\n");
                session.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if(session != null) {
                session.close();
            }
        }
        return usersList;
    }

    // Method 4.3: Display all users from the database
    public List<User> getAllUsers() {
        List<User> usersList = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            usersList = session.createQuery("FROM User", User.class).list();
            transaction.commit();
            if (usersList != null) {
                System.out.println(">>> All users:");
                for (User s : usersList) {
                    System.out.println(s);
                }
            }
        } catch(Exception sqlException) {
            if(session.getTransaction() != null) {
                System.out.println("\nTransaction is being rolled back\n");
                session.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if(session != null) {
                session.close();
            }
        }
        return usersList;
    }
}
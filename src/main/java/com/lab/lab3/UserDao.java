package com.lab.lab3;

import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class UserDao {


    public User findById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        User user = session.get(User.class, id);
        tx1.commit();
        session.close();
        return user;
    }


    public void save(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(user);
        tx1.commit();
        session.close();
    }


    public void update(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(user);
        tx1.commit();
        session.close();
    }


    public void delete(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.delete(user);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    /*
       Метод deleteA приймає Auto auto
       Відкривається сесія
       Якщо не було виключення, починеає транзакцію, видаляє авто, зберігаються зміни, сесія закривається
       Якщо з'явилось виключення, то воно виводиться на екран
     */
    public void deleteA(Auto auto) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.delete(auto);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    /*
       Метод deleteB приймає Bicycle bicycle
       Відкривається сесія
       Якщо не було виключення, починеає транзакцію, видаляє авто, зберігаються зміни, сесія закривається
       Якщо з'явилось виключення, то воно виводиться на екран
     */
    public void deleteB(Bicycle bicycle) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.delete(bicycle);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    /*
       Метод deleteM приймає Motorbike motorbike
       Відкривається сесія
       Якщо не було виключення, починеає транзакцію, видаляє авто, зберігаються зміни, сесія закривається
       Якщо з'явилось виключення, то воно виводиться на екран
     */
    public void deleteM(Motorbike motorbike) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.delete(motorbike);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }


    public Auto findAutoById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        Auto auto = session.get(Auto.class, id);
        tx1.commit();
        session.close();
        return auto;
    }

    /*
    Метод findBicycleById повертає знайдений велосипед за id
     */
    public Bicycle findBicycleById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        Bicycle bicycle = session.get(Bicycle.class, id);
        tx1.commit();
        session.close();
        return bicycle;
    }

    /*
    Метод findMotorbikeById повертає знайдений мотоцикл за id
     */
    public Motorbike findMotorbikeById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        Motorbike motorbike = session.get(Motorbike.class, id);
        tx1.commit();
        session.close();
        return motorbike;
    }


    public List<User> findAll() {
        List<User> users = (List<User>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From User").list();
        return users;
    }
}


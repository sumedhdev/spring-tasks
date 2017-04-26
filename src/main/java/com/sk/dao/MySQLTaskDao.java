package com.sk.dao;

import com.sk.entity.Task;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
@Qualifier("MySQLData")
public class MySQLTaskDao implements TaskDao {

    private static SessionFactory sessionFactory;

    static {
        Configuration config = new Configuration().configure().addAnnotatedClass(Task.class);
        ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
        sessionFactory = config.buildSessionFactory(registry);
    }

    @Override
    public Collection<Task> getAllTasks() {
        Session session = sessionFactory.openSession();
        Collection<Task> allTasks = null;
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            allTasks = session.createCriteria(Task.class).list();
            tx.commit();
        }
        catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        }
        finally {
            session.close();
        }
        return allTasks;
    }

    @Override
    public Task getTaskById(int id) {
        Session session = sessionFactory.openSession();
        Task task = null;
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            task = (Task) session.get(Task.class, id);
            tx.commit();
        }
        catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        }
        finally {
            session.close();
        }
        return task;
    }

    @Override
    public void addTask(String description, boolean isCompleted) {
        Session session = sessionFactory.openSession();
        Task task = null;
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.save(new Task(description, isCompleted));
            tx.commit();
        }
        catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        }
        finally {
            session.close();
        }
    }

    @Override
    public void updateTask(Task task) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(task);
            tx.commit();
        }
        catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        }
        finally {
            session.close();
        }
    }

    @Override
    public void deleteTaskById(int id) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.delete(session.load(Task.class, id));
            tx.commit();
        }
        catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        }
        finally {
            session.close();
        }
    }
}


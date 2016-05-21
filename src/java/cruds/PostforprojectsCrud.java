/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cruds;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import pojos.Postforprojects;
import seesioncreator.SessionCreation;

/**
 *
 * @author hassan
 */
public class PostforprojectsCrud implements PostforprojectsCrudInt {

    @Override
    public void insert(Postforprojects postforprojects) {

        Session sc = SessionCreation.getSessionFactory().openSession();

        try {
            sc.beginTransaction();
            sc.saveOrUpdate(postforprojects);
            sc.getTransaction().commit();
        } catch (HibernateException e) {
            sc.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            sc.close();
        }

    }

    @Override
    public Postforprojects select(Integer id) {

        Session sc = SessionCreation.getSessionFactory().openSession();
        Postforprojects postforprojects = new Postforprojects();

        try {
            sc.beginTransaction();
            postforprojects = (Postforprojects) sc.get(Postforprojects.class, id);
            sc.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }

        return postforprojects;

    }

    @Override
    public void update(Integer id, Postforprojects postforprojects) {

        Session sc = SessionCreation.getSessionFactory().openSession();

        try {
            sc.beginTransaction();
            Postforprojects postforprojects1 = (Postforprojects) sc.get(Postforprojects.class, id);
            postforprojects1.setPost(postforprojects.getPost());
            sc.update(postforprojects1);
            sc.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }

    }

    @Override
    public void delete(Integer id) {

        Session sc = SessionCreation.getSessionFactory().openSession();

        try {
            sc.beginTransaction();
            Postforprojects postforprojects = (Postforprojects) sc.get(Postforprojects.class, id);
            sc.delete(postforprojects);
            sc.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }

    }

}

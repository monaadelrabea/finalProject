/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cruds;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import pojos.Replying;

/**
 *
 * @author hassan
 */
public class ReplyingCrud implements ReplyingCrudInt {

    @Override
    public void insert(Replying replying) {

        Session sc = sessioncreator.SessionCreation.getSessionFactory().openSession();

        try {
            sc.beginTransaction();
            sc.saveOrUpdate(replying);
            sc.getTransaction().commit();
        } catch (HibernateException e) {
            sc.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            sc.close();
        }

    }

    @Override
    public Replying select(Integer id) {

        Session sc = sessioncreator.SessionCreation.getSessionFactory().openSession();
        Replying replying = new Replying();

        try {
            sc.beginTransaction();
            replying = (Replying) sc.get(Replying.class, id);
            sc.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }

        return replying;

    }

    @Override
    public void update(Integer id, Replying replying) {

        Session sc = sessioncreator.SessionCreation.getSessionFactory().openSession();

        try {
            sc.beginTransaction();
            Replying replying1 = (Replying) sc.get(Replying.class, id);
            replying1.setComment(replying.getComment());
            sc.update(replying1);
            sc.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }

    }

    @Override
    public void delete(Integer id) {

        Session sc = sessioncreator.SessionCreation.getSessionFactory().openSession();

        try {
            sc.beginTransaction();
            Replying replying = (Replying) sc.get(Replying.class, id);
            sc.delete(replying);
            sc.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }

    }

}

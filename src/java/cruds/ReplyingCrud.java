/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cruds;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import pojos.Comments;
import seesioncreator.SessionCreation;

/**
 *
 * @author hassan
 */
public class ReplyingCrud implements ReplyingCrudInt {

    @Override
    public void insert(Comments replying) {

        Session sc = SessionCreation.getSessionFactory().openSession();

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
    public Comments select(Integer id) {

        Session sc = SessionCreation.getSessionFactory().openSession();
       Comments replying = new Comments();

        try {
            sc.beginTransaction();
            replying = (Comments) sc.get(Comments.class, id);
            sc.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }

        return replying;

    }

    @Override
    public void update(Integer id, Comments replying) {

        Session sc = SessionCreation.getSessionFactory().openSession();

        try {
            sc.beginTransaction();
            Comments replying1 = (Comments) sc.get(Comments.class, id);
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

        Session sc = SessionCreation.getSessionFactory().openSession();

        try {
            sc.beginTransaction();
          Comments replying = (Comments) sc.get(Comments.class, id);
            sc.delete(replying);
            sc.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }

    }

}

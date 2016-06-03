/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cruds;

import crudsinterface.ReplyingCrudInterface;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import pojos.Comments;
import seesioncreator.SessionCreation;

/**
 *
 * @author hassan
 */
public class ReplyingCrudImplementation implements ReplyingCrudInterface {

    @Override
    public boolean insert(Comments replying) {
boolean flag =true;
        Session sc = SessionCreation.getSessionFactory().openSession();

        try {
            sc.beginTransaction();
            sc.saveOrUpdate(replying);
            sc.getTransaction().commit();
        } catch (HibernateException e) {
            sc.getTransaction().rollback();
            e.printStackTrace();
            flag=false;
        } finally {
            sc.close();
        }
return flag;
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
    public boolean  update(Integer id, Comments replying) {
boolean flag =true;
        Session sc = SessionCreation.getSessionFactory().openSession();

        try {
            sc.beginTransaction();
            Comments replying1 = (Comments) sc.get(Comments.class, id);
            replying1.setComment(replying.getComment());
            sc.update(replying1);
            sc.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            flag=false;
        } finally {
            sc.close();
        }
return flag;
    }

    @Override
    public boolean  delete(Integer id) {
    boolean flag=true;
        Session sc = SessionCreation.getSessionFactory().openSession();

        try {
            sc.beginTransaction();
          Comments replying = (Comments) sc.get(Comments.class, id);
            sc.delete(replying);
            sc.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            flag=false;
        } finally {
            sc.close();
        }
return flag;
    }

}

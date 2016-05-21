/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cruds;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import pojos.Phoneofuser;

/**
 *
 * @author hassan
 */
public class PhoneofuserCrud implements PhoneofuserCrudInt {

    @Override
    public void insert(Phoneofuser pc) {

        Session sc = sessioncreator.SessionCreation.getSessionFactory().openSession();

        try {
            sc.beginTransaction();
            sc.saveOrUpdate(pc);
            sc.getTransaction().commit();
        } catch (HibernateException e) {
            sc.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            sc.close();
        }

    }

    @Override
    public Phoneofuser select(Integer id) {

        Session sc = sessioncreator.SessionCreation.getSessionFactory().openSession();
        Phoneofuser phoneofuser = new Phoneofuser();

        try {
            sc.beginTransaction();
            phoneofuser = (Phoneofuser) sc.get(Phoneofuser.class, id);
            sc.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }

        return phoneofuser;

    }

    @Override
    public void update(Integer id, Phoneofuser pc) {

        Session sc = sessioncreator.SessionCreation.getSessionFactory().openSession();

        try {
            sc.beginTransaction();
            Phoneofuser phoneofuser = (Phoneofuser) sc.get(Phoneofuser.class, id);
            phoneofuser.setPhoneNumber(pc.getPhoneNumber());
            sc.update(phoneofuser);
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
            Phoneofuser phoneofuser = (Phoneofuser) sc.get(Phoneofuser.class, id);
            sc.delete(phoneofuser);
            sc.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }

    }

}

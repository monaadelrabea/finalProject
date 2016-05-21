/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cruds;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import pojos.Portofolioforuser;

/**
 *
 * @author hassan
 */
public class PortofolioforuserCrud implements PortofolioforuserCrudInt {

    @Override
    public void insert(Portofolioforuser portofolioforuser) {

        Session sc = sessioncreator.SessionCreation.getSessionFactory().openSession();

        try {
            sc.beginTransaction();
            sc.saveOrUpdate(portofolioforuser);
            sc.getTransaction().commit();
        } catch (HibernateException e) {
            sc.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            sc.close();
        }

    }

    @Override
    public Portofolioforuser select(Integer id) {

        Session sc = sessioncreator.SessionCreation.getSessionFactory().openSession();
        Portofolioforuser portofolioforuser = new Portofolioforuser();

        try {
            sc.beginTransaction();
            portofolioforuser = (Portofolioforuser) sc.get(Portofolioforuser.class, id);
            sc.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }

        return portofolioforuser;

    }

    @Override
    public void update(Integer id, Portofolioforuser portofolioforuser) {

        Session sc = sessioncreator.SessionCreation.getSessionFactory().openSession();

        try {
            sc.beginTransaction();
            Portofolioforuser protofolioforuser = (Portofolioforuser) sc.get(Portofolioforuser.class, id);
            protofolioforuser.setPortofolioDescription(portofolioforuser.getPortofolioDescription());
            sc.update(protofolioforuser);
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
            Portofolioforuser portofolioforuser = (Portofolioforuser) sc.get(Portofolioforuser.class, id);
            sc.delete(portofolioforuser);
            sc.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }

    }

}

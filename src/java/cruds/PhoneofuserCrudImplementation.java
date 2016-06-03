/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cruds;

import crudsinterface.PhoneofuserCrudInterface;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import pojos.Phoneofuser;
import seesioncreator.SessionCreation;

/**
 *
 * @author hassan
 */
public class PhoneofuserCrudImplementation implements PhoneofuserCrudInterface {

    @Override
    public boolean insert(Phoneofuser pc) {
boolean flag=true;
        Session sc = SessionCreation.getSessionFactory().openSession();

        try {
            sc.beginTransaction();
            sc.saveOrUpdate(pc);
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
    public Phoneofuser select(Integer id) {

        Session sc = SessionCreation.getSessionFactory().openSession();
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
    public boolean update(Integer id, Phoneofuser pc) {
      boolean flag=true;
        Session sc = SessionCreation.getSessionFactory().openSession();

        try {
            sc.beginTransaction();
            Phoneofuser phoneofuser = (Phoneofuser) sc.get(Phoneofuser.class, id);
            phoneofuser.setPhoneNumber(pc.getPhoneNumber());
            sc.update(phoneofuser);
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
    public boolean delete(Integer id) {
boolean flag=true;
        Session sc = SessionCreation.getSessionFactory().openSession();

        try {
            sc.beginTransaction();
            Phoneofuser phoneofuser = (Phoneofuser) sc.get(Phoneofuser.class, id);
            sc.delete(phoneofuser);
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

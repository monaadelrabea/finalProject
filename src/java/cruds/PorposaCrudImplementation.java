/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cruds;

import crudsinterface.PorposaCrudInterface;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import pojos.Porposa;
import seesioncreator.SessionCreation;

/**
 *
 * @author hassan
 */
public class PorposaCrudImplementation implements PorposaCrudInterface {

    @Override
    public boolean  insert(Porposa porposa) {
boolean flag=true;
        Session sc =SessionCreation.getSessionFactory().openSession();

        try {
            sc.beginTransaction();
            sc.saveOrUpdate(porposa);
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
    public Porposa select(Integer id) {

        Session sc = SessionCreation.getSessionFactory().openSession();
        Porposa porposa = new Porposa();

        try {
            sc.beginTransaction();
            porposa = (Porposa) sc.get(Porposa.class, id);
            sc.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }

        return porposa;

    }

    @Override
    public boolean update(Integer id, Porposa porposa) {
boolean flag=true;
        Session sc = SessionCreation.getSessionFactory().openSession();

        try {
            sc.beginTransaction();
            Porposa porposa1 = (Porposa) sc.get(Porposa.class, id);
            porposa1.setPrice(porposa.getPrice());
            sc.update(porposa1);
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
            Porposa porposa = (Porposa) sc.get(Porposa.class, id);
            sc.delete(porposa);
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

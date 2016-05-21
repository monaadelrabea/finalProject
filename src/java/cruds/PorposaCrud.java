/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cruds;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import pojos.Porposa;

/**
 *
 * @author hassan
 */
public class PorposaCrud implements PorposaCrudInt {

    @Override
    public void insert(Porposa porposa) {

        Session sc = sessioncreator.SessionCreation.getSessionFactory().openSession();

        try {
            sc.beginTransaction();
            sc.saveOrUpdate(porposa);
            sc.getTransaction().commit();
        } catch (HibernateException e) {
            sc.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            sc.close();
        }

    }

    @Override
    public Porposa select(Integer id) {

        Session sc = sessioncreator.SessionCreation.getSessionFactory().openSession();
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
    public void update(Integer id, Porposa porposa) {

        Session sc = sessioncreator.SessionCreation.getSessionFactory().openSession();

        try {
            sc.beginTransaction();
            Porposa porposa1 = (Porposa) sc.get(Porposa.class, id);
            porposa1.setPrice(porposa.getPrice());
            sc.update(porposa1);
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
            Porposa porposa = (Porposa) sc.get(Porposa.class, id);
            sc.delete(porposa);
            sc.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cruds;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import pojos.Portofolioiamges;
import pojos.Users;

/**
 *
 * @author hassan
 */
public class PortofolioiamgesCrud implements PortofolioiamgesCrudInt {

    @Override
    public void insert(Portofolioiamges p) {

        Session sc = sessioncreator.SessionCreation.getSessionFactory().openSession();

        try {
            sc.beginTransaction();
            sc.saveOrUpdate(p);
            sc.getTransaction().commit();
        } catch (HibernateException e) {
            sc.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            sc.close();
        }

    }

    @Override
    public Portofolioiamges select(Integer id) {

        Session sc = sessioncreator.SessionCreation.getSessionFactory().openSession();
        Portofolioiamges portofolioiamges = new Portofolioiamges();

        try {
            sc.beginTransaction();
            portofolioiamges = (Portofolioiamges) sc.get(Portofolioiamges.class, id);
            sc.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }

        return portofolioiamges;

    }

    @Override
    public void update(Integer id, Portofolioiamges p) {

        Session sc = sessioncreator.SessionCreation.getSessionFactory().openSession();

        try {
            sc.beginTransaction();
            Portofolioiamges portofolioiamges = (Portofolioiamges) sc.get(Portofolioiamges.class, id);
            portofolioiamges.setPortfolioImageUrl(p.getPortfolioImageUrl());
            sc.update(portofolioiamges);
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
            Portofolioiamges portofolioiamges = (Portofolioiamges) sc.get(Portofolioiamges.class, id);
            sc.delete(portofolioiamges);
            sc.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }

    }

}

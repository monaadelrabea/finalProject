/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cruds;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import pojos.Users;
import seesioncreator.SessionCreation;

/**
 *
 * @author hassan
 */
public class UsersCrud implements UsersCrudInt {

    @Override
    public void insert(Users u) {

        Session sc = SessionCreation.getSessionFactory().openSession();

        try {
            sc.beginTransaction();
            sc.saveOrUpdate(u);
            sc.getTransaction().commit();
        } catch (HibernateException e) {
            sc.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            sc.close();
        }

    }

    @Override
    public Users select(Integer id) {

        Session sc = SessionCreation.getSessionFactory().openSession();
        Users users = new Users();

        try {
            sc.beginTransaction();
            users = (Users) sc.get(Users.class, id);
            sc.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }

        return users;

    }

    @Override
    public void update(Integer id, Users u) {

        Session sc = SessionCreation.getSessionFactory().openSession();

        try {
            sc.beginTransaction();
            Users users = (Users) sc.get(Users.class, id);
            users.setCity(u.getCity());
            sc.update(users);
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
            Users users = (Users) sc.get(Users.class, id);
            sc.delete(users);
            sc.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }

    }

}

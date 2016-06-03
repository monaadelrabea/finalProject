/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cruds;

import crudsinterface.UsersCrudInterface;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import pojos.Users;
import seesioncreator.SessionCreation;

/**
 *
 * @author hassan
 */
public class UsersCrudImplementation implements UsersCrudInterface {

    @Override
    public boolean insert(Users u) {
        boolean flag = true;
        Session sc = SessionCreation.getSessionFactory().openSession();

        try {
            sc.beginTransaction();
            sc.saveOrUpdate(u);
            sc.getTransaction().commit();
        } catch (HibernateException e) {
            sc.getTransaction().rollback();
            e.printStackTrace();
            flag = false;
        } finally {
            sc.close();
        }
        return flag;
    }

 
    @Override
    public Users selectEP(String email, String password) {
        Session sc = SessionCreation.getSessionFactory().openSession();

        List users =new ArrayList();
        try {
            sc.beginTransaction();
            Criteria cr = sc.createCriteria(Users.class);
            cr.add(Restrictions.eq("userEmail", email));
            cr.add(Restrictions.eq("password", password));
            users = cr.list();
            sc.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }
        return ((Users) users.get(0));
    }

    @Override
    public Users select(int id) {

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
    public boolean update(int id, Users u) {
        boolean flag = true;
        Session sc = SessionCreation.getSessionFactory().openSession();

        try {
            sc.beginTransaction();
            Users users = (Users) sc.get(Users.class, id);
            users.setCity(u.getCity());
            sc.update(users);
            sc.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            flag = false;
        } finally {
            sc.close();
        }
        return flag;
    }

    @Override
    public boolean delete(int id) {
        boolean flag = true;
        Session sc = SessionCreation.getSessionFactory().openSession();

        try {
            sc.beginTransaction();
            Users users = (Users) sc.get(Users.class, id);
            sc.delete(users);
            sc.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            flag = false;
        } finally {
            sc.close();
        }
        return flag;
    }

    @Override
    public ArrayList<Users> selectMaxRateUsers() {
        ArrayList<Users> maxRate= new ArrayList<>();
         Session session = SessionCreation.getSessionFactory().openSession();
Criteria criteria = session
   .createCriteria(Users.class)
   .setProjection(Projections.max("rate")); 
    maxRate=(ArrayList<Users>) criteria.list();
    return maxRate;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cruds;

import crudsinterface.PorposaCrudInterface;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import pojos.Porposa;
import pojos.Projectsforusers;
import pojos.Users;
import seesioncreator.SessionCreation;

/**
 *
 * @author hassan
 */
public class PorposaCrudImplementation implements PorposaCrudInterface {

    Session sc;

    public PorposaCrudImplementation() {
        sc = SessionCreation.getSessionFactory().openSession();
    }

    @Override
    public boolean insert(Porposa porposa) {
        boolean flag = true;

        try {
            sc.beginTransaction();
            sc.saveOrUpdate(porposa);
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
    public ArrayList<Porposa> selectPorposeHQL(int id) {

        ArrayList<Porposa> porposas = new ArrayList<>();

        try {
            sc.beginTransaction();
            Criteria cr = sc.createCriteria(Users.class);
            cr.add(Restrictions.eq("projectsforusers.projectId", id));
            porposas = (ArrayList<Porposa>) cr.list();
            sc.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }

        return porposas;

    }

    @Override
    public Porposa select(Integer id) {

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
        boolean flag = true;

        try {
            sc.beginTransaction();
            Porposa porposa1 = (Porposa) sc.get(Porposa.class, id);
            porposa1.setPrice(porposa.getPrice());
            sc.update(porposa1);
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
    public boolean delete(Integer id) {
        boolean flag = true;
        try {
            sc.beginTransaction();
            Porposa porposa = (Porposa) sc.get(Porposa.class, id);
            sc.delete(porposa);
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
    public ArrayList<Object> projectsIds(int porId) {
        List<Object> pIds = new ArrayList<>();
        Query m = sc.createQuery("select por from Porposa por left join fetch por.projectsforusers where porpId=?)");
        m.setInteger(0, porId);
        pIds = m.list();
        return (ArrayList<Object>) pIds;
    }
 @Override
   public Object user(int porId) {
        List<Object> pIds = new ArrayList<>();
        Query m = sc.createQuery("select por from Porposa por left join fetch por.users where porpId=?)");
        m.setInteger(0, porId);
        pIds = m.list();
        return (ArrayList<Object>) pIds.get(0);
    }
}

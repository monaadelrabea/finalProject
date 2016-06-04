/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cruds;

import crudsinterface.PortofolioforuserCrudInterface;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import pojos.Category;
import pojos.Portofolioforuser;
import pojos.Users;
import seesioncreator.SessionCreation;

/**
 *
 * @author hassan
 */
public class PortofolioforuserCrudImplementation implements PortofolioforuserCrudInterface {

    @Override
    public boolean insert(Portofolioforuser portofolioforuser) {
boolean flag=true;
        Session sc = SessionCreation.getSessionFactory().openSession();

        try {
            sc.beginTransaction();
            sc.saveOrUpdate(portofolioforuser);
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
    public Portofolioforuser select(int id) {

        Session sc = SessionCreation.getSessionFactory().openSession();
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
    public boolean update(int id, Portofolioforuser portofolioforuser) {
boolean flag=true;
        Session sc = SessionCreation.getSessionFactory().openSession();

        try {
            sc.beginTransaction();
            Portofolioforuser protofolioforuser = (Portofolioforuser) sc.get(Portofolioforuser.class, id);
            protofolioforuser.setPortofolioDescription(portofolioforuser.getPortofolioDescription());
            sc.update(protofolioforuser);
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
    public boolean delete(int id) {
boolean flag=true;
        Session sc = SessionCreation.getSessionFactory().openSession();

        try {
            sc.beginTransaction();
            Portofolioforuser portofolioforuser = (Portofolioforuser) sc.get(Portofolioforuser.class, id);
            sc.delete(portofolioforuser);
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
    public ArrayList<Portofolioforuser> selectPortofolios(Category cat) {
        List <Portofolioforuser> portofolios = new ArrayList<>();
 Session sc = SessionCreation.getSessionFactory().openSession();

        try {
            sc.beginTransaction();
            Criteria cr = sc.createCriteria(Portofolioforuser.class);
          cr.add(Restrictions.eq("category.categoryId", cat.getCategoryId()));
          cr.add(Restrictions.sqlRestriction("4=4 order by rand()"));
          portofolios = cr.list();
            sc.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }

        return (ArrayList<Portofolioforuser>) portofolios;    }
    
    public Users selectUser(int pId){
         Session sc = SessionCreation.getSessionFactory().openSession();
          Users u =new Users();
          Portofolioforuser portofolioforuser = new Portofolioforuser();
           System.out.println(pId);
          try {
             
            sc.beginTransaction();
            portofolioforuser = (Portofolioforuser) sc.get(Portofolioforuser.class, pId);
            u=portofolioforuser.getUsers();
            System.out.println(u.getUserId());
            sc.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }
        
        return u;
    }

}

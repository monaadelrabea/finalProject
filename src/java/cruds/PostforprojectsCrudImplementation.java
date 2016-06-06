/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cruds;

import crudsinterface.PostforprojectsCrudInterface;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import pojos.Postforprojects;
import seesioncreator.SessionCreation;

/**
 *
 * @author hassan
 */
public class PostforprojectsCrudImplementation implements PostforprojectsCrudInterface {

    @Override
    public boolean insert(Postforprojects postforprojects) {
boolean flag=true;
        Session sc = SessionCreation.getSessionFactory().openSession();

        try {
            sc.beginTransaction();
            sc.saveOrUpdate(postforprojects);
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
    public Postforprojects select(int id) {

        Session sc = SessionCreation.getSessionFactory().openSession();
        Postforprojects postforprojects = new Postforprojects();

        try {
            sc.beginTransaction();
            postforprojects = (Postforprojects) sc.get(Postforprojects.class, id);
            sc.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }

        return postforprojects;

    }

    @Override
    public boolean update(int id, Postforprojects postforprojects) {
boolean flag=true;
        Session sc = SessionCreation.getSessionFactory().openSession();

        try {
            sc.beginTransaction();
            Postforprojects postforprojects1 = (Postforprojects) sc.get(Postforprojects.class, id);
            postforprojects1.setPost(postforprojects.getPost());
            sc.update(postforprojects1);
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
boolean flag =true;
        Session sc = SessionCreation.getSessionFactory().openSession();

        try {
            sc.beginTransaction();
            Postforprojects postforprojects = (Postforprojects) sc.get(Postforprojects.class, id);
            sc.delete(postforprojects);
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
      public ArrayList<Object> projectsIds(int porId){
    List<Object> pIds=new ArrayList<>();
   Session sc = SessionCreation.getSessionFactory().openSession();
      Query m=sc.createQuery("select por from Porposa por left join fetch por.projectsforusers where porpId=?)");
       m.setInteger(0, porId);
       pIds = m.list();
        return (ArrayList<Object>) pIds;   
}
}

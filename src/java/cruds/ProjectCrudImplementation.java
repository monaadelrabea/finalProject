/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cruds;

import crudsinterface.ProjectCrudInterface;
import crudsinterface.UsersCrudInterface;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import pojos.Projectsforusers;
import pojos.Users;
import seesioncreator.SessionCreation;

/**
 *
 * @author m@pc
 */
public class ProjectCrudImplementation implements ProjectCrudInterface {

    @Override
    public ArrayList<Projectsforusers> selectProjects(int id) {
         List <Projectsforusers> projects = new ArrayList<>();
        Session session = SessionCreation.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Projectsforusers.class);
        criteria.add(Restrictions.eq("users.userId", id));
         criteria.add(Restrictions.sqlRestriction("1=1 order by rand()"));
        projects = criteria.list();
        return (ArrayList<Projectsforusers>) projects;
    }

    @Override
    public Projectsforusers selectProject(int id) {
        Session se = SessionCreation.getSessionFactory().openSession();
        Projectsforusers p =new Projectsforusers();
         try {
            se.beginTransaction();
            p = (Projectsforusers) se.get(Projectsforusers.class, id);
            se.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            se.close();
        }
   
        return p; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insertProject(Projectsforusers c) {
        boolean flag = true;
        Session se = SessionCreation.getSessionFactory().openSession();
        try {
            se.getTransaction().begin();
            se.saveOrUpdate(c);
            se.getTransaction().commit();
        } catch (HibernateException ex) {
            se.getTransaction().rollback();
            ex.printStackTrace();
            flag = false;
        } finally {
            se.close();
        }
        return flag;
    }

    @Override
    public boolean updateProject(Projectsforusers c, int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteProject(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Projectsforusers> selectLastInterd() {
          System.out.println("in crud mona");
          List <Projectsforusers> projects = new ArrayList<>();
        Session session = SessionCreation.getSessionFactory().openSession();
         int n=2;
        Criteria count = session.createCriteria(Projectsforusers.class);
        count.setProjection(Projections.rowCount());
        Long total = (Long) count.uniqueResult();
        Criteria criteria = session.createCriteria(Projectsforusers.class);
        criteria.setFirstResult((int) (total-n));
         criteria.add(Restrictions.sqlRestriction("1=1 order by rand()"));
        criteria.setMaxResults(n);
        projects = criteria.list();
        return (ArrayList<Projectsforusers>) projects;
    }

    @Override
    public ArrayList<Projectsforusers> selectBestProjects() {
         
         UsersCrudInterface crud = new UsersCrudImplementation();
         ArrayList<Users> usersAll= crud.selectMaxRateUsers();
          List <Projectsforusers> projects = new ArrayList<>();
           Session session = SessionCreation.getSessionFactory().openSession();
       for(int i=0;i<usersAll.size();i++){
         Criteria criteria = session.createCriteria(Projectsforusers.class);
        criteria.add(Restrictions.eq("users.userId", usersAll.get(i).getUserId()));
        projects.addAll(criteria.list()) ;    
    }
     return  (ArrayList<Projectsforusers>) projects;  
    }
}



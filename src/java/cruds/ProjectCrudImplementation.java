/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cruds;

import crudsinterface.ProjectCrudInterface;
import java.util.ArrayList;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import pojos.Projectsforusers;
import seesioncreator.SessionCreation;

/**
 *
 * @author m@pc
 */
public class ProjectCrudImplementation implements ProjectCrudInterface{

    @Override
    public ArrayList<Projectsforusers> selectProjects(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Projectsforusers selectProject(int id) {
        Session se = SessionCreation.getSessionFactory().openSession();
     se.beginTransaction();
    Projectsforusers p=(Projectsforusers) se.get(Projectsforusers.class, id);
    se.getTransaction().commit();
       se.close();
        return p; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertProject(Projectsforusers c) {
         Session se = SessionCreation.getSessionFactory().openSession();
        try{
       se.getTransaction().begin();
       se.saveOrUpdate(c);
       se.getTransaction().commit();
        }catch(HibernateException ex){
            se.getTransaction().rollback();
            ex.printStackTrace();
        }finally{
            se.close();
        }
    }
    
    @Override
    public void updateProject(Projectsforusers c, int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteProject(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

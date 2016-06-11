/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cruds;

import crudsinterface.TagsForProjectsInterface;
import java.util.ArrayList;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import pojos.Tagsofprojects;
import seesioncreator.SessionCreation;

/**
 *
 * @author m@pc
 */
public class TagsForProjectsImplementation implements TagsForProjectsInterface {
Session sc;
    public TagsForProjectsImplementation (){
         sc = SessionCreation.getSessionFactory().openSession();
    }
    @Override
    public ArrayList<Tagsofprojects> selectTagsOfProjects() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Tagsofprojects selectTagOfProjects(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insertTagsOfProjects(Tagsofprojects tg) {
        boolean flag = true;
    
        try {
            sc.getTransaction().begin();
            sc.saveOrUpdate(tg);
            sc.getTransaction().commit();
        } catch (HibernateException ex) {
            sc.getTransaction().rollback();
            ex.printStackTrace();
            flag = false;
        } finally {
            sc.close();
        }
        return flag;
    }

    @Override
    public boolean updateTagsOfProjects(Tagsofprojects tg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteTagsOfProjects(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cruds;

import crudsinterface.TagCrudInterface;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import pojos.Tags;
import pojos.Users;
import seesioncreator.SessionCreation;

/**
 *
 * @author m@pc
 */
public class TagCrudImplementation implements TagCrudInterface {

    @Override
    public ArrayList<Tags> selectTags() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Tags selectTag(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insertTag(Tags t) {
        boolean flag = true;
        Session se = SessionCreation.getSessionFactory().openSession();
        try {
            se.getTransaction().begin();
            se.saveOrUpdate(t);
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
    public boolean updateTag(Tags t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteTag(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Tags selectTag(String name) {

        Tags t = null;

        Session sc = SessionCreation.getSessionFactory().openSession();

        try {
            sc.beginTransaction();
            Criteria cr = sc.createCriteria(Users.class);
            cr.add(Restrictions.eq("tagDescription", name));
            List tags = cr.list();
            if (!tags.isEmpty()) {
                t = (Tags) tags.get(0);
            }
            else
            {
            
                t.setTagDescription(name);
                
            }
            sc.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }

        return t;

    }

}

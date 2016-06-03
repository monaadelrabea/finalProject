/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cruds;

import crudsinterface.CategoryCrudInterface;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import pojos.Category;
import pojos.Category;
import pojos.Users;
import seesioncreator.SessionCreation;

/**
 *
 * @author m@pc
 */
public class CategoryCrudImplementation implements CategoryCrudInterface{

    @Override
    public ArrayList<Category> selectCategorys() {
        List <Category> categories = new ArrayList<>();
 Session sc = SessionCreation.getSessionFactory().openSession();

        try {
            sc.beginTransaction();
            Criteria cr = sc.createCriteria(Category.class);
           categories = cr.list();
            sc.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }

        return (ArrayList<Category>) categories;    }

    @Override
    public Category selectCategory(int id) {
       Session se = SessionCreation.getSessionFactory().openSession();  
       se.getTransaction().begin();
       Category cat =(Category) se.get(Category.class, id);
       se.close();
        return cat;    
    }
    @Override
    public boolean insertCategoty(Category c) {
        boolean flag =true;
        Session se = SessionCreation.getSessionFactory().openSession();
        try{
       se.getTransaction().begin();
       se.save(c);
       se.getTransaction().commit();
        }catch(HibernateException ex){
            se.getTransaction().rollback();
            flag=false;
            ex.printStackTrace();
        }finally{
            se.close();
        }
        return flag;
    }

    @Override
    public boolean updateCategory(Category c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteCategory(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

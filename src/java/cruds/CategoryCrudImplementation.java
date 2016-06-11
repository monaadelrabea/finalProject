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
public class CategoryCrudImplementation implements CategoryCrudInterface {
 Session sc;
    public CategoryCrudImplementation  (){
         sc = SessionCreation.getSessionFactory().openSession();
    }
    @Override
    public ArrayList<Category> selectCategorys() {
        List<Category> categories = new ArrayList<>();
       

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

        return (ArrayList<Category>) categories;
    }

    @Override
    public Category selectCategory(int id) {
        //Session se = SessionCreation.getSessionFactory().openSession();
        sc.getTransaction().begin();
        Category cat = (Category) sc.get(Category.class, id);
        sc.close();
        return cat;
    }

    @Override
    public boolean insertCategoty(Category c) {
        boolean flag = true;
       
        try {
            sc.getTransaction().begin();
            sc.save(c);
            sc.getTransaction().commit();
        } catch (HibernateException ex) {
            sc.getTransaction().rollback();
            flag = false;
            ex.printStackTrace();
        } finally {
            sc.close();
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

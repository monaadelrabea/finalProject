/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cruds;

import crudsinterface.CategoryCrudInterface;
import java.util.ArrayList;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import pojos.Categorytable;
import seesioncreator.SessionCreation;

/**
 *
 * @author m@pc
 */
public class CategoryCrudImplementation implements CategoryCrudInterface{

    @Override
    public ArrayList<Categorytable> selectCategorys() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Categorytable selectCategory(int id) {
Session se = SessionCreation.getSessionFactory().openSession();  
       se.getTransaction().begin();
       Categorytable cat =(Categorytable) se.get(Categorytable.class, id);
       se.close();
        return cat;    
    }
    @Override
    public void insertCategoty(Categorytable c) {
        Session se = SessionCreation.getSessionFactory().openSession();
        try{
       se.getTransaction().begin();
       se.save(c);
       se.getTransaction().commit();
        }catch(HibernateException ex){
            se.getTransaction().rollback();
            ex.printStackTrace();
        }finally{
            se.close();
        }
    }

    @Override
    public void updateCategory(Categorytable c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteCategory(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

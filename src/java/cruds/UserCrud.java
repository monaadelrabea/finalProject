/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cruds;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import pojos.Users;
import seesioncreator.SessionCreation;

/**
 *
 * @author m@pc
 */
public class UserCrud {
    public static void InsertUser(Users u){
          Session se = SessionCreation.getSessionFactory().openSession();
        try{
       se.getTransaction().begin();
       se.saveOrUpdate(u);
       se.getTransaction().commit();
        }catch(HibernateException ex){
            se.getTransaction().rollback();
            ex.printStackTrace();
        }finally{
            se.close();
        }
    }
     public Users selectCategory(int id) {
Session se = SessionCreation.getSessionFactory().openSession();  
       se.getTransaction().begin();
       Users cat =(Users) se.get(Users.class, id);
       se.close();
        return cat;    
    }
    
}

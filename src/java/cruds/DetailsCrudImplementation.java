/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cruds;

import crudsinterface.DetailsCrudInterface;
import java.util.ArrayList;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import pojos.Details;
import seesioncreator.SessionCreation;

/**
 *
 * @author m@pc
 */
public class DetailsCrudImplementation implements DetailsCrudInterface{

    @Override
    public ArrayList<Details> selectDetails(int pId, int PrId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Details selectDetails(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertDetails(Details d) {
        Session se = SessionCreation.getSessionFactory().openSession();
        try{
       se.getTransaction().begin();
       se.saveOrUpdate(d);
       se.getTransaction().commit();
        }catch(HibernateException ex){
            se.getTransaction().rollback();
            ex.printStackTrace();
        }finally{
            se.close();
        }
    }
    
    @Override
    public void updateDetailsRate(Details d, int pId, int prId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateDetailsComment(Details d, int pId, int prId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateDetailsStatus(Details d, int pId, int prId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteDetails(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}

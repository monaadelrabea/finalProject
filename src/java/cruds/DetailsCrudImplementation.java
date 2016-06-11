/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cruds;

import crudsinterface.DetailsCrudInterface;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import pojos.Details;
import pojos.DetailsId;
import seesioncreator.SessionCreation;

/**
 *
 * @author m@pc
 */
public class DetailsCrudImplementation implements DetailsCrudInterface {

    Session sc;

    public DetailsCrudImplementation() {
        sc = SessionCreation.getSessionFactory().openSession();
    }

    @Override
    public ArrayList<Details> selectDetails(int pId, int PrId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Details selectDetails(DetailsId id) {
        List details = new ArrayList();
        try {
            sc.beginTransaction();
            Criteria cr = sc.createCriteria(Details.class);
            cr.add(Restrictions.eq("id", id));
            details = cr.list();
            sc.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }
        return ((Details) details.get(0));

    }

    @Override
    public boolean insertDetails(Details d) {
        boolean flag = true;
        try {
            System.out.println("hassan1");
            sc.getTransaction().begin();
            sc.saveOrUpdate(d);
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
    public boolean updateDetailsRate(Details d, int pId, int prId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateDetailsComment(Details d, int pId, int prId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateDetailsStatus(Details d, int pId, int prId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteDetails(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

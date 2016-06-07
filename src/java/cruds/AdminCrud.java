/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cruds;

import crudsinterface.AdminInterface;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import pojos.Admin;
import pojos.Users;
import seesioncreator.SessionCreation;

/**
 *
 * @author m@pc
 */
public class AdminCrud implements AdminInterface{

    @Override
    public Admin selectEP(String email, String password) {
        Session sc = SessionCreation.getSessionFactory().openSession();
        List admin =new ArrayList();
        try {
            sc.beginTransaction();
            Criteria cr = sc.createCriteria(Admin.class);
            cr.add(Restrictions.eq("adminUserName", email));
            cr.add(Restrictions.eq("adminPassword", password));
            admin = cr.list();
            sc.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }
        return ((Admin) admin.get(0));
    }
    
    }
    


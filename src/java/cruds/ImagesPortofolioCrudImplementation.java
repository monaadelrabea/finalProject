/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cruds;

import crudsinterface.ImagesProjectCrudInterface;
import crudsinterface.PortofolioiamgesCrudInterface;
import java.util.ArrayList;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import pojos.Portofolioimages;
import pojos.Projectsimages;
import seesioncreator.SessionCreation;

/**
 *
 * @author m@pc
 */
public class ImagesPortofolioCrudImplementation implements PortofolioiamgesCrudInterface{

    @Override
      public boolean insertImagePortofolio(Portofolioimages img) {
boolean flag =true;
        Session sc = SessionCreation.getSessionFactory().openSession();

        try {
            sc.beginTransaction();
            sc.saveOrUpdate(img);
            sc.getTransaction().commit();
        } catch (HibernateException e) {
            sc.getTransaction().rollback();
            e.printStackTrace();
            flag=false;
        } finally {
            sc.close();
        }
return flag;
    }

    @Override
    public Portofolioimages select(int id) {

        Session sc = SessionCreation.getSessionFactory().openSession();
     Portofolioimages portofolioiamges = new Portofolioimages();

        try {
            sc.beginTransaction();
            portofolioiamges = (Portofolioimages) sc.get(Portofolioimages.class, id);
            sc.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }

        return portofolioiamges;

    }

    @Override
    public boolean update(int id, Portofolioimages p) {
boolean flag=true;
        Session sc = SessionCreation.getSessionFactory().openSession();

        try {
            sc.beginTransaction();
            Portofolioimages portofolioiamges = (Portofolioimages) sc.get(Portofolioimages.class, id);
            portofolioiamges.setPortfolioImageUrl(p.getPortfolioImageUrl());
            sc.update(portofolioiamges);
            sc.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            flag=false;
        } finally {
            sc.close();
        }
return flag;
    }

    @Override
    public boolean delete(int id) {
boolean flag=true;
        Session sc = SessionCreation.getSessionFactory().openSession();

        try {
            sc.beginTransaction();
            Portofolioimages portofolioiamges = (Portofolioimages) sc.get(Portofolioimages.class, id);
            sc.delete(portofolioiamges);
            sc.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            flag =false;
        } finally {
            sc.close();
        }
return flag;
    }

    @Override
    public ArrayList<Portofolioimages> selectProjectsimages() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}

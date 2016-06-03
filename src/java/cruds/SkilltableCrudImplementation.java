/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cruds;

import crudsinterface.SkilltableCrudInterface;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import pojos.Skilltable;
import seesioncreator.SessionCreation;

/**
 *
 * @author hassan
 */
public class SkilltableCrudImplementation implements SkilltableCrudInterface {

    @Override
    public boolean insert(Skilltable s) {
boolean flag=true;
        Session sc = SessionCreation.getSessionFactory().openSession();

        try {
            sc.beginTransaction();
            sc.saveOrUpdate(s);
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
    public Skilltable select(int id) {

        Session sc = SessionCreation.getSessionFactory().openSession();
        Skilltable skilltable = new Skilltable();

        try {
            sc.beginTransaction();
            skilltable = (Skilltable) sc.get(Skilltable.class, id);
            sc.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }

        return skilltable;

    }

    @Override
    public boolean update(Integer id, Skilltable s) {
       boolean flag=true;
        Session sc = SessionCreation.getSessionFactory().openSession();

        try {
            sc.beginTransaction();
            Skilltable skilltable = (Skilltable) sc.get(Skilltable.class, id);
            skilltable.setSkillName(s.getSkillName());
            sc.update(skilltable);
            sc.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            flag = false;
        } finally {
            sc.close();
        }
return flag;
    }

    @Override
    public boolean delete(Integer id) {
boolean flag=true;
        Session sc = SessionCreation.getSessionFactory().openSession();

        try {
            sc.beginTransaction();
            Skilltable skilltable = (Skilltable) sc.get(Skilltable.class, id);
            sc.delete(skilltable);
            sc.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            flag=false;
        } finally {
            sc.close();
        }
return flag;
    }

}

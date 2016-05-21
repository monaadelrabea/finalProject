/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cruds;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import pojos.Skilltable;

/**
 *
 * @author hassan
 */
public class SkilltableCrud implements SkilltableCrudInt {

    @Override
    public void insert(Skilltable s) {

        Session sc = sessioncreator.SessionCreation.getSessionFactory().openSession();

        try {
            sc.beginTransaction();
            sc.saveOrUpdate(s);
            sc.getTransaction().commit();
        } catch (HibernateException e) {
            sc.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            sc.close();
        }

    }

    @Override
    public Skilltable select(Integer id) {

        Session sc = sessioncreator.SessionCreation.getSessionFactory().openSession();
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
    public void update(Integer id, Skilltable s) {

        Session sc = sessioncreator.SessionCreation.getSessionFactory().openSession();

        try {
            sc.beginTransaction();
            Skilltable skilltable = (Skilltable) sc.get(Skilltable.class, id);
            skilltable.setSkillName(s.getSkillName());
            sc.update(skilltable);
            sc.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }

    }

    @Override
    public void delete(Integer id) {

        Session sc = sessioncreator.SessionCreation.getSessionFactory().openSession();

        try {
            sc.beginTransaction();
            Skilltable skilltable = (Skilltable) sc.get(Skilltable.class, id);
            sc.delete(skilltable);
            sc.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }

    }

}

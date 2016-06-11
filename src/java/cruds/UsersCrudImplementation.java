/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cruds;

import crudsinterface.UsersCrudInterface;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import pojos.Users;
import seesioncreator.SessionCreation;

/**
 *
 * @author hassan
 */
public class UsersCrudImplementation implements UsersCrudInterface {

    Session sc;

    public UsersCrudImplementation() {
        sc = SessionCreation.getSessionFactory().openSession();
    }

    @Override
    public boolean insert(Users u) {
        boolean flag = true;
        Session sc = SessionCreation.getSessionFactory().openSession();

        try {
            sc.beginTransaction();
            sc.saveOrUpdate(u);
            sc.getTransaction().commit();
        } catch (HibernateException e) {
            sc.getTransaction().rollback();
            e.printStackTrace();
            flag = false;
        } finally {
            sc.close();
        }
        return flag;
    }

    @Override
    public Users selectEP(String email, String password) {
        Session sc = SessionCreation.getSessionFactory().openSession();

        List<Users> users = new ArrayList();
        try {
            sc.beginTransaction();
            Criteria cr = sc.createCriteria(Users.class);
            cr.add(Restrictions.eq("userEmail", email));
            cr.add(Restrictions.eq("password", password));
            users = cr.list();
            sc.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }
        return ((Users) users.get(0));
    }

    @Override
    public Object selectUserHQL(int id) {

        Session sc = SessionCreation.getSessionFactory().openSession();
        Query query = sc.createQuery("select pro from Projectsforusers pro left join fetch pro.users where projectId=?");
        query.setInteger(0, id);
        Object users = query.list().get(0);
        return users;

    }

    @Override
    public ArrayList<Users> selectE(String email) {
        Session sc = SessionCreation.getSessionFactory().openSession();

        List<Users> users = new ArrayList();
        try {
            sc.beginTransaction();
            Criteria cr = sc.createCriteria(Users.class);
            cr.add(Restrictions.eq("userEmail", email));
            users = cr.list();
            sc.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }
        return (ArrayList<Users>) users;
    }

    @Override
    public Users select(int id) {

        Session sc = SessionCreation.getSessionFactory().openSession();
        Users users = new Users();

        try {
            sc.beginTransaction();
            users = (Users) sc.get(Users.class, id);
            sc.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }

        return users;

    }

    @Override
    public boolean update(Users u) {
        boolean flag = true;
        try {
            sc.beginTransaction();
            Users users = (Users) sc.get(Users.class, u.getUserId());
            users.setUserEmail(u.getUserEmail());
            users.setUserImageUrl(u.getUserImageUrl());
            users.setGender(u.isGender());
            users.setUserName(u.getUserName());
            users.setGovernorate(u.getGovernorate());
            users.setCity(u.getCity());
            users.setSummery(u.getSummery());
            u.setProfessinalTiltle(u.getProfessinalTiltle());
            u.setIdentefire(u.getIdentefire());
            users.setPhoneofusers(u.getPhoneofusers());
            sc.update(users);
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
    public boolean delete(int id) {
        boolean flag = true;

        try {
            sc.beginTransaction();
            Users users = (Users) sc.get(Users.class, id);
            sc.delete(users);
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
    public ArrayList<Users> selectMaxRateUsers() {
        ArrayList<Integer> maxRate = maxValue();
        List<Users> maxRateOfUsers = new ArrayList<>();
        Criteria criteria = sc.createCriteria(Users.class);
        System.out.println(maxRate.get(0));
        criteria.add(Restrictions.in("rate", maxRate));
        criteria.add(Restrictions.sqlRestriction("1=1 order by rand()"));
        criteria.setMaxResults(3);
        System.out.println(maxRate.get(1));
        maxRateOfUsers = criteria.list();
        return (ArrayList<Users>) maxRateOfUsers;
    }

    @Override
    public ArrayList<Users> selectAllUsers() {
        ArrayList<Users> maxRate = new ArrayList<>();
        
        Criteria criteria = sc.createCriteria(Users.class);
        maxRate = (ArrayList<Users>) criteria.list();
        return maxRate;
    }

    public ArrayList<Integer> maxValue() {
        ArrayList<Users> usersAll = selectAllUsers();
        ArrayList<Integer> users = new ArrayList<>();
        int rate1 = 0;
        int rate2 = 0;
        int max = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        System.out.println(max);
        for (int i = 0; i < usersAll.size(); i++) {
            if (usersAll.get(i).getRate() > max) {
                max = usersAll.get(i).getRate();
                users.add(usersAll.get(i).getRate());
                rate1 = usersAll.get(i).getRate();
                 System.out.println(rate1);
            }
            if (usersAll.get(i).getRate() > max2 && usersAll.get(i).getRate() < rate1) {
                max2 = usersAll.get(i).getRate();
                users.add(usersAll.get(i).getRate());
                rate2 = usersAll.get(i).getRate();
                 System.out.println(rate2);
            }
        }
        System.out.println(rate1);
        System.out.println(rate2);
        return users;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cruds;

import crudsinterface.SkillCrudInterface;
import java.util.ArrayList;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import pojos.Skilltable;
import seesioncreator.SessionCreation;

/**
 *
 * @author m@pc
 */
public class SkillCrudImplementation  implements SkillCrudInterface{

    @Override
    public ArrayList<Skilltable> selectSkills() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Skilltable selectSkill(int id) {
Session se = SessionCreation.getSessionFactory().openSession();  
       se.getTransaction().begin();
        Skilltable skill =( Skilltable) se.get( Skilltable.class, id);
       se.close();
        return  skill;   
    }

    @Override
    public boolean insertSkill(Skilltable s) {
        boolean flag=true;
     Session se = SessionCreation.getSessionFactory().openSession();
        try{
       se.getTransaction().begin();
       se.saveOrUpdate(s);
       se.getTransaction().commit();
        }catch(HibernateException ex){
            se.getTransaction().rollback();
            ex.printStackTrace();
            flag=false;
        }finally{
            se.close();
        }
        return flag;
    }
    

    @Override
    public boolean updateSkill(Skilltable s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteSkill(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

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
    public void insertSkill(Skilltable s) {
     Session se = SessionCreation.getSessionFactory().openSession();
        try{
       se.getTransaction().begin();
       se.saveOrUpdate(s);
       se.getTransaction().commit();
        }catch(HibernateException ex){
            se.getTransaction().rollback();
            ex.printStackTrace();
        }finally{
            se.close();
        }
    }
    

    @Override
    public void updateSkill(Skilltable s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteSkill(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

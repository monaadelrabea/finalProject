/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudsinterface;

import java.util.ArrayList;
import pojos.Skilltable;



/**
 *
 * @author m@pc
 */
public interface SkillCrudInterface {
    
   public ArrayList<Skilltable>  selectSkills();
   public Skilltable selectSkill(int id);
   public void insertSkill(Skilltable s);
   public void updateSkill(Skilltable s);
   public void deleteSkill(int id);
     
}

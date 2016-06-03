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
   public boolean insertSkill(Skilltable s);
   public boolean updateSkill(Skilltable s);
   public boolean deleteSkill(int id);
     
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudsinterface;

import java.util.ArrayList;
import pojos.Projectsforusers;

/**
 *
 * @author m@pc
 */
public interface ProjectCrudInterface {
   public ArrayList<Projectsforusers> selectProjects(int id);
   public Projectsforusers selectProject(int id);
   public void insertProject(Projectsforusers  c);
   public void updateProject(Projectsforusers c,int id);
   public void deleteProject(int id);
    
}

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

    public boolean insertProject(Projectsforusers c);

    public boolean updateProject(Projectsforusers c, int id);

    public boolean deleteProject(int id);
    
    public ArrayList<Projectsforusers> selectLastInterd();
    
   public ArrayList<Projectsforusers> selectBestProjects();
   
     public ArrayList<Projectsforusers> selectAllProjects();

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudsinterface;

import java.util.ArrayList;
import pojos.Tagsofprojects;

/**
 *
 * @author m@pc
 */
public interface TagsForProjectsInterface { 
   public ArrayList<Tagsofprojects> selectTagsOfProjects();
   public Tagsofprojects selectTagOfProjects(int id);
   public void insertTagsOfProjects(Tagsofprojects tg);
   public void updateTagsOfProjects(Tagsofprojects tg);
   public void deleteTagsOfProjects(int id);
}

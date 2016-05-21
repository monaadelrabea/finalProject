/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudsinterface;

import java.util.ArrayList;
import pojos.Categorytable;
import pojos.Projectsimages;

/**
 *
 * @author m@pc
 */
public interface ImagesCrudInterface {
 public ArrayList<Projectsimages> selectProjectsimages();
   public Projectsimages selectProjectsimage(int id);
   public void insertImageProject(Projectsimages img);
   public void updateImageProject(Projectsimages img);
   public void deleteImageProject(int id);   
}

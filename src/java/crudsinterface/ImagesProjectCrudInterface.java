/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudsinterface;

import java.util.ArrayList;
import pojos.Projectsimages;

/**
 *
 * @author m@pc
 */
public interface ImagesProjectCrudInterface {

    public ArrayList<Projectsimages> selectProjectsimages();

    public Projectsimages selectProjectsimage(int id);

    public Projectsimages selectProjectsimage(String imgName);

    public boolean insertImageProject(Projectsimages img);

    public boolean updateImageProject(Projectsimages img);

    public boolean deleteImageProject(int id);
}

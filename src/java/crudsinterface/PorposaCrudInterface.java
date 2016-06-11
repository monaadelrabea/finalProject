/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudsinterface;

import java.util.ArrayList;
import pojos.Porposa;

/**
 *
 * @author hassan
 */
public interface PorposaCrudInterface {

    public boolean insert(Porposa porposa);

    public Porposa select(Integer id);

    public boolean update(Integer id, Porposa porposa);

    public boolean delete(Integer id);
    
    public ArrayList<Object> projectsIds(int porId);
    
      public ArrayList<Porposa> selectPorposeHQL(int id);
      
      public Object user(int porId);

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudsinterface;

import java.util.ArrayList;
import pojos.Tagstable;

/**
 *
 * @author m@pc
 */
public interface TagCrudInterface {
   public ArrayList<Tagstable>  selectTags();
   public Tagstable selectTag(int id);
   public void insertTag(Tagstable t);
   public void updateTag(Tagstable t);
   public void deleteTag(int id);
     
}

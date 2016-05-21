/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudsinterface;

import java.util.ArrayList;
import pojos.Categorytable;

/**
 *
 * @author m@pc
 */
public interface CategoryCrudInterface {
   public ArrayList<Categorytable> selectCategorys();
   public Categorytable selectCategory(int id);
   public void insertCategoty(Categorytable c);
   public void updateCategory(Categorytable c);
   public void deleteCategory(int id);
}

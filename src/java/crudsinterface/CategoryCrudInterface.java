/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudsinterface;

import java.util.ArrayList;
import pojos.Category;

/**
 *
 * @author m@pc
 */
public interface CategoryCrudInterface {
   public ArrayList<Category> selectCategorys();
   public Category selectCategory(int id);
   public boolean insertCategoty(Category c);
   public boolean updateCategory(Category c);
   public boolean deleteCategory(int id);
}

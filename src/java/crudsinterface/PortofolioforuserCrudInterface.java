/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudsinterface;

import java.util.ArrayList;
import pojos.Category;
import pojos.Portofolioforuser;
import pojos.Portofolioimages;
import pojos.Users;

/**
 *
 * @author hassan
 */
public interface PortofolioforuserCrudInterface {
  
    
    public boolean insert(Portofolioforuser portofolioforuser);

    public Portofolioforuser select(int id);

    public boolean update(int id, Portofolioforuser portofolioforuser);

    public boolean delete(int id);
  public ArrayList<Portofolioforuser> selectPortofolios(Category cat);
   public Users selectUser(int pId);
   
   
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cruds;

import pojos.Portofolioforuser;

/**
 *
 * @author hassan
 */
public interface PortofolioforuserCrudInt {
    
    public void insert(Portofolioforuser portofolioforuser);

    public Portofolioforuser select(Integer id);

    public void update(Integer id, Portofolioforuser portofolioforuser);

    public void delete(Integer id);

    
}

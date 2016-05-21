/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cruds;

import pojos.Portofolioiamges;

/**
 *
 * @author hassan
 */
public interface PortofolioiamgesCrudInt {
    
    public void insert(Portofolioiamges p);

    public Portofolioiamges select(Integer id);

    public void update(Integer id, Portofolioiamges p);

    public void delete(Integer id);
    
}

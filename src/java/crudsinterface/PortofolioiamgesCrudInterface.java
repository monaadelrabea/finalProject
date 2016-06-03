/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudsinterface;

import pojos.Portofolioimages;

/**
 *
 * @author hassan
 */
public interface PortofolioiamgesCrudInterface {
    
    public boolean insert(Portofolioimages p);

    public Portofolioimages select(int id);

    public boolean update(int id, Portofolioimages p);

    public boolean delete(int id);
    
}

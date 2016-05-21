/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslayer.businesslogic;

import pojos.Portofolioforuser;
import pojos.Users;

/**
 *
 * @author hassan
 */
public interface PortofolioforuserDelegationInt {

    public void delegateInsert(Portofolioforuser portofolioforuser);

    public Portofolioforuser delegateSelect(Integer id);

    public void delegateUpdate(Integer id, Portofolioforuser portofolioforuser);

    public void delegateDelete(Integer id);

}

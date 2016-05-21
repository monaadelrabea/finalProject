/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslayer.businesslogic;

import pojos.Portofolioiamges;

/**
 *
 * @author hassan
 */
public interface PortofolioiamgesDelegationInt {

    public void delegateInsert(Portofolioiamges p);

    public Portofolioiamges delegateSelect(Integer id);

    public void delegateUpdate(Integer id, Portofolioiamges p);

    public void delegateDelete(Integer id);

}

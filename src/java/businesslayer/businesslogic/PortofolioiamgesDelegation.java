/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslayer.businesslogic;

import businesslayer.businesslogicinterface.PortofolioiamgesDelegationInt;
import cruds.PortofolioiamgesCrudImplementation;
import crudsinterface.PortofolioiamgesCrudInterface;
import pojos.Portofolioimages;

/**
 *
 * @author hassan
 */
public class PortofolioiamgesDelegation implements PortofolioiamgesDelegationInt {

    @Override
    public void delegateInsert(Portofolioimages p) {

        PortofolioiamgesCrudInterface crud = new PortofolioiamgesCrudImplementation();
        crud.insert(p);

    }

    @Override
    public Portofolioimages delegateSelect(Integer id) {

        PortofolioiamgesCrudInterface crud = new PortofolioiamgesCrudImplementation();
        return crud.select(id);

    }

    @Override
    public void delegateUpdate(Integer id, Portofolioimages p) {

        PortofolioiamgesCrudInterface crud = new PortofolioiamgesCrudImplementation();
        crud.update(id, p);

    }

    @Override
    public void delegateDelete(Integer id) {

        PortofolioiamgesCrudInterface crud = new PortofolioiamgesCrudImplementation();
        crud.delete(id);

    }

}

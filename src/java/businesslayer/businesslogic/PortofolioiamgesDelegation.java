/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslayer.businesslogic;

import cruds.PortofolioiamgesCrud;
import cruds.PortofolioiamgesCrudInt;
import pojos.Portofolioiamges;

/**
 *
 * @author hassan
 */
public class PortofolioiamgesDelegation implements PortofolioiamgesDelegationInt {

    @Override
    public void delegateInsert(Portofolioiamges p) {

        PortofolioiamgesCrudInt crud = new PortofolioiamgesCrud();
        crud.insert(p);

    }

    @Override
    public Portofolioiamges delegateSelect(Integer id) {

        PortofolioiamgesCrudInt crud = new PortofolioiamgesCrud();
        return crud.select(id);

    }

    @Override
    public void delegateUpdate(Integer id, Portofolioiamges p) {

        PortofolioiamgesCrudInt crud = new PortofolioiamgesCrud();
        crud.update(id, p);

    }

    @Override
    public void delegateDelete(Integer id) {

        PortofolioiamgesCrudInt crud = new PortofolioiamgesCrud();
        crud.delete(id);

    }

}

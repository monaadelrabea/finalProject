/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslayer.businesslogic;

import cruds.PortofolioforuserCrud;
import cruds.PortofolioforuserCrudInt;
import pojos.Portofolioforuser;

/**
 *
 * @author hassan
 */
public class PortofolioforuserDelegation implements PortofolioforuserDelegationInt{

    @Override
    public void delegateInsert(Portofolioforuser portofolioforuser) {

        PortofolioforuserCrudInt crud = new PortofolioforuserCrud();
        crud.insert(portofolioforuser);

    }

    @Override
    public Portofolioforuser delegateSelect(Integer id) {

        PortofolioforuserCrudInt crud = new PortofolioforuserCrud();
        return crud.select(id);

    }

    @Override
    public void delegateUpdate(Integer id, Portofolioforuser portofolioforuser) {

        PortofolioforuserCrudInt crud = new PortofolioforuserCrud();
        crud.update(id, portofolioforuser);

    }

    @Override
    public void delegateDelete(Integer id) {

        PortofolioforuserCrudInt crud = new PortofolioforuserCrud();
        crud.delete(id);

    }

}

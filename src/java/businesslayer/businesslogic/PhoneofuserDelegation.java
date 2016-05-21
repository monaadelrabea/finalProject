/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslayer.businesslogic;

import cruds.CrudInterface;
import cruds.PhoneofuserCrud;
import cruds.PhoneofuserCrudInt;
import pojos.Phoneofuser;

/**
 *
 * @author hassan
 */
public class PhoneofuserDelegation implements PhoneofuserDelegationInt {

    @Override
    public void delegateInsert(Phoneofuser p) {

        PhoneofuserCrudInt crud = new PhoneofuserCrud();
        crud.insert(p);

    }

    @Override
    public Phoneofuser delegateSelect(Integer id) {

        PhoneofuserCrudInt crud = new PhoneofuserCrud();
        return (Phoneofuser) crud.select(id);

    }

    @Override
    public void delegateUpdate(Integer id, Phoneofuser p) {

        PhoneofuserCrudInt crud = new PhoneofuserCrud();
        crud.update(id, p);

    }

    @Override
    public void delegateDelete(Integer id) {

        PhoneofuserCrudInt crud = new PhoneofuserCrud();
        crud.delete(id);

    }

}

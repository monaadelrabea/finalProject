/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslayer.businesslogic;

import cruds.CrudInterface;
import cruds.SkilltableCrud;
import cruds.SkilltableCrudInt;
import cruds.UsersCrud;
import pojos.Skilltable;

/**
 *
 * @author hassan
 */
public class SkilltableDelegation implements SkilltableDelegationInt {

    @Override
    public void delegateInsert(Skilltable skilltable) {

        SkilltableCrudInt crud = new SkilltableCrud();
        crud.insert(skilltable);

    }

    @Override
    public Skilltable delegateSelect(Integer id) {

        SkilltableCrudInt crud = new SkilltableCrud();
        return crud.select(id);

    }

    @Override
    public void delegateUpdate(Integer id, Skilltable skilltable) {

        SkilltableCrudInt crud = new SkilltableCrud();
        crud.update(id, skilltable);

    }

    @Override
    public void delegateDelete(Integer id) {

        SkilltableCrudInt crud = new SkilltableCrud();
        crud.delete(id);

    }

}

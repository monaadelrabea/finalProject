/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslayer.businesslogic;

import cruds.UsersCrud;
import pojos.Users;
import cruds.UsersCrudInt;

/**
 *
 * @author hassan
 */
public class UsersDelegation implements UsersDelegationInt {

    @Override
    public void delegateInsert(Users u) {

        UsersCrudInt crud = new UsersCrud();
        crud.insert(u);

    }

    @Override
    public Users delegateSelect(Integer id) {

        UsersCrudInt crud = new UsersCrud();
        return crud.select(id);

    }

    @Override
    public void delegateUpdate(Integer id, Users u) {

        UsersCrudInt crud = new UsersCrud();
        crud.update(id, u);

    }

    @Override
    public void delegateDelete(Integer id) {

        UsersCrudInt crud = new UsersCrud();
        crud.delete(id);

    }

}

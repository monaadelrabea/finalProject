/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslayer.businesslogic;

import cruds.ReplyingCrud;
import cruds.ReplyingCrudInt;
import pojos.Replying;

/**
 *
 * @author hassan
 */
public class ReplyingDelegation implements ReplyingDelegationInt {

    @Override
    public void delegateInsert(Replying replying) {

        ReplyingCrudInt crud = new ReplyingCrud();
        crud.insert(replying);

    }

    @Override
    public Replying delegateSelect(Integer id) {

        ReplyingCrudInt crud = new ReplyingCrud();
        return crud.select(id);

    }

    @Override
    public void delegateUpdate(Integer id, Replying replying) {

        ReplyingCrudInt crud = new ReplyingCrud();
        crud.update(id, replying);

    }

    @Override
    public void delegateDelete(Integer id) {

        ReplyingCrudInt crud = new ReplyingCrud();
        crud.delete(id);

    }

}

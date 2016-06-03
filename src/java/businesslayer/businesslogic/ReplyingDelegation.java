/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslayer.businesslogic;

import businesslayer.businesslogicinterface.ReplyingDelegationInt;
import cruds.ReplyingCrudImplementation;
import crudsinterface.ReplyingCrudInterface;
import pojos.Comments;

/**
 *
 * @author hassan
 */
public class ReplyingDelegation implements ReplyingDelegationInt {

    @Override
    public void delegateInsert(Comments replying) {

        ReplyingCrudInterface crud = new ReplyingCrudImplementation();
        crud.insert(replying);

    }

    @Override
    public Comments delegateSelect(Integer id) {

        ReplyingCrudInterface crud = new ReplyingCrudImplementation();
        return crud.select(id);

    }

    @Override
    public void delegateUpdate(Integer id, Comments replying) {

        ReplyingCrudInterface crud = new ReplyingCrudImplementation();
        crud.update(id, replying);

    }

    @Override
    public void delegateDelete(Integer id) {

        ReplyingCrudInterface crud = new ReplyingCrudImplementation();
        crud.delete(id);

    }

}

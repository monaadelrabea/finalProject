/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslayer.businesslogicinterface;

import pojos.Comments;

/**
 *
 * @author hassan
 */
public interface ReplyingDelegationInt {

    public void delegateInsert(Comments replying);

    public Comments delegateSelect(Integer id);

    public void delegateUpdate(Integer id, Comments replying);

    public void delegateDelete(Integer id);

}

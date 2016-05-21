/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslayer.businesslogic;

import pojos.Replying;

/**
 *
 * @author hassan
 */
public interface ReplyingDelegationInt {

    public void delegateInsert(Replying replying);

    public Replying delegateSelect(Integer id);

    public void delegateUpdate(Integer id, Replying replying);

    public void delegateDelete(Integer id);

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslayer.businesslogic;

import pojos.Users;

/**
 *
 * @author hassan
 */
public interface UsersDelegationInt {

    public void delegateInsert(Users u);

    public Users delegateSelect(Integer id);

    public void delegateUpdate(Integer id, Users u);

    public void delegateDelete(Integer id);

}

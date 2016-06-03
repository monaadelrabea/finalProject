/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslayer.businesslogicinterface;

import pojos.Postforprojects;

/**
 *
 * @author hassan
 */
public interface PostforprojectsDelegationInt {

    public void delegateInsert(Postforprojects postforprojects);

    public Postforprojects delegateSelect(Integer id);

    public void delegateUpdate(Integer id, Postforprojects postforprojects);

    public void delegateDelete(Integer id);

}

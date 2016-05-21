/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslayer.businesslogic;

import cruds.PostforprojectsCrud;
import cruds.PostforprojectsCrudInt;
import pojos.Postforprojects;

/**
 *
 * @author hassan
 */
public class PostforprojectsDelegation implements PostforprojectsDelegationInt {

    @Override
    public void delegateInsert(Postforprojects postforprojects) {

        PostforprojectsCrudInt crud = new PostforprojectsCrud();
        crud.insert(postforprojects);

    }

    @Override
    public Postforprojects delegateSelect(Integer id) {

        PostforprojectsCrudInt crud = new PostforprojectsCrud();
        return crud.select(id);

    }

    @Override
    public void delegateUpdate(Integer id, Postforprojects postforprojects) {

        PostforprojectsCrudInt crud = new PostforprojectsCrud();
        crud.update(id, postforprojects);

    }

    @Override
    public void delegateDelete(Integer id) {

        PostforprojectsCrudInt crud = new PostforprojectsCrud();
        crud.delete(id);

    }

}

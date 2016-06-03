/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslayer.businesslogic;

import businesslayer.businesslogicinterface.PostforprojectsDelegationInt;
import cruds.PostforprojectsCrudImplementation;
import crudsinterface.PostforprojectsCrudInterface;
import pojos.Postforprojects;

/**
 *
 * @author hassan
 */
public class PostforprojectsDelegation implements PostforprojectsDelegationInt {

    @Override
    public void delegateInsert(Postforprojects postforprojects) {

        PostforprojectsCrudInterface crud = new PostforprojectsCrudImplementation();
        crud.insert(postforprojects);

    }

    @Override
    public Postforprojects delegateSelect(Integer id) {

        PostforprojectsCrudInterface crud = new PostforprojectsCrudImplementation();
        return crud.select(id);

    }

    @Override
    public void delegateUpdate(Integer id, Postforprojects postforprojects) {

        PostforprojectsCrudInterface crud = new PostforprojectsCrudImplementation();
        crud.update(id, postforprojects);

    }

    @Override
    public void delegateDelete(Integer id) {

        PostforprojectsCrudInterface crud = new PostforprojectsCrudImplementation();
        crud.delete(id);

    }

}

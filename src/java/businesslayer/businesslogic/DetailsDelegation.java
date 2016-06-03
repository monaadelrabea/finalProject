/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslayer.businesslogic;

import businesslayer.businesslogicinterface.DetailsDelegationInt;
import cruds.DetailsCrudImplementation;
import crudsinterface.DetailsCrudInterface;
import java.util.ArrayList;
import pojos.Details;

/**
 *
 * @author m@pc
 */
public class DetailsDelegation  implements  DetailsDelegationInt{

    @Override
    public ArrayList<Details> selectDetails(int pId, int PrId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delegateInsert(Details dt) {
 DetailsCrudInterface d;
     d =  new DetailsCrudImplementation();
     d.insertDetails(dt);
    }

    @Override
    public Details delegateSelect(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delegateUpdate(int id, Details d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delegateDelete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
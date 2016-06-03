/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslayer.businesslogicinterface;

import java.util.ArrayList;
import pojos.Details;

/**
 *
 * @author m@pc
 */
public interface ImagePortofolioDelegationInterface {
    public ArrayList<Details> selectDetails(int pId, int PrId) ;
      
     public void delegateInsert(Details d);

    public Details delegateSelect(int id);

    public void delegateUpdate(int id, Details d);

    public void delegateDelete(int id);
}

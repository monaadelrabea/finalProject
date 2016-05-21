/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudsinterface;

import java.util.ArrayList;
import pojos.Details;

/**
 *
 * @author m@pc
 */
public interface DetailsCrudInterface {
   public ArrayList<Details> selectDetails(int pId,int PrId);
   public Details selectDetails(int id);
   public void insertDetails(Details d);
   public void updateDetailsRate(Details d,int pId, int prId );
   public void updateDetailsComment(Details d,int pId, int prId);
   public void updateDetailsStatus(Details d,int pId, int prId);
   public void deleteDetails(int id);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslayer.businesslogic;

import businesslayer.businesslogicinterface.PortofolioforuserDelegationInt;
import cruds.PortofolioforuserCrudImplementation;
import crudsinterface.PortofolioforuserCrudInterface;
import java.util.ArrayList;
import java.util.Random;
import pojos.Category;
import pojos.Portofolioforuser;
import pojos.Users;

/**
 *
 * @author hassan
 */
public class PortofolioforuserDelegation implements PortofolioforuserDelegationInt{

    @Override
    public void delegateInsert(Portofolioforuser portofolioforuser) {

        PortofolioforuserCrudInterface crud = new PortofolioforuserCrudImplementation();
        crud.insert(portofolioforuser);

    }

    @Override
    public Portofolioforuser delegateSelect(Integer id) {

        PortofolioforuserCrudInterface crud = new PortofolioforuserCrudImplementation();
        return crud.select(id);

    }

    @Override
    public void delegateUpdate(Integer id, Portofolioforuser portofolioforuser) {

        PortofolioforuserCrudInterface crud = new PortofolioforuserCrudImplementation();
        crud.update(id, portofolioforuser);

    }

    @Override
    public void delegateDelete(Integer id) {

        PortofolioforuserCrudInterface crud = new PortofolioforuserCrudImplementation();
        crud.delete(id);

    }
    
    
    
    
    @Override
    public ArrayList<Portofolioforuser> selectPortofolios(Category cat) {
        PortofolioforuserCrudInterface crud = new PortofolioforuserCrudImplementation();
        ArrayList<Portofolioforuser> portofolios = new ArrayList<>();
        portofolios=crud.selectPortofolios(cat);
        return portofolios;
    }
    
    
    
    
//     public static ArrayList<Portofolioforuser> getRandom(ArrayList<Portofolioforuser> array) {
//         ArrayList<Portofolioforuser> por= new ArrayList<Portofolioforuser>();
//        for(int i=0;i<array.size();i++){
//           Portofolioforuser catt =new Portofolioforuser();
//            catt.setPortofolioId(new Random().nextInt(array.get(i).getPortofolioId()));
//            catt.setUsers(array.get(i).getUsers());
//            catt.setPortofolioDescription(array.get(i).getPortofolioDescription());
//            catt.setPortofolioimageses(array.get(i).getPortofolioimageses());
//            
//           por.add(catt);
//        }
//    return por;
//           
//    }  

    @Override
    public Users selectUser(int pId) {
 PortofolioforuserCrudInterface crud = new PortofolioforuserCrudImplementation();
    return    crud.selectUser(pId);    }

}

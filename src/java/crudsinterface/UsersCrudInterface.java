/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudsinterface;

import java.util.ArrayList;
import pojos.Users;

/**
 *
 * @author hassan
 */
public interface UsersCrudInterface {

    public boolean insert(Users u);

    public Users select(int id);
    
    public Users selectEP(String email, String password);
    
    public boolean update(int id, Users u);

    public boolean delete(int id);
    
    public ArrayList<Users> selectMaxRateUsers();
    
    public ArrayList<Users> selectAllUsers();
    
    public ArrayList<Users> selectE(String email);
    
    public Object selectUserHQL(int id);

}

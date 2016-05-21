/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cruds;

import pojos.Phoneofuser;

/**
 *
 * @author hassan
 */
public interface PhoneofuserCrudInt {

    public void insert(Phoneofuser pc);

    public Phoneofuser select(Integer id);

    public void update(Integer id, Phoneofuser pc);

    public void delete(Integer id);

}

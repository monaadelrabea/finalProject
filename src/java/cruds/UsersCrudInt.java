/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cruds;

import pojos.Users;

/**
 *
 * @author hassan
 */
public interface UsersCrudInt {

    public void insert(Users u);

    public Users select(Integer id);

    public void update(Integer id, Users u);

    public void delete(Integer id);

}

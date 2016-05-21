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
public interface CrudInterface {

    public void insert(Object obj);

    public Object select(Integer id);

    public void update(Integer id, Object obj);

    public void delete(Integer id);

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cruds;

import pojos.Comments;

/**
 *
 * @author hassan
 */
public interface ReplyingCrudInt {

    public void insert(Comments replying);

    public Comments select(Integer id);

    public void update(Integer id, Comments replying);

    public void delete(Integer id);

}

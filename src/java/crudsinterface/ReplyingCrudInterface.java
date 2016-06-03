/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudsinterface;

import pojos.Comments;

/**
 *
 * @author hassan
 */
public interface ReplyingCrudInterface {

    public boolean insert(Comments replying);

    public Comments select(Integer id);

    public boolean update(Integer id, Comments replying);

    public boolean delete(Integer id);

}

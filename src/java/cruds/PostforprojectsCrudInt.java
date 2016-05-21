/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cruds;

import pojos.Postforprojects;

/**
 *
 * @author hassan
 */
public interface PostforprojectsCrudInt {

    public void insert(Postforprojects postforprojects);

    public Postforprojects select(Integer id);

    public void update(Integer id, Postforprojects postforprojects);

    public void delete(Integer id);

}

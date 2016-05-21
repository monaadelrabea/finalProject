/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cruds;

import pojos.Porposa;

/**
 *
 * @author hassan
 */
public interface PorposaCrudInt {

    public void insert(Porposa porposa);

    public Porposa select(Integer id);

    public void update(Integer id, Porposa porposa);

    public void delete(Integer id);

}

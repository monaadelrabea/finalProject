/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslayer.businesslogic;

import cruds.PorposaCrud;
import cruds.PorposaCrudInt;
import pojos.Porposa;

/**
 *
 * @author hassan
 */
public class PorposaDelegation implements PorposaDelegationInt {

    @Override
    public void delegateInsert(Porposa porposa) {

        PorposaCrudInt crud = new PorposaCrud();
        crud.insert(porposa);

    }

    @Override
    public Porposa delegateSelect(Integer id) {

        PorposaCrudInt crud = new PorposaCrud();
        return crud.select(id);

    }

    @Override
    public void delegateUpdate(Integer id, Porposa porposa) {

        PorposaCrudInt crud = new PorposaCrud();
        crud.update(id, porposa);

    }

    @Override
    public void delegateDelete(Integer id) {

        PorposaCrudInt crud = new PorposaCrud();
        crud.delete(id);

    }

}

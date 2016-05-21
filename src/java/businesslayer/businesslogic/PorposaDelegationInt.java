package businesslayer.businesslogic;


import pojos.Porposa;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hassan
 */
public interface PorposaDelegationInt {

    public void delegateInsert(Porposa porposa);

    public Porposa delegateSelect(Integer id);

    public void delegateUpdate(Integer id, Porposa porposa);

    public void delegateDelete(Integer id);

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import businesslayer.businesslogic.PhoneofuserDelegation;
import businesslayer.businesslogic.PhoneofuserDelegationInt;
import businesslayer.businesslogic.UsersDelegation;
import businesslayer.businesslogic.UsersDelegationInt;
import pojos.Phoneofuser;
import pojos.Users;

/**
 *
 * @author hassan
 */
public class Test {

    public static void main(String[] args) {

        Users u = new Users();

        UsersDelegationInt ud = new UsersDelegation();

        u = ud.delegateSelect(1);

        Phoneofuser p = new Phoneofuser(u, "2154545121", "khhgdgdfx");
        Phoneofuser p1 = new Phoneofuser(u, "2154545121", "khhgdgdfx");
        Phoneofuser p2 = new Phoneofuser(u, "2154545121", "khhgdgdfx");
        Phoneofuser p3 = new Phoneofuser(u, "2154545121", "khhgdgdfx");

        PhoneofuserDelegationInt pdi = new PhoneofuserDelegation();

        pdi.delegateInsert(p);
        pdi.delegateInsert(p1);
        pdi.delegateInsert(p2);
        pdi.delegateInsert(p3);

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslayer.validations;

import pojos.Users;

/**
 *
 * @author m@pc
 */
public class ValidaionClass {
    public static boolean insertNewUserValidate(String userEmail, String userImageUrl, String password, boolean gender, String userName, int ped, String country, String governorate, String city, String street, String summery, String profissionalTitle, String identifire, String mobile, String phones, String Skills){
        boolean message=true;
       if(userEmail.equals(null)||password.equals(null) ||userName.equals(null)||Skills.equals(null)) {
        message=false;
       }
       return  message;
    }
}
